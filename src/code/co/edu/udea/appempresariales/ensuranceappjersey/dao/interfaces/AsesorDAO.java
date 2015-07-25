package co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces;

import co.edu.udea.appempresariales.ensuranceappjersey.entities.Asesor;

public interface AsesorDAO {
	
	/**
	 * Retorna un asesor dado un código de asesor
	 * @param codigoAsesor
	 * @return Asesor todos los datos
	 */
	public Asesor getAsesorById(String codigoAsesor);

}
