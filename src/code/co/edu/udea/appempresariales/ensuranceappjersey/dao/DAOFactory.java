package co.edu.udea.appempresariales.ensuranceappjersey.dao;

import java.util.List;

import co.edu.udea.appempresariales.ensuranceappjersey.dao.implementacion.CiudadDAOImpl;
import co.edu.udea.appempresariales.ensuranceappjersey.dao.implementacion.ClienteDAOImpl;
import co.edu.udea.appempresariales.ensuranceappjersey.dao.implementacion.PolizaDAOImpl;
import co.edu.udea.appempresariales.ensuranceappjersey.dao.implementacion.ReclamacionDAOImpl;
import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.CiudadDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.ClienteDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.PolizaDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.ReclamacionDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Ciudad;

/**
 * Clase encargada de retornar los DAOs Correspondientes a cada clase.
 * Usarà el patrón Singleton y factory
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
	 * Única Instancia de la clase
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

	/**
	 * @return Se obtiene la instancia de la implementación de la reclamación.
	 */
	public ReclamacionDAO getReclamacionDAO(){
		return new ReclamacionDAOImpl();
	}
	
	public CiudadDAO getCiudadDAO(){
		return new CiudadDAOImpl();
	}

}
