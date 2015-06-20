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
	LogicaReclamacion logicaReclamacion;

	public LogicaPoliza() {
		super();
		this.instance = DAOFactory.getInstance();
		polizaDao=instance.getPolizaDAO();
		logicaReclamacion= new LogicaReclamacion();
	}
	
	public List<Poliza> obtenerPolizasVigentesPorCliente(String cedulaCliente) throws BusinessLogicException{
		List<Poliza> polizasCliente=null;
			LogicaCliente clienteLogico=new LogicaCliente();
			Cliente usuario=clienteLogico.consultarCliente(cedulaCliente);
			polizasCliente=polizaDao.consultarPolizasVigentesPorCliente(usuario.getCedula());
			if(polizasCliente==null || polizasCliente.isEmpty()){
				throw new BusinessLogicException("El usuario no tiene polizas vigentes a la fecha");
			}

		return polizasCliente;
 	}
	
	public List<Poliza> obtenerPolizasVigentePorClienteMasReclamaciones(String cedulaCliente) throws BusinessLogicException{
		List<Poliza> polizasCliente=null;
		polizasCliente= obtenerPolizasVigentesPorCliente(cedulaCliente);
		for (Poliza poliza : polizasCliente) {
			try{
			poliza.setReclamaciones(logicaReclamacion.obtenerReclamacionesDeUnaPoliza(poliza.getNumeroPoliza()));
			}catch(BusinessLogicException e){
				/**capto la excepcion, mas no la lanzo ya que no afecta la operacion el hecho
			     **de que una poliza no tenga reclamaciones
			    */
			}
		}
		return polizasCliente;
	}

	public Poliza obtenerDetallePoliza(String poliza) throws BusinessLogicException {
		if (poliza==null ||poliza.trim().equals("")) {
			throw new BusinessLogicException("La poliza no puede estar vacía");
		}
		Poliza polizaDetallada =polizaDao.consultarPoliza(poliza);
		try {
			polizaDetallada.setReclamaciones(logicaReclamacion.obtenerReclamacionesDeUnaPoliza(poliza));
		} catch (Exception e) {
			/**capto la excepcion, mas no la lanzo ya que no afecta la operacion el hecho
		     **de que una poliza no tenga reclamaciones
		    */
		}
		
		return polizaDetallada;
	}
	
	
}
