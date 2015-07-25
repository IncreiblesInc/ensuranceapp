package co.edu.udea.appempresariales.ensuranceappjersey.dao.implementacion;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.PolizaDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Poliza;

public class PolizaDAOImplTest {
	
	private PolizaDAO polizaDAO;

	@Before
	public void setUp() throws Exception {
		polizaDAO= new PolizaDAOImpl();
	}

	@Test
	public void testConsultarPoliza() {
		Poliza poliza = polizaDAO.consultarPoliza("1122334466");
		assertEquals("Vida", poliza.getNombreProducto());
		assertEquals("Sede Poblado", poliza.getOficina().getNombreOficina());
		assertEquals("3333333", poliza.getAsesor().getTelefonoAsesor());
	}

	@Test
	public void testConsultarPolizasVigentesPorCliente() {
		List<Poliza> polizasVigentes=polizaDAO.consultarPolizasVigentesPorCliente("0002");
		assertEquals(2, polizasVigentes.size());
	}

}
