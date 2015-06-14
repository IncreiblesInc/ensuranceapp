/**
 * 
 */
package co.edu.udea.appempresariales.ensuranceappjersey.entities;

import java.io.Serializable;

/**
 * @author davide.gomez
 *
 */
public class Asesor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3943267778379565110L;

	/**
	 * Nombre del asesor
	 */
	
	private String nombreAsesor;
	
	/**
	 * Url que contendra la foto del asesor
	 */
	private String fotoAsesor;
	
	/**
	 * Codigo del asesor
	 */
	private String telefonoAsesor;
	
	/**
	 * Correo electronico del asesor
	 */
	
	private String correoAsesor;
	
	/**
	 * Numero de celular del asesor
	 */
	private String celularAsesor;
	
	/**
	 * Codigo de celular del asesor
	 */
	private String cdAsesor;
	
	

	/**
	 * @param nombreAsesor
	 * @param fotoAsesor
	 * @param telefonoAsesor
	 * @param correoAsesor
	 * @param celularAsesor
	 * @param cdAsesor
	 */
	public Asesor(String nombreAsesor, String fotoAsesor,
			String telefonoAsesor, String correoAsesor, String celularAsesor,
			String cdAsesor) {
		super();
		this.nombreAsesor = nombreAsesor;
		this.fotoAsesor = fotoAsesor;
		this.telefonoAsesor = telefonoAsesor;
		this.correoAsesor = correoAsesor;
		this.celularAsesor = celularAsesor;
		this.cdAsesor = cdAsesor;
	}
	
	

	public Asesor() {
		super();
	}



	/**
	 * @return the nombreAsesor
	 */
	public String getNombreAsesor() {
		return nombreAsesor;
	}

	/**
	 * @param nombreAsesor the nombreAsesor to set
	 */
	public void setNombreAsesor(String nombreAsesor) {
		this.nombreAsesor = nombreAsesor;
	}

	/**
	 * @return the fotoAsesor
	 */
	public String getFotoAsesor() {
		return fotoAsesor;
	}

	/**
	 * @param fotoAsesor the fotoAsesor to set
	 */
	public void setFotoAsesor(String fotoAsesor) {
		this.fotoAsesor = fotoAsesor;
	}

	/**
	 * @return the telefonoAsesor
	 */
	public String getTelefonoAsesor() {
		return telefonoAsesor;
	}

	/**
	 * @param telefonoAsesor the telefonoAsesor to set
	 */
	public void setTelefonoAsesor(String telefonoAsesor) {
		this.telefonoAsesor = telefonoAsesor;
	}

	/**
	 * @return the correoAsesor
	 */
	public String getCorreoAsesor() {
		return correoAsesor;
	}

	/**
	 * @param correoAsesor the correoAsesor to set
	 */
	public void setCorreoAsesor(String correoAsesor) {
		this.correoAsesor = correoAsesor;
	}

	/**
	 * @return the celularAsesor
	 */
	public String getCelularAsesor() {
		return celularAsesor;
	}

	/**
	 * @param celularAsesor the celularAsesor to set
	 */
	public void setCelularAsesor(String celularAsesor) {
		this.celularAsesor = celularAsesor;
	}

	/**
	 * @return the cdAsesor
	 */
	public String getCdAsesor() {
		return cdAsesor;
	}

	/**
	 * @param cdAsesor the cdAsesor to set
	 */
	public void setCdAsesor(String cdAsesor) {
		this.cdAsesor = cdAsesor;
	}
	
	
	

	

}
