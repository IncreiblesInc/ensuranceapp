package co.edu.udea.appempresariales.ensuranceappjersey.negocio;

import java.util.List;

import co.edu.udea.appempresariales.ensuranceappjersey.dao.DAOFactory;
import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.PolizaDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Cliente;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Poliza;
import co.edu.udea.appempresariales.ensuranceappjersey.exception.BusinessLogicException;

public class LogicaPoliza {

	DAOFactory instance;
	PolizaDAO polizaDao;

	public LogicaPoliza() {
		super();
		this.instance = DAOFactory.getInstance();
		polizaDao=instance.getPolizaDAO();
	}
	
	public List<Poliza> polizasVigentesPorCliente(String cedulaCliente) throws BusinessLogicException{
		List<Poliza> polizasCliente=null;
		LogicaCliente clienteLogico=new LogicaCliente();
		Cliente usuario=clienteLogico.consultarCliente(cedulaCliente);
		if(usuario==null){
			throw new BusinessLogicException("El usuario buscado no existe.");
		}
		polizasCliente=polizaDao.consultarPolizasVigentesPorCliente(usuario.getCedula());
		if(polizasCliente==null || polizasCliente.isEmpty()){
			throw new BusinessLogicException("El usuario no tiene polizas vigentes a la fecha");
		}
		return polizasCliente;
 	}
	
	
}
