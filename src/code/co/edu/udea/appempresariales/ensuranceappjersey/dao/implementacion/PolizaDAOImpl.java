/**
 * 
 */
package co.edu.udea.appempresariales.ensuranceappjersey.dao.implementacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.PolizaDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Asesor;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Oficina;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Poliza;

/**
 * @author JuanF
 *
 */
public class PolizaDAOImpl implements PolizaDAO {

	/* (non-Javadoc)
	 * @see co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.PolizaDAO#consultarPoliza(java.lang.String)
	 */
	public Poliza consultarPoliza(String numeroPoliza) {
		List<Poliza> polizas = this.obtenerPolizasTemporal();
		for (Iterator<Poliza> iterator = polizas.iterator(); iterator.hasNext();) {
			Poliza poliza = (Poliza) iterator.next();
			if (poliza.getNumeroPoliza().equals(numeroPoliza)) {
				return poliza;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.PolizaDAO#consultarPolizasVigentesPorCliente(java.lang.String)
	 */
	public List<Poliza> consultarPolizasVigentesPorCliente(String cedulaCliente) {
		List<Poliza>polizasVigentes= new ArrayList<Poliza>();
		List<Poliza>todasPolizas = this.obtenerPolizasTemporal();
		for (Iterator<Poliza> iterator = todasPolizas.iterator(); iterator.hasNext();) {
			Poliza poliza = (Poliza) iterator.next();
			if (poliza.getCedulaCliente().equals(cedulaCliente) && poliza.getFechaFin().after(new Date())) {
				polizasVigentes.add(poliza);
			}
		}
		return polizasVigentes;
	}
	
	public List<Poliza> obtenerPolizasTemporal(){
		
		  Calendar date = new GregorianCalendar(2016, 3, 7);
		    date.add(Calendar.DAY_OF_MONTH, -7);
		    Date vigencia=date.getTime();
		    Oficina o = new Oficina("Medellin", "Carabobo", "Medellin");
		   Asesor a = new Asesor("Juan Fernando", "", "373873873", "juanfer@asesor.com", "104848933","Medellin");
		    
		List<Poliza> Polizas = new ArrayList<Poliza>();
		Poliza p1 = new Poliza("123", "Vida", new Date() , vigencia, 10000000, "123", new Date() , o,a);
		Poliza p2 = new Poliza("124", "Autos", new Date() , vigencia, 100000000, "123", new Date() , o,a);
		Poliza p3 = new Poliza("121", "Salud", new Date() , vigencia, 133000000, "122", new Date() , o,a);
		Poliza p4 = new Poliza("125", "Empresarial", new Date() , vigencia, 123400000, "111", new Date() , o,a);
		Poliza p5 = new Poliza("127", "Multiriesgo", new Date() , vigencia, 1234000023, "111", new Date() , o,a);
		Polizas.add(p1);
		Polizas.add(p2);
		Polizas.add(p3);
		Polizas.add(p4);
		Polizas.add(p5);
		return Polizas;
	}

}
