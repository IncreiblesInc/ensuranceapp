/**
 * 
 */
package co.edu.udea.appempresariales.ensuranceappjersey.entities;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author JuanF
 *
 */
/**
 * @author JuanF
 *
 */

@XmlRootElement(name="cliente")
public class Cliente implements Serializable{
	
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 4421877963920736525L;
	/**
	 * Nombres del cliente
	 */
	private String nombres;
	/**
	 * Apellidos del Cliente
	 */
	private String apellidos;
	/**
	 * Cédula del cliente.
	 */
	private String cedula;
	/**
	 * Fecha de nacimiento del cliente
	 */
	private Date fechaNacimiento;
	/**
	 * Ciudad de residencia del cliente.
	 */
	private String ciudad;
	/**
	 * Departamento de residencia del cliente.
	 */
	private String departamento;
	
	
	/**
	 * @param nombres
	 * @param apellidos
	 * @param cedula
	 * @param fechaNacimiento
	 * @param ciudad
	 * @param departamento
	 */
	public Cliente(String nombres, String apellidos, String cedula,
			Date fechaNacimiento, String ciudad, String departamento) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.cedula = cedula;
		this.fechaNacimiento = fechaNacimiento;
		this.ciudad = ciudad;
		this.departamento = departamento;
	}
	
	
	public Cliente() {
		super();
	}


	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}
	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}
	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}
	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	/**
	 * @return the departamento
	 */
	public String getDepartamento() {
		return departamento;
	}
	/**
	 * @param departamento the departamento to set
	 */
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	

}
