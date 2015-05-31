package co.edu.udea.appempresariales.ensuranceappjersey.dao;

import co.edu.udea.appempresariales.ensuranceappjersey.dao.implementacion.ClienteDAOImpl;
import co.edu.udea.appempresariales.ensuranceappjersey.dao.implementacion.PolizaDAOImpl;
import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.ClienteDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.PolizaDAO;

/**
 * Clase encargada de retornar los DAOs Correspondientes a cada clase.
 * Usar� el patr�n Singleton y factory
 * @author JuanF
 *
 */
public class DAOFactory {
	
	/**
	 * Constructor Protegido
	 */
	protected DAOFactory() {
		super();
	}



	/**
	 * �nica Instancia de la clase
	 */
	private static DAOFactory instance;
	
	
	/**
	 * Se obtiene la unica instancia de la clase
	 * @return
	 */
	public static DAOFactory getInstance(){
		if(instance == null) {
	         instance = new DAOFactory();
	      }
	      return instance;
		
	}
	/**
	 * Se obtiene una instancia de Cliente DAO
	 * @return
	 */
	public ClienteDAO getClienteDAO(){
		return new ClienteDAOImpl();
	}
	
	/**
	 * Se obtiene una instancia de Poliza DAO
	 * @return
	 */
	public PolizaDAO getPolizaDAO(){
		return new PolizaDAOImpl();
	}

}
