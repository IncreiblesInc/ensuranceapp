package co.edu.udea.appempresariales.ensuranceappjersey.negocio;

import co.edu.udea.appempresariales.ensuranceappjersey.dao.DAOFactory;
import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.ClienteDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Cliente;
import co.edu.udea.appempresariales.ensuranceappjersey.exception.BusinessLogicException;

/**
*
* @author davide.gomez
*/

public class LogicaCliente {

	DAOFactory instance;
	ClienteDAO clienteDAO;
	
	public LogicaCliente() {
		super();
		this.instance = DAOFactory.getInstance();
		clienteDAO=instance.getClienteDAO();
	}
	
	public Cliente consultarCliente(String cedula) throws BusinessLogicException{
		Cliente usuario=null;
		usuario=clienteDAO.consultarCliente(cedula);
		if (usuario==null){
			throw new BusinessLogicException("El usuario buscado no existe.");
		}
		return usuario;
	}
	
	
}
