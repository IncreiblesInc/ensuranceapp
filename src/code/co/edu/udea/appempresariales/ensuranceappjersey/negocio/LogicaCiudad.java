package co.edu.udea.appempresariales.ensuranceappjersey.negocio;

import java.util.List;

import co.edu.udea.appempresariales.ensuranceappjersey.dao.DAOFactory;
import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.CiudadDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Ciudad;
import co.edu.udea.appempresariales.ensuranceappjersey.exception.BusinessLogicException;


public class LogicaCiudad {

	DAOFactory instance;
	CiudadDAO ciudadDAO;
	public LogicaCiudad() {
		super();
		this.instance = DAOFactory.getInstance();
		this.ciudadDAO = instance.getCiudadDAO();
	}
	
	public List<Ciudad> ObtenerListadoDeCiudades() throws BusinessLogicException{
		List<Ciudad> ciudades = ciudadDAO.obetenrCiudades();
		
		if(ciudades==null){
			throw new BusinessLogicException("No se logro recuperar un listado de Ciudades");
		}
		return ciudades;
		
	}
	
}
