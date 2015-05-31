/**
 * 
 */
package co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces;

import co.edu.udea.appempresariales.ensuranceappjersey.entities.Cliente;

/**
 * Interface para acceder a los datos de los clientes
 * @author JuanF
 *
 */
public interface ClienteDAO {
	/**
	 * Se consulta un cliente por cédula.
	 * @param cedula
	 * @return Cliente si existe, sino retorna null
	 */
	public Cliente consultarCliente(String cedula);

}
