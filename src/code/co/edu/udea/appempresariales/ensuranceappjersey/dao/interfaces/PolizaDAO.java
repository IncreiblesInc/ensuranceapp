/**
 * 
 */
package co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces;

import java.util.List;

import co.edu.udea.appempresariales.ensuranceappjersey.entities.Poliza;

/**
 * Interfaz para acceder a los datos de las pólizas
 * @author JuanF
 *
 */
public interface PolizaDAO {
	/**
	 * Consulta poliza por número
	 * @param numeroPoliza
	 * @return La póliza si existe, sino retorna null.
	 */
	public Poliza consultarPoliza(String numeroPoliza);
	
	/**
	 * retorna las pólizas vigentes del cliente según la cédula ingresada
	 * @param cedulaCliente
	 * @return retorna una lista con las pólizas vigentes por cliente; si la lista está vacía,
	 * el cliente no tiene pólizas vigentes o no existe
	 */
	public List<Poliza> consultarPolizasVigentesPorCliente(String cedulaCliente);
	
	

}
