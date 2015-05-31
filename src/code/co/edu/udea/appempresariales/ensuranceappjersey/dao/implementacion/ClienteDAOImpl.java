/**
 * 
 */
package co.edu.udea.appempresariales.ensuranceappjersey.dao.implementacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.ClienteDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Cliente;

/**
 * @author JuanF
 *
 */
public class ClienteDAOImpl implements ClienteDAO {

	/* (non-Javadoc)
	 * @see co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.ClienteDAO#consultarCliente(java.lang.String)
	 */
	public Cliente consultarCliente(String cedula) {
		List<Cliente> clientes = this.obtenerClientesTemporal();
		for (Iterator<Cliente> iterator = clientes.iterator(); iterator.hasNext();) {
			Cliente cliente = (Cliente) iterator.next();
			if (cliente.getCedula().equals(cedula)) {
				return cliente;
			}
		}
		return null;
	}
	
	public List<Cliente> obtenerClientesTemporal(){
		List<Cliente> clientes = new ArrayList<Cliente>();
		Cliente c1 = new Cliente("Juan Fernando", "Molina Florez", "123", new Date(), "Medellin", "Antioquia");
		Cliente c2 = new Cliente("Andrés", "Mercado", "111", new Date(), "Medellin", "Antioquia");
		Cliente c3 = new Cliente("Juana", "Molina Florez", "222", new Date(), "Medellin", "Antioquia");
		Cliente c4 = new Cliente("Juan Andrés", "Palacio Florez", "321", new Date(), "Jericó", "Antioquia");
		Cliente c5 = new Cliente("Monica Fernanda", "Garcia Florez", "112", new Date(), "Bogotá", "Cundinamarca");
		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);
		clientes.add(c4);
		clientes.add(c5);
		return clientes;
	}

}
