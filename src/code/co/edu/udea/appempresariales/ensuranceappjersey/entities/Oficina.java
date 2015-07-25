/**
 * 
 */
package co.edu.udea.appempresariales.ensuranceappjersey.entities;

import java.io.Serializable;

/**
 * @author davide.gomez
 *
 */
public class Oficina implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 5082967601800483919L;

	/**
	 * Ciudad donde se encuentra la oficina.
	 */
	private String ciudadOficina;

	/**
	 * Nombre de la oficina
	 */

	private String nombreOficina;

	/**
	 * Identificador único de la oficina.
	 */

	private String codigoOficina;

	/**
	 * 
	 * Constructor
	 * 
	 * @param ciudad
	 * @param nombreOficina
	 * @param cdOficina
	 */
	public Oficina(String ciudad, String nombreOficina, String cdOficina) {
		super();
		this.ciudadOficina = ciudad;
		this.nombreOficina = nombreOficina;
		this.codigoOficina = cdOficina;
	}

	public Oficina() {
		super();
	}

	/**
	 * @return the ciudad
	 */
	public String getCiudadOficina() {
		return ciudadOficina;
	}

	/**
	 * @param ciudad
	 *            the ciudad to set
	 */
	public void setCiudadOficina(String ciudad) {
		this.ciudadOficina = ciudad;
	}

	/**
	 * @return the nombreOficina
	 */
	public String getNombreOficina() {
		return nombreOficina;
	}

	/**
	 * @param nombreOficina
	 *            the nombreOficina to set
	 */
	public void setNombreOficina(String nombreOficina) {
		this.nombreOficina = nombreOficina;
	}

	/**
	 * @return the cdOficina
	 */
	public String getCodigoOficina() {
		return codigoOficina;
	}

	/**
	 * @param cdOficina
	 *            the cdOficina to set
	 */
	public void setCodigoOficina(String cdOficina) {
		this.codigoOficina = cdOficina;
	}

}
