/**
 * 
 */
package co.edu.udea.appempresariales.ensuranceappjersey.dao.implementacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.ClienteDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Cliente;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Reclamacion;

/**
 * @author JuanF
 *
 */
public class ClienteDAOImpl implements ClienteDAO {

	private static final String DATA_BASE_URI = "mongodb://appempresariales:aPP3mPr35ar1a13s@ds047692.mongolab.com:47692/heroku_4dmddk2h";
	private static final String CLIENTES_NAME_COLLECTION = "clientes";

	private MongoClientURI clientURI;
	private MongoClient mongoClient;

	public ClienteDAOImpl() {

	}

	public Cliente consultarCliente(String cedula) {
		Cliente cliente = null;
		// Configuración para la obtención de los datos
		clientURI = new MongoClientURI(DATA_BASE_URI);
		mongoClient = new MongoClient(clientURI);
		DB dataBase = mongoClient.getDB(clientURI.getDatabase());
		DBCollection collectionOfClients = dataBase.getCollection(CLIENTES_NAME_COLLECTION);
		BasicDBObject findQuery= new BasicDBObject("cedulaCliente", cedula);
		DBCursor documentos= collectionOfClients.find(findQuery);
		if(documentos.hasNext()){
			DBObject documento= documentos.next();
			cliente=new Cliente((String)documento.get("nombreCliente"),
					(String)documento.get("nombreCliente"));
		}
		return cliente;
	}

	/*
	 * List<Cliente> clientes = this.obtenerClientesTemporal(); for
	 * (Iterator<Cliente> iterator = clientes.iterator(); iterator.hasNext();) {
	 * Cliente cliente = (Cliente) iterator.next(); if
	 * (cliente.getCedula().equals(cedula)) { return cliente; } } return null;
	 */

	/*
	 * public List<Cliente> obtenerClientesTemporal(){ List<Cliente> clientes =
	 * new ArrayList<Cliente>(); Cliente c1 = new Cliente("Juan Fernando",
	 * "Molina Florez", "123", new Date(), "Medellin", "Antioquia"); Cliente c2
	 * = new Cliente("Andrés", "Mercado", "111", new Date(), "Medellin",
	 * "Antioquia"); Cliente c3 = new Cliente("Juana", "Molina Florez", "222",
	 * new Date(), "Medellin", "Antioquia"); Cliente c4 = new
	 * Cliente("Juan Andrés", "Palacio Florez", "321", new Date(), "Jericó",
	 * "Antioquia"); Cliente c5 = new Cliente("Monica Fernanda",
	 * "Garcia Florez", "112", new Date(), "Bogotá", "Cundinamarca");
	 * clientes.add(c1); clientes.add(c2); clientes.add(c3); clientes.add(c4);
	 * clientes.add(c5); return clientes; }
	 */

}
