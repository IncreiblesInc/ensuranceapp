package co.edu.udea.appempresariales.ensuranceappjersey.ensuranceservices;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.udea.appempresariales.ensuranceappjersey.entities.Poliza;
import co.edu.udea.appempresariales.ensuranceappjersey.exception.BusinessLogicException;
import co.edu.udea.appempresariales.ensuranceappjersey.negocio.LogicaPoliza;

import com.owlike.genson.Genson;


@Path("/polizas")
public class PolizaWS {
	
	LogicaPoliza polizaLogica = new LogicaPoliza();
	Genson gson = new Genson();
	

}
