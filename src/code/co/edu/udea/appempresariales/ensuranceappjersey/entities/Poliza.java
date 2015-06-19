package co.edu.udea.appempresariales.ensuranceappjersey.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="poliza")
public class Poliza implements Serializable {
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 9039655406700583779L;
	/**
	 * Es el n�mero de la p�liza
	 */
	private String numeroPoliza;
	/**
	 * Es el nombre del producto que tiene la p�liza
	 */
	private String nombreProducto;
	/**
	 * Es la Fecha de inicio de vigencia de la p�liza. 
	 */
	private Date fechaInicio;
	
	/**
	 * Es la Fecha de fin de vigencia de la p�liza.
	 */
	private Date fechaFin;
	
	/**
	 * Es el capital que asegura el cliente.
	 */
	private double valorAsegurado;
	
	/**
	 * La c�dula del cliente quien compr� la p�liza.
	 */
	private String cedulaCliente;
	
	/**
	 * Atributo para identificar la fecha de expedición de la póliza
	 */
	private Date fechaExpedicion;
	
	/**
	 * Oficina de la póliza
	 */
	private Oficina oficina;
	
	/**
	 * Asesor de la póliza
	 */
	private Asesor asesor;
	
	/**
	 * Lista de reclamaciones de una p�liza
	 */
	private List<Reclamacion> reclamaciones;
	

	/**
	 * @param numeroPoliza
	 * @param nombreProducto
	 * @param fechaInicio
	 * @param fechaFin
	 * @param valorAsegurado
	 * @param cedulaCliente
	 * @param fechaExpedicion
	 * @param oficina
	 * @param asesor
	 */
	public Poliza(String numeroPoliza, String nombreProducto, Date fechaInicio,
			Date fechaFin, double valorAsegurado, String cedulaCliente,
			Date fechaExpedicion, Oficina oficina, Asesor asesor) {
		super();
		this.numeroPoliza = numeroPoliza;
		this.nombreProducto = nombreProducto;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.valorAsegurado = valorAsegurado;
		this.cedulaCliente = cedulaCliente;
		this.fechaExpedicion = fechaExpedicion;
		this.oficina = oficina;
		this.asesor = asesor;
	}
	
	public Poliza() {
		super();
	}
	
	
	
	/**
	 * @return the asesor
	 */
	public Asesor getAsesor() {
		return asesor;
	}



	/**
	 * @param asesor the asesor to set
	 */
	public void setAsesor(Asesor asesor) {
		this.asesor = asesor;
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

	/**
	 * @return the nombreProducto
	 */
	public String getNombreProducto() {
		return nombreProducto;
	}

	/**
	 * @param nombreProducto the nombreProducto to set
	 */
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the valorAsegurado
	 */
	public double getValorAsegurado() {
		return valorAsegurado;
	}

	/**
	 * @param valorAsegurado the valorAsegurado to set
	 */
	public void setValorAsegurado(double valorAsegurado) {
		this.valorAsegurado = valorAsegurado;
	}

	/**
	 * @return the cedulaCliente
	 */
	public String getCedulaCliente() {
		return cedulaCliente;
	}

	/**
	 * @param cedulaCliente the cedulaCliente to set
	 */
	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	/**
	 * @return the fechaExpedicion
	 */
	public Date getFechaExpedicion() {
		return fechaExpedicion;
	}

	/**
	 * @param fechaExpedicion the fechaExpedicion to set
	 */
	public void setFechaExpedicion(Date fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}

	/**
	 * @return the oficina
	 */
	public Oficina getOficina() {
		return oficina;
	}

	/**
	 * @param oficina the oficina to set
	 */
	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}

	public List<Reclamacion> getReclamaciones() {
		return reclamaciones;
	}

	public void setReclamaciones(List<Reclamacion> reclamaciones) {
		this.reclamaciones = reclamaciones;
	}
	
	

}
