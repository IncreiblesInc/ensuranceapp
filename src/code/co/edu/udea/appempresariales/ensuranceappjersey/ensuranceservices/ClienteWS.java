package co.edu.udea.appempresariales.ensuranceappjersey.ensuranceservices;



import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.udea.appempresariales.ensuranceappjersey.entities.Cliente;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Poliza;
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
	public String getCliente(@PathParam("cedula") String cedula) throws BusinessLogicException{
		if (cedula==null || cedula.trim().equals("")) {
			throw new BusinessLogicException("Debe enviar una cédula");
		}
				
		try{
			Cliente cliente = clienteLogico.consultarCliente(cedula);
			return(gson.serialize(cliente));
		}catch(BusinessLogicException e){
			throw new BusinessLogicException(e,"El usuario buscado no existe.");
			
		}
			
	}
	

}
