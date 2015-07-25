package co.edu.udea.appempresariales.ensuranceappjersey.dao.implementacion;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.OficinaDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Oficina;

public class OficinaDAOImpl implements OficinaDAO {

	private static final String DATA_BASE_URI = "mongodb://appempresariales:aPP3mPr35ar1a13s@ds047692.mongolab.com:47692/heroku_4dmddk2h";
	private static final String OFICINA_NAME_COLLECTION = "oficinas";

	private MongoClientURI clientURI;
	private MongoClient mongoClient;

	public Oficina getOficinaById(String codigoOficina) {
		clientURI = new MongoClientURI(DATA_BASE_URI);

		mongoClient = new MongoClient(clientURI);

		DB dataBase = mongoClient.getDB(clientURI.getDatabase());

		DBCollection oficinasCollection = dataBase.getCollection(OFICINA_NAME_COLLECTION);

		BasicDBObject findQuery = new BasicDBObject("codigoOficina", codigoOficina);

		DBObject oficinaMongo = oficinasCollection.findOne(findQuery);
		
		Oficina oficina= new Oficina((String)oficinaMongo.get("ciudadOficina"),
				(String)oficinaMongo.get("nombreOficina"),
				(String)oficinaMongo.get("codigoOficina"));
		
		mongoClient.close();
		return oficina;
	}

}
