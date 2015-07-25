package co.edu.udea.appempresariales.ensuranceappjersey.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.CiudadDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Ciudad;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Reclamacion;

public class CiudadDAOImpl implements CiudadDAO {
	
	private static final String DATA_BASE_URI="mongodb://appempresariales:aPP3mPr35ar1a13s@ds047692.mongolab.com:47692/heroku_4dmddk2h";
	private static final String CIUDADES_NAME_COLLECTION="ciudades";
	
	private MongoClientURI clientURI;
	private MongoClient mongoClient;
	
	public CiudadDAOImpl(){
		
	}
	
	public List<Ciudad> obetenrCiudades() {
		List<Ciudad> ciudades = new ArrayList<Ciudad>();
		//Configuración para la obtención de los datos
		clientURI= new MongoClientURI(DATA_BASE_URI);
		mongoClient = new MongoClient(clientURI);
		DB dataBase = mongoClient.getDB(clientURI.getDatabase());
		DBCollection collectionOfCiudades = dataBase.getCollection(CIUDADES_NAME_COLLECTION);
		DBCursor documentos=collectionOfCiudades.find();
		while(documentos.hasNext()){
			DBObject documento= documentos.next();
			Ciudad ciudad = new Ciudad((String)documento.get("nombre"));
			ciudades.add(ciudad);
		}
		mongoClient.close();
		return ciudades;
	}
	/*
	public List<Ciudad> obtenerCiudadesTemporal() {
		
		List<Ciudad> ciudades= new ArrayList<Ciudad>();
		
		Ciudad cd1= new Ciudad("Medellin");
		Ciudad cd2= new Ciudad("Bogota");
		Ciudad cd3= new Ciudad("Cali");
		Ciudad cd4= new Ciudad("Manizales");
		Ciudad cd5= new Ciudad("Barranquilla");
		ciudades.add(cd1);
		ciudades.add(cd2);
		ciudades.add(cd3);
		ciudades.add(cd4);
		ciudades.add(cd5);		
		return ciudades;
		
	}*/

}
