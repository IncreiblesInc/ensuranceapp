package co.edu.udea.appempresariales.ensuranceappjersey.entities;

import java.io.Serializable;
import java.util.Date;

public class Reclamacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 842770679688000560L;

	
	/**
	 * Codigo de la reclamacion
	 */
	private String cdReclamacion;
	
	/**
	 * Fecha de la reclamacion
	 */
	private Date fechaReclamacion;
	
	/**
	 * Ciudad de la reclamacion
	 */
	private String ciudadReclamacion;
	
	/**
	 * Valor de la reclamacion
	 */
	private double valorReclamacion;
	
	/**
	 * Motivo de la reclamacion
	 */
	private String motivoReclamacion;
	
	/**
	 * Estado de la reclamacion
	 */
	private String estadoReclamacion;
	
	/**
	 * Fecha de la última actualizacion  de la reclamacion
	 */
	private Date fechaActualizacion;
	
	/**
	 * Numero de póliza de la reclamacion
	 */
	private String numeroPoliza;

	/**
	 * @param cdReclamacion
	 * @param fechaReclamacion
	 * @param ciudadReclamacion
	 * @param valorReclamacion
	 * @param motivoReclamacion
	 * @param estadoReclamacion
	 * @param fechaActualizacion
	 * @param numeroPoliza
	 */
	public Reclamacion(String cdReclamacion, Date fechaReclamacion,
			String ciudadReclamacion, double valorReclamacion,
			String motivoReclamacion, String estadoReclamacion,
			Date fechaActualizacion, String numeroPoliza) {
		super();
		this.cdReclamacion = cdReclamacion;
		this.fechaReclamacion = fechaReclamacion;
		this.ciudadReclamacion = ciudadReclamacion;
		this.valorReclamacion = valorReclamacion;
		this.motivoReclamacion = motivoReclamacion;
		this.estadoReclamacion = estadoReclamacion;
		this.fechaActualizacion = fechaActualizacion;
		this.numeroPoliza = numeroPoliza;
	}
	
	public Reclamacion() {
		super();
	}

	/**
	 * @return the cdReclamacion
	 */
	public String getCdReclamacion() {
		return cdReclamacion;
	}

	/**
	 * @param cdReclamacion the cdReclamacion to set
	 */
	public void setCdReclamacion(String cdReclamacion) {
		this.cdReclamacion = cdReclamacion;
	}

	/**
	 * @return the fechaReclamacion
	 */
	public Date getFechaReclamacion() {
		return fechaReclamacion;
	}

	/**
	 * @param fechaReclamacion the fechaReclamacion to set
	 */
	public void setFechaReclamacion(Date fechaReclamacion) {
		this.fechaReclamacion = fechaReclamacion;
	}

	/**
	 * @return the ciudadReclamacion
	 */
	public String getCiudadReclamacion() {
		return ciudadReclamacion;
	}

	/**
	 * @param ciudadReclamacion the ciudadReclamacion to set
	 */
	public void setCiudadReclamacion(String ciudadReclamacion) {
		this.ciudadReclamacion = ciudadReclamacion;
	}

	/**
	 * @return the valorReclamacion
	 */
	public double getValorReclamacion() {
		return valorReclamacion;
	}

	/**
	 * @param valorReclamacion the valorReclamacion to set
	 */
	public void setValorReclamacion(double valorReclamacion) {
		this.valorReclamacion = valorReclamacion;
	}

	/**
	 * @return the motivoReclamacion
	 */
	public String getMotivoReclamacion() {
		return motivoReclamacion;
	}

	/**
	 * @param motivoReclamacion the motivoReclamacion to set
	 */
	public void setMotivoReclamacion(String motivoReclamacion) {
		this.motivoReclamacion = motivoReclamacion;
	}

	/**
	 * @return the estadoReclamacion
	 */
	public String getEstadoReclamacion() {
		return estadoReclamacion;
	}

	/**
	 * @param estadoReclamacion the estadoReclamacion to set
	 */
	public void setEstadoReclamacion(String estadoReclamacion) {
		this.estadoReclamacion = estadoReclamacion;
	}

	/**
	 * @return the fechaActualizacion
	 */
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	/**
	 * @param fechaActualizacion the fechaActualizacion to set
	 */
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	/**
	 * @return the numeroPoliza
	 */
	public String getNumeroPoliza() {
		return numeroPoliza;
	}

	/**
	 * @param numeroPoliza the numeroPoliza to set
	 */
	public void setNumeroPoliza(String numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}
	
	
	
	
}
