package ar.com.infocompany.infraestructure.custom_exceptions;


public class ApplicationException extends Exception {

	protected Throwable cause;

	public ApplicationException() {
		super("Ha ocurrido un error en la aplicacion.");
	}

	public ApplicationException(String message)  {
	    super(message);
	}
	
	public ApplicationException(String message, Throwable cause)  {
	       super(message);
	       this.cause = cause;
	}
}
