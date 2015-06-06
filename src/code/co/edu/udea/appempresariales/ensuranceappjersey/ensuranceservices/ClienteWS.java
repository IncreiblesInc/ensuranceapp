package co.edu.udea.appempresariales.ensuranceappjersey.ensuranceservices;



import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;



import co.edu.udea.appempresariales.ensuranceappjersey.entities.Cliente;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Poliza;
import co.edu.udea.appempresariales.ensuranceappjersey.exception.BusinessLogicException;
import co.edu.udea.appempresariales.ensuranceappjersey.exception.TechnicalException;
import co.edu.udea.appempresariales.ensuranceappjersey.negocio.LogicaCliente;
import co.edu.udea.appempresariales.ensuranceappjersey.negocio.LogicaPoliza;

@Path("/cliente")
public class ClienteWS {
	
	LogicaCliente clienteLogico = new LogicaCliente();
	LogicaPoliza polizaLogica = new LogicaPoliza();
	
	
	@GET
	@Produces("application/json")	
	@Path("/getcliente")
	public Cliente getCliente(@QueryParam("cedula") String cedula) throws BusinessLogicException{
		if (cedula==null || cedula.trim().endsWith("")) {
			throw new BusinessLogicException("Debe enviar una cédula");
		}
		try{
			Cliente cliente = clienteLogico.consultarCliente(cedula);
			return(cliente);
		}catch(BusinessLogicException e){
			throw new BusinessLogicException(e,"El usuario buscado no existe.");
			
		}
			
	}
	@GET
	@Path("/polizasvigentes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Poliza> obtenerPolizasVigentesPorCLiente(@QueryParam("cedula")String cedula)throws BusinessLogicException{
		if (cedula==null || cedula.trim().equals("")) {
			throw new BusinessLogicException("Debe enviar una cédula");
		}
		
		List<Poliza> polizasVigentes= polizaLogica.obtenerPolizasVigentesPorCliente(cedula);
		return polizasVigentes;	
	}

	

}