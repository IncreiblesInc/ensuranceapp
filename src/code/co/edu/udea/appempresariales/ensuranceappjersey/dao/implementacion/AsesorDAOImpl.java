package co.edu.udea.appempresariales.ensuranceappjersey.dao.implementacion;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.AsesorDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Asesor;

public class AsesorDAOImpl implements AsesorDAO {
	
	private static final String DATA_BASE_URI = "mongodb://appempresariales:aPP3mPr35ar1a13s@ds047692.mongolab.com:47692/heroku_4dmddk2h";
	private static final String ASESOR_NAME_COLLECTION = "asesores";

	private MongoClientURI clientURI;
	private MongoClient mongoClient;

	public Asesor getAsesorById(String codigoAsesor) {
		
		clientURI = new MongoClientURI(DATA_BASE_URI);

		mongoClient = new MongoClient(clientURI);

		DB dataBase = mongoClient.getDB(clientURI.getDatabase());

		DBCollection asesorCollection = dataBase.getCollection(ASESOR_NAME_COLLECTION);

		BasicDBObject findQuery = new BasicDBObject("codigoAsesor", codigoAsesor);
		
		DBObject asesorMongo = asesorCollection.findOne(findQuery);
		
		Asesor asesor= new Asesor((String)asesorMongo.get("nombreAsesor"),
				(String)asesorMongo.get("fotoAsesor"),
				(String)asesorMongo.get("telefonoAsesor"),
				(String)asesorMongo.get("correoAsesor"),
				(String)asesorMongo.get("celularAsesor"),
				(String)asesorMongo.get("codigoAsesor"));
		return asesor;
	}

}
