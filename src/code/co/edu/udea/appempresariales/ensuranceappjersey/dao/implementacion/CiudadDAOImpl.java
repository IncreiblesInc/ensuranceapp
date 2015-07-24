package co.edu.udea.appempresariales.ensuranceappjersey.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.CiudadDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Ciudad;

public class CiudadDAOImpl implements CiudadDAO {

	public List<Ciudad> obetenrCiudades() {
		List<Ciudad> ciudades =  this.obtenerCiudadesTemporal();
		
		return ciudades;
	}
	
	public List<Ciudad> obtenerCiudadesTemporal() {
		
		List<Ciudad> ciudades= new ArrayList<Ciudad>();
		
		Ciudad cd1= new Ciudad("Medellin");
		Ciudad cd2= new Ciudad("Bogota");
		Ciudad cd3= new Ciudad("Cali");
		Ciudad cd4= new Ciudad("Manizales");
		Ciudad cd5= new Ciudad("Barranquilla");
		ciudades.add(cd1);
		ciudades.add(cd2);
		ciudades.add(cd3);
		ciudades.add(cd4);
		ciudades.add(cd5);		
		return ciudades;
		
	}

}
