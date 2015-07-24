package co.edu.udea.appempresariales.ensuranceappjersey.negocio;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import co.edu.udea.appempresariales.ensuranceappjersey.dao.DAOFactory;
import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.ReclamacionDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Cliente;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Reclamacion;
import co.edu.udea.appempresariales.ensuranceappjersey.exception.BusinessLogicException;

public class LogicaReclamacion {

	DAOFactory instance;
	ReclamacionDAO reclamacionDao;
	
	public LogicaReclamacion() {
		super();
		this.instance = DAOFactory.getInstance();
		reclamacionDao=instance.getReclamacionDAO();
	}
	
	
	public List<Reclamacion> obtenerReclamacionesVigentesPorCliente(String cedulaCliente) throws BusinessLogicException{
		List<Reclamacion> reclamaciones=null;
		LogicaCliente clienteLogico = new LogicaCliente();
		Cliente usuario = clienteLogico.consultarCliente(cedulaCliente);
		reclamaciones=reclamacionDao.consultarReclamacionesPorCliente(usuario.getCedula());
		if(reclamaciones==null||reclamaciones.isEmpty()){
			throw new BusinessLogicException("El usuario no tiene Reclamaciones pertenientes a sus polizas vigentes");
		}		
		return reclamaciones;
	}
	
	public List<Reclamacion> obtenerReclamacionesDeUnaPoliza(String numeroPoliza) throws BusinessLogicException{
		List<Reclamacion> reclamacionesPoliza=null;
		reclamacionesPoliza=reclamacionDao.consultarReclamacionesPorPoliza(numeroPoliza);
		if(reclamacionesPoliza==null||reclamacionesPoliza.isEmpty()){
			throw new BusinessLogicException("La poliza no tiene Reclamaciones");
		}
		
		return reclamacionesPoliza;		
	}
	
	public void guardarReclamacion(Reclamacion reclamacion) throws BusinessLogicException{
		

		Date fecha = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		cal.add(Calendar.DATE, -5);
		Date fechaAux = cal.getTime();
		
		
		if(reclamacion.getValorReclamacion()<=0){
			throw new BusinessLogicException("EL valor de la reclamacion debe ser mayor a cero");
		}
		
		if(reclamacion.getFechaReclamacion().after(fecha)){
			throw new BusinessLogicException("La fecha de reclamacion no puede ser mayor a la fecha actual");
		}
		
		if(reclamacion.getFechaReclamacion().before(fecha)){
			throw new BusinessLogicException("La fecha de reclamacion no puede ser menor en 5 dias de la fecha actual");
		}
		
		reclamacionDao.guardarReclamacion(reclamacion);
		
	}
	
}
