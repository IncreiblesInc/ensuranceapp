package co.edu.udea.appempresariales.ensuranceappjersey.dao.implementacion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.AsesorDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Asesor;

public class AsesorDAOImplTest {

	private AsesorDAO asesorDAO;
	@Before
	public void setUp() throws Exception {
		asesorDAO = new AsesorDAOImpl();
	}

	@Test
	public void testGetAsesorById() {
		Asesor asesor= asesorDAO.getAsesorById("0001");
		assertEquals("Bill Gates", asesor.getNombreAsesor());
		assertEquals("2222222", asesor.getTelefonoAsesor());
	}

}
