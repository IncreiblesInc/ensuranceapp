package co.edu.udea.appempresariales.ensuranceappjersey.ensuranceservices;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import co.edu.udea.appempresariales.ensuranceappjersey.entities.Cliente;
import co.edu.udea.appempresariales.ensuranceappjersey.exception.BusinessLogicException;
import co.edu.udea.appempresariales.ensuranceappjersey.negocio.LogicaCliente;
import co.edu.udea.appempresariales.ensuranceappjersey.negocio.LogicaPoliza;

import com.owlike.genson.Genson;

@Path("/clientes")
public class ClienteWS {
	
	LogicaCliente clienteLogico = new LogicaCliente();
	LogicaPoliza polizaLogica = new LogicaPoliza();
	Genson gson = new Genson();
	@GET
	@Produces("application/json")	
	@Path("/{cedula}")
	public Response getCliente(@PathParam("cedula") String cedula){
		if (cedula==null || cedula.trim().equals("")) {
			Response.status(Response.Status.BAD_REQUEST).build();
		}
				
		try{
			Cliente cliente = clienteLogico.consultarCliente(cedula);
			return(Response.ok(gson.serialize(cliente)).build());
		}catch(BusinessLogicException e){
			return Response.status(Response.Status.NOT_FOUND).build();
			
		}
			
	}
	

}
