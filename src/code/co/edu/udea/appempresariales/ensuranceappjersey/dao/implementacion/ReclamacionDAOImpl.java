package co.edu.udea.appempresariales.ensuranceappjersey.dao.implementacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.PolizaDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.ReclamacionDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Poliza;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Reclamacion;

/**
 * 
 * Implementación de la clase Data Access Object, que permite acceder a los objetos persistentes
 * de la aplicación.
 * 
 * @author Daniel
 *
 */

public class ReclamacionDAOImpl implements ReclamacionDAO {

	

	public List<Reclamacion> consultarReclamacionesPorCliente(String cedula) {
		if(cedula == null){
			throw new IllegalArgumentException("Debe ingresar alguna cédula");
		}
			PolizaDAO polizaDAO = new PolizaDAOImpl();
			ArrayList<Poliza> polizas = (ArrayList<Poliza>) polizaDAO.consultarPolizasVigentesPorCliente(cedula);
			ArrayList<Reclamacion> reclamaciones = (ArrayList<Reclamacion>) this.obtenerReclamacionesTemporal();
			ArrayList<Reclamacion> reclamacionPorCliente = new ArrayList<Reclamacion>();
			
			for(int i=0;i<reclamaciones.size(); i++){
				Reclamacion reclamacion = reclamaciones.get(i);
				 String numPoliza = reclamaciones.get(i).getNumeroPoliza();
				 for(int j =0; j<polizas.size(); j++){
					 Poliza poliza = polizas.get(j);
					 if(poliza.getNumeroPoliza().equals(numPoliza)){
						 reclamacionPorCliente.add(reclamacion);
					 }
				 }
			}
			return reclamacionPorCliente;

		
	}
	
	

	public List<Reclamacion> obtenerReclamacionesTemporal(){
		String[] codigos  = {"123","124","121","125","127"};
		ArrayList<Reclamacion> reclamaciones = new ArrayList<Reclamacion>();
		for(int i =0; i<5;i++){
			Reclamacion r = new Reclamacion("medellin", new Date(), "Medellin", 250000, "Garantia", "En proceso", new Date(), codigos[i]);
			reclamaciones.add(r);
			if(i==0){
				 r = new Reclamacion("medellin", new Date(), "Medellin", 250000, "Garantia", "En proceso", new Date(), codigos[i]);
				reclamaciones.add(r);
			}
		}
		
		return reclamaciones;
	}


	public List<Reclamacion> consultarReclamacionesPorPoliza(String numeroPoliza) throws IllegalArgumentException {
		if(numeroPoliza == null){
			throw new IllegalArgumentException();
		}
		
		ArrayList<Reclamacion> reclamacionesPorPoliza = new ArrayList<Reclamacion>();
		ArrayList<Reclamacion> reclamaciones = (ArrayList<Reclamacion>) this.obtenerReclamacionesTemporal();
		
		for(int i=0;i<reclamaciones.size(); i++){
			Reclamacion reclamacion = reclamaciones.get(i);
				 if(reclamacion.getNumeroPoliza().equals(numeroPoliza)){
					 reclamacionesPorPoliza.add(reclamacion);
				 }
		}
		
		return reclamacionesPorPoliza;
	}

}
