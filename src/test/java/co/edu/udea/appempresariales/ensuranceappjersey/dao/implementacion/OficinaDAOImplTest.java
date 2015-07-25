package co.edu.udea.appempresariales.ensuranceappjersey.dao.implementacion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.OficinaDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Oficina;

public class OficinaDAOImplTest {

	private OficinaDAO oficinaDao;
	@Before
	public void setUp() throws Exception {
		oficinaDao= new OficinaDAOImpl();
	}

	@Test
	public void testGetOficinaById() {
		Oficina oficina= oficinaDao.getOficinaById("0001");
		assertEquals("Medellin", oficina.getCiudadOficina());
		assertEquals("Central", oficina.getNombreOficina());
		
	}

}
