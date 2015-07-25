package co.edu.udea.appempresariales.ensuranceappjersey.ensuranceservices;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.owlike.genson.Genson;

import co.edu.udea.appempresariales.ensuranceappjersey.entities.Ciudad;
import co.edu.udea.appempresariales.ensuranceappjersey.exception.BusinessLogicException;
import co.edu.udea.appempresariales.ensuranceappjersey.negocio.LogicaCiudad;

@Path("/ciudades")
public class CiudadWS {
	
	LogicaCiudad logicaCiudad = new LogicaCiudad();
	Genson gson = new Genson();
	
	@GET
	@Produces("application/json")
	@Path("/")
	public Response getCiudades(){
		List<Ciudad> ciudades = new ArrayList<Ciudad>();
		try {
			ciudades = logicaCiudad.ObtenerListadoDeCiudades();
			return (Response.ok(gson.serialize(ciudades)).build());
			
		} catch (BusinessLogicException e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}	
					
	}
	

}
