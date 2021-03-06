package co.edu.udea.appempresariales.ensuranceappjersey.exception;
/**
 * Clase utilizada para la implementacion de exceciones que puedan ocurrir 
 * en la capa de la logica del negocio.
 * @author julianesten
 *
 */
public class BusinessLogicException extends Exception {
	
	/**
	 * Esta variable se utiliza para que el JRE(JavaRunEnviorement) 
	 * pueda detectar esta clase de excepciones personalizadas
	 * que estamos creando, dado el caso de que necesite hacer alusion a esta clase.
	 */
	public static final long serialVersionUID = 800L;
	
	/**
	 * 
	 * @param e es la excepcion dada como parametro desde la invocacion de la excepcion
	 * @param message el mensaje a mostrar de la excepcion.
	 * el metodo super se utiliza para hacer un llamado al constructor de la clase Exception
	 */
	public BusinessLogicException(Exception e,String message){
		super(message);
	}

	public BusinessLogicException(String message){
		super(message);
	}
	
	public BusinessLogicException(){
		super();
	}
}
