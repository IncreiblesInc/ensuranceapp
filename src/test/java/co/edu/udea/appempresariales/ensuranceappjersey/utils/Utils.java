package co.edu.udea.appempresariales.ensuranceappjersey.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	public static 
	SimpleDateFormat formatter= new SimpleDateFormat("yyyy-mm-dd hh:mm:ss.SSS");
	public static Date formatDate(Object object){
		try {
			return formatter.parse(((String)object).replace('T', ' ').replace('Z', ' '));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
