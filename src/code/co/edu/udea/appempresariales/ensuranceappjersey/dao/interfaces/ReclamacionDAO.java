package co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces;

import java.util.List;

import co.edu.udea.appempresariales.ensuranceappjersey.entities.Reclamacion;

public interface ReclamacionDAO {

	
	/**
	 * 
	 * @param numeroPoliza Corresponde al identificador de la poliza de la cual se desean cargar las reclamaciones.
	 * @return Lista de reclamaciones correspondientes a la poliza. 
	 */
	public List<Reclamacion> consultarReclamacionesPorPoliza(String numeroPoliza);
	
	/**
	 * 
	 * @param cedula Recibe la cedula del cliente de la que desean listar las reclamaciones.
	 * @return Lista de reclamaciones realizadas por el cliente.
	 */
	public List<Reclamacion> consultarReclamacionesPorCliente(String cedula);
	
	/**
	 * 
	 * @return Lista de reclamaciones existentes en la base de datos.
	 */
	public List<Reclamacion> obtenerReclamacionesTemporal();
	
	
	/**
	 * Metodo que guarda una reclamacion
	 * @param reclamacion
	 */
	public void guardarReclamacion(Reclamacion reclamacion);
}
