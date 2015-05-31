package co.edu.udea.appempresariales.ensuranceappjersey.entities;

import java.util.Date;

public class Poliza {
	/**
	 * Es el número de la póliza
	 */
	private String numeroPoliza;
	/**
	 * Es el nombre del producto que tiene la póliza
	 */
	private String nombreProducto;
	/**
	 * Es la Fecha de inicio de vigencia de la póliza. 
	 */
	private Date fechaInicio;
	
	/**
	 * Es la Fecha de fin de vigencia de la póliza.
	 */
	private Date fechaFin;
	
	/**
	 * Es el capital que asegura el cliente.
	 */
	private double valorAsegurado;
	
	/**
	 * La cédula del cliente quien compró la póliza.
	 */
	private String cedulaCliente;
	
	/**
	 * Constructor con todos los atributos
	 * @param numeroPoliza
	 * @param nombreProducto
	 * @param fechaInicio
	 * @param fechaFin
	 * @param valorAsegurado
	 * @param cedulaCliente
	 */
	public Poliza(String numeroPoliza, String nombreProducto, Date fechaInicio,
			Date fechaFin, double valorAsegurado, String cedulaCliente) {
		super();
		this.numeroPoliza = numeroPoliza;
		this.nombreProducto = nombreProducto;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.valorAsegurado = valorAsegurado;
		this.cedulaCliente = cedulaCliente;
	}
	public String getNumeroPoliza() {
		return numeroPoliza;
	}
	public void setNumeroPoliza(String numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public double getValorAsegurado() {
		return valorAsegurado;
	}
	public void setValorAsegurado(double valorAsegurado) {
		this.valorAsegurado = valorAsegurado;
	}
	public String getCedulaCliente() {
		return cedulaCliente;
	}
	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

}
