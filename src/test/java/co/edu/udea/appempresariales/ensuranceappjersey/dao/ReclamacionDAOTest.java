package co.edu.udea.appempresariales.ensuranceappjersey.dao;


import static org.junit.Assert.fail;

import static org.junit.Assert.assertEquals;


import java.util.ArrayList;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.edu.udea.appempresariales.ensuranceappjersey.dao.implementacion.ReclamacionDAOImpl;
import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.ReclamacionDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Reclamacion;

public class ReclamacionDAOTest {

	ReclamacionDAO reclamacionDAO;
	
	@Before
	public void Before(){
		//Debería preparar valores de prueba en la base de datos
	}
	@After
	public void After(){
		//Debería liberar los datos de prueba.
	}
	
	@Test
	public void DeberiaEntregarListaPolizaDeUnCliente() {
		reclamacionDAO = new ReclamacionDAOImpl();
		ArrayList<Reclamacion> reclamaciones = (ArrayList<Reclamacion>) reclamacionDAO.consultarReclamacionesPorCliente("0001");
		assertEquals("Debe entregar 3 reclamaciones", 3, reclamaciones.size());
	}
	
	@Test
	public void DeberiaEntregarCeroReclamacionesSiNoExisteCliente() {
		reclamacionDAO = new ReclamacionDAOImpl();
		ArrayList<Reclamacion> reclamaciones = (ArrayList<Reclamacion>) reclamacionDAO.consultarReclamacionesPorCliente("47474");
		assertEquals("Debe entregar 0 reclamaciones", 0, reclamaciones.size());
	}
	
	@Test
	public void DeberiaLanzarExcepcionSiNoEnviaCedulaNULL() {
		reclamacionDAO = new ReclamacionDAOImpl();
		try{
			ArrayList<Reclamacion> reclamaciones = (ArrayList<Reclamacion>) reclamacionDAO.consultarReclamacionesPorCliente(null);
			fail();
		}catch(IllegalArgumentException ilegal){	
			assertEquals("Si lanza excepcion, pasa la prueba", 1,1);
		}
	}
	
	@Test
	public void DeberiaRetornarReclamacionesDadaUnaPoliza(){
		reclamacionDAO = new ReclamacionDAOImpl();
		ArrayList<Reclamacion> reclamaciones = (ArrayList<Reclamacion>) reclamacionDAO.consultarReclamacionesPorPoliza("1122334455");
		assertEquals("Debe entregar 0 reclamaciones", 2, reclamaciones.size());
	}
	
	@Test
	public void DeberiaRetornarNumeroReclamacionesDadaUnaPoliza(){
		reclamacionDAO = new ReclamacionDAOImpl();
		ArrayList<Reclamacion> reclamaciones = (ArrayList<Reclamacion>) reclamacionDAO.consultarReclamacionesPorPoliza("123");
		assertEquals("Debe entregar 2 reclamaciones", 2, reclamaciones.size());
	}
	
	@Test
	public void DeberiaRetornarCeroReclamacionesSiNoExistePoliza(){
		reclamacionDAO = new ReclamacionDAOImpl();
		ArrayList<Reclamacion> reclamaciones = (ArrayList<Reclamacion>) reclamacionDAO.consultarReclamacionesPorPoliza("4553");
		assertEquals("Debe entregar 0 reclamaciones", 0, reclamaciones.size());
	}
	
	@Test
	public void DeberiaRetornarExcepcionSiPolizaEsNULL(){
		reclamacionDAO = new ReclamacionDAOImpl();
		try{
			ArrayList<Reclamacion> reclamaciones = (ArrayList<Reclamacion>) reclamacionDAO.consultarReclamacionesPorPoliza(null);
			fail();
		}catch(IllegalArgumentException ilegal){	
			assertEquals("Si lanza excepcion, pasa la prueba", 1,1);
		}
	}

	
}
