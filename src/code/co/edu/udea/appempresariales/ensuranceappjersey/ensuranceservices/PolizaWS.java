package co.edu.udea.appempresariales.ensuranceappjersey.ensuranceservices;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import co.edu.udea.appempresariales.ensuranceappjersey.entities.Poliza;
import co.edu.udea.appempresariales.ensuranceappjersey.exception.BusinessLogicException;
import co.edu.udea.appempresariales.ensuranceappjersey.negocio.LogicaPoliza;


@Path("/poliza")
public class PolizaWS {
	
	LogicaPoliza polizaLogica = new LogicaPoliza();
	Gson gson = new Gson();
	@GET
	@Path("{cedula}")
	@Produces(MediaType.APPLICATION_JSON)
	public String obtenerPolizasVigentesPorCLiente(@PathParam("cedula")String cedula)throws BusinessLogicException{
		if (cedula==null || cedula.trim().equals("")) {
			throw new BusinessLogicException("Debe enviar una cédula");
		}
		
		List<Poliza> polizasVigentes= polizaLogica.obtenerPolizasVigentesPorCliente(cedula);
		return (gson.toJson(polizasVigentes));	
	}

}
