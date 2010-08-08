package ar.com.infocompany.infraestructure.custom_exceptions;

import java.util.List;

import ar.com.infocompany.infraestructure.BrokenRule;


public class ApplicationException extends Exception {

	private static final long serialVersionUID = 3929189181743453926L;
	
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
	
	public ApplicationException(String msg, List<BrokenRule> brokenRules) {
		super();
	}
	
}
