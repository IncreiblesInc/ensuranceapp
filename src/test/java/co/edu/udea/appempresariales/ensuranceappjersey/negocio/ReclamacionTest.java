package co.edu.udea.appempresariales.ensuranceappjersey.negocio;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;

public class ReclamacionTest {
	LogicaReclamacion logica;
	
	public  ReclamacionTest() {
		 logica = new LogicaReclamacion();
	}
	
	@Test
	public void test() {
		FileInputStream fileInputStream=null;
		String respuesta = "";
		File file = new File(new File("").getAbsolutePath()+"\\src\\main\\webapp\\reclamaciones\\testing.jpg");
		  byte[] bFile = new byte[(int) file.length()];
			 try {
		            //convert file into array of bytes
			    fileInputStream = new FileInputStream(file);
			    fileInputStream.read(bFile);
			    fileInputStream.close();
			    
			    respuesta = logica.guardarImagen(bFile, "test");
	        }catch(Exception e){
	            e.printStackTrace();
	        }
		 
		 	assertNotEquals("", respuesta);
		
	}

}
