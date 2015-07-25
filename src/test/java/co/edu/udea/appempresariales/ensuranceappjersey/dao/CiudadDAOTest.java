package co.edu.udea.appempresariales.ensuranceappjersey.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.edu.udea.appempresariales.ensuranceappjersey.dao.implementacion.CiudadDAOImpl;
import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.CiudadDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Ciudad;

public class CiudadDAOTest {
	CiudadDAO ciudadDAO;
	
	@Before
	public void Before(){
		//Debería preparar valores de prueba en la base de datos
	}
	@After
	public void After(){
		//Debería liberar los datos de prueba.
	}
	
	@Test
	public void deberiaEntregarTodasCiudades() {
		int expected=8;
		ciudadDAO=new CiudadDAOImpl();
		List<Ciudad> ciudades=ciudadDAO.obetenrCiudades();
		assertEquals("Espero 8 ciudades", expected, ciudades.size());
	}

}
