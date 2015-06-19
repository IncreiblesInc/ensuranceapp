package co.edu.udea.appempresariales.ensuranceappjersey.ensuranceservices;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.edu.udea.appempresariales.ensuranceappjersey.entities.Poliza;
import co.edu.udea.appempresariales.ensuranceappjersey.exception.BusinessLogicException;
import co.edu.udea.appempresariales.ensuranceappjersey.negocio.LogicaPoliza;

import com.owlike.genson.Genson;


@Path("/polizas")
public class PolizaWS {
	
	LogicaPoliza polizaLogica = new LogicaPoliza();
	Genson gson = new Genson();
	@GET
	@Path("/cliente/{cedula}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerPolizasVigentesPorCLiente(@PathParam("cedula")String cedula){
		if (cedula==null || cedula.trim().equals("")) {
			Response.status(Response.Status.BAD_REQUEST).build();
		}
		
		List<Poliza> polizasVigentes=new ArrayList<Poliza>();
		try {
			polizasVigentes = polizaLogica.obtenerPolizasVigentesPorCliente(cedula);
			
		} catch (BusinessLogicException e) {
			Response.status(Response.Status.NOT_FOUND);
		}
		return (Response.ok(gson.serialize(polizasVigentes)).build());
	}
	
	
	@GET
	@Path("/{poliza}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerInfoPoliza(@PathParam("poliza")String poliza){
		Poliza polizaDetallada= new Poliza();
		if (poliza==null || poliza.trim().equals("")) {
			Response.status(Response.Status.BAD_REQUEST).build();
		}
		try {
			polizaDetallada = polizaLogica.obtenerDetallePoliza(poliza);
		} catch (BusinessLogicException e) {
			Response.status(Response.Status.NOT_FOUND);
		}
		return (Response.ok(gson.serialize(polizaDetallada)).build());
	}

}
