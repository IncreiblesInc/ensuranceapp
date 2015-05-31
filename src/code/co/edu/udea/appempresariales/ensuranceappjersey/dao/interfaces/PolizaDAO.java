/**
 * 
 */
package co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces;

import java.util.List;

import co.edu.udea.appempresariales.ensuranceappjersey.entities.Poliza;

/**
 * Interfaz para acceder a los datos de las p�lizas
 * @author JuanF
 *
 */
public interface PolizaDAO {
	/**
	 * Consulta poliza por n�mero
	 * @param numeroPoliza
	 * @return La p�liza si existe, sino retorna null.
	 */
	public Poliza consultarPoliza(String numeroPoliza);
	
	/**
	 * retorna las p�lizas vigentes del cliente seg�n la c�dula ingresada
	 * @param cedulaCliente
	 * @return retorna una lista con las p�lizas vigentes por cliente; si la lista est� vac�a,
	 * el cliente no tiene p�lizas vigentes o no existe
	 */
	public List<Poliza> consultarPolizasVigentesPorCliente(String cedulaCliente);
	
	

}
