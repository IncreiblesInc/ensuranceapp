package co.edu.udea.appempresariales.ensuranceappjersey.dao.implementacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.PolizaDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.dao.interfaces.ReclamacionDAO;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Poliza;
import co.edu.udea.appempresariales.ensuranceappjersey.entities.Reclamacion;
import co.edu.udea.appempresariales.ensuranceappjersey.utils.Utils;

/**
 * 
 * Implementación de la clase Data Access Object, que permite acceder a los objetos persistentes
 * de la aplicación.
 * 
 * @author Daniel
 *
 */

public class ReclamacionDAOImpl implements ReclamacionDAO {

	private static final String DATA_BASE_URI="mongodb://appempresariales:aPP3mPr35ar1a13s@ds047692.mongolab.com:47692/heroku_4dmddk2h";
	private static final String RECLAMACIONES_NAME_COLLECTION="reclamaciones";
	
	private MongoClientURI clientURI;
	private MongoClient mongoClient;



	public List<Reclamacion> consultarReclamacionesPorCliente(String cedula) {

		if(cedula == null){
			throw new IllegalArgumentException("Debe ingresar alguna cédula");
		}
			PolizaDAO polizaDAO = new PolizaDAOImpl();
			List<Poliza> polizas =  polizaDAO.consultarPolizasVigentesPorCliente(cedula);
			
			ArrayList<Reclamacion> reclamacionPorCliente = new ArrayList<Reclamacion>();
			
			for(Poliza poliza:polizas){
				List<Reclamacion> reclamacionPorPoliza=this.consultarReclamacionesPorPoliza(poliza.getNumeroPoliza());
				reclamacionPorCliente.addAll(reclamacionPorPoliza);
			}
			return reclamacionPorCliente;

		
	}
	
	




	public List<Reclamacion> consultarReclamacionesPorPoliza(String numeroPoliza) throws IllegalArgumentException {
		if(numeroPoliza == null){
			throw new IllegalArgumentException();
		}
		
		clientURI= new MongoClientURI(DATA_BASE_URI);
		
		mongoClient = new MongoClient(clientURI);
		
		DB dataBase = mongoClient.getDB(clientURI.getDatabase());
		
		DBCollection collectionOfReclamaciones = dataBase.getCollection(RECLAMACIONES_NAME_COLLECTION);
		
		BasicDBObject findQuery= new BasicDBObject("numeroPoliza", numeroPoliza);
		
		DBCursor documentos= collectionOfReclamaciones.find(findQuery);
		List <Reclamacion> reclamacionesPorPoliza = new ArrayList<Reclamacion>();
		while (documentos.hasNext()){
			DBObject documento= documentos.next();
			
			Reclamacion reclamacion;
				reclamacion = new Reclamacion(
						(String)documento.get("codigoReclamacion"),
								Utils.formatDate(documento.get("fechaReclamacion")),
								(String)documento.get("ciudadReclamacion"),
								(Integer)documento.get("valorReclamacion"),
								(String)documento.get("motivoReclamacion"),
								(String)documento.get("estadoReclamacion"),
								Utils.formatDate(documento.get("fechaActualizacion")),
								(String)documento.get("numeroPoliza"));

				reclamacionesPorPoliza.add(reclamacion);

			
		}
		mongoClient.close();
		return reclamacionesPorPoliza;
	}



	public void guardarReclamacion(Reclamacion reclamacion) {
		//Codigo guardar objeto en mongDB
		
	}

}
