package co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces;

import co.edu.udea.appempresariales.ensuranceappjersey.entities.Oficina;

public interface OficinaDAO {
	/**
	 * Funcion para obtener una oficina por id
	 * @param codigoOficina
	 * @return Una oficina según el id
	 */
	public Oficina getOficinaById(String codigoOficina);

}
