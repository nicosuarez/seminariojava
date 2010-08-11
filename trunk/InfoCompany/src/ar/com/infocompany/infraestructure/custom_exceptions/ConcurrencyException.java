package ar.com.infocompany.infraestructure.custom_exceptions;

public class ConcurrencyException extends ApplicationException {
	
	private static final long serialVersionUID = -2683251265390315647L;
	
	protected Throwable cause;

    public ConcurrencyException() {
        
    }

    public ConcurrencyException(String message)  {
        super(message);
    }

    public ConcurrencyException(String message, Throwable cause)  {
        super(message);
        this.cause = cause;
    }
}
