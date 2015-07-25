/**
 * 
 */
package co.edu.udea.appempresariales.ensuranceappjersey.dao.implementacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.AsesorDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.OficinaDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.PolizaDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Asesor;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Oficina;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Poliza;
import co.edu.udea.appempresariales.ensuranceappjersey.utils.Utils;

/**
 * @author JuanF
 *
 */
public class PolizaDAOImpl implements PolizaDAO {

	private static final String DATA_BASE_URI = "mongodb://appempresariales:aPP3mPr35ar1a13s@ds047692.mongolab.com:47692/heroku_4dmddk2h";
	private static final String POLIZAS_NAME_COLLECTION = "polizas";

	private MongoClientURI clientURI;
	private MongoClient mongoClient;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.PolizaDAO#
	 * consultarPoliza(java.lang.String)
	 */
	public Poliza consultarPoliza(String numeroPoliza) {

		clientURI = new MongoClientURI(DATA_BASE_URI);

		mongoClient = new MongoClient(clientURI);

		DB dataBase = mongoClient.getDB(clientURI.getDatabase());

		DBCollection collectionOfPolizas = dataBase.getCollection(POLIZAS_NAME_COLLECTION);

		BasicDBObject findQuery = new BasicDBObject("numeroPoliza", numeroPoliza);

		DBObject polizaMongo = collectionOfPolizas.findOne(findQuery);
		OficinaDAO oficinaDAO = new OficinaDAOImpl();
		Oficina oficina = oficinaDAO.getOficinaById((String) polizaMongo.get("codigoOficina"));
		AsesorDAO asesorDAO = new AsesorDAOImpl();
		Asesor asesor = asesorDAO.getAsesorById((String) polizaMongo.get("codigoAsesor"));

		Poliza polizaObject = new Poliza((String) polizaMongo.get("numeroPoliza"),
				(String) polizaMongo.get("nombreProducto"), Utils.formatDate(polizaMongo.get("fechaInicio")),
				Utils.formatDate(polizaMongo.get("fechaFin")), (Integer) polizaMongo.get("valorAsegurado"),
				(String) polizaMongo.get("cedulaCliente"), Utils.formatDate(polizaMongo.get("fechaExpedicion")),
				oficina, asesor);

		return polizaObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.PolizaDAO#
	 * consultarPolizasVigentesPorCliente(java.lang.String)
	 */
	public List<Poliza> consultarPolizasVigentesPorCliente(String cedulaCliente) {
		clientURI = new MongoClientURI(DATA_BASE_URI);

		mongoClient = new MongoClient(clientURI);

		DB dataBase = mongoClient.getDB(clientURI.getDatabase());

		DBCollection collectionOfPolizas = dataBase.getCollection(POLIZAS_NAME_COLLECTION);

		BasicDBObject clientQuery = new BasicDBObject("cedulaCliente", cedulaCliente);
		
		BasicDBObject fechaQuery= new BasicDBObject("fechaInicio", new BasicDBObject("$gt", "Date()"));
		
		BasicDBObject andQuery = new BasicDBObject();
		ArrayList<BasicDBObject> queries= new ArrayList<BasicDBObject>();

		BasicDBObject npolizaField = new BasicDBObject("numeroPoliza", 1);
		queries.add(clientQuery);
		queries.add(fechaQuery);
		andQuery.put("$and", queries);
		DBCursor polizasMongo = collectionOfPolizas.find(andQuery, npolizaField);

		List<Poliza> polizasVigentes = new ArrayList<Poliza>();
		
		while (polizasMongo.hasNext()) {
			DBObject polizaMongo = polizasMongo.next();
			Poliza poliza= consultarPoliza((String)polizaMongo.get("numeroPoliza"));
			polizasVigentes.add(poliza);
			
		}
		mongoClient.close();
		return polizasVigentes;
	}

	public List<Poliza> obtenerPolizasTemporal() {

		Calendar date = new GregorianCalendar(2016, 3, 7);
		date.add(Calendar.DAY_OF_MONTH, -7);
		Date vigencia = date.getTime();
		Oficina o = new Oficina("Medellin", "Carabobo", "Medellin");
		Asesor a = new Asesor("Juan Fernando", "373873873.jpg", "373873873", "juanfer@asesor.com", "104848933",
				"Medellin");

		List<Poliza> Polizas = new ArrayList<Poliza>();
		Poliza p1 = new Poliza("123", "Vida", new Date(), vigencia, 10000000, "123", new Date(), o, a);
		Poliza p2 = new Poliza("124", "Autos", new Date(), vigencia, 100000000, "123", new Date(), o, a);
		Poliza p3 = new Poliza("121", "Salud", new Date(), vigencia, 133000000, "122", new Date(), o, a);
		Poliza p4 = new Poliza("125", "Empresarial", new Date(), vigencia, 123400000, "111", new Date(), o, a);
		Poliza p5 = new Poliza("127", "Multiriesgo", new Date(), vigencia, 1234000023, "111", new Date(), o, a);
		Polizas.add(p1);
		Polizas.add(p2);
		Polizas.add(p3);
		Polizas.add(p4);
		Polizas.add(p5);
		return Polizas;
	}

}
