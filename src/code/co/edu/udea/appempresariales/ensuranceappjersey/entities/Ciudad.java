package co.edu.udea.appempresariales.ensuranceappjersey.entities;

import java.io.Serializable;
/**
 * @author Esteban Alvarez
 * 
 */
public class Ciudad implements Serializable{
	
	
	/**
	 * seria ID
	 */
	private static final long serialVersionUID = -7138001665531218893L;
	
	
	/**
	 * Nombre de la ciudad
	 */
	String nombreCiudad;
	
	/**
	 * 
	 * @param nombreCiudad nombre de la ciudad
	 */
	public Ciudad(String nombreCiudad) {
		super();
		this.nombreCiudad = nombreCiudad;
	}

	/**
	 * 
	 * @return nombre de la ciudad
	 */
	public String getNombreCiudad() {
		return nombreCiudad;
	}

	/**
	 * 
	 * @param nombreCiudad nombre de la ciudad
	 */
	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}
	
	
	

}

