package ar.com.infocompany.infraestructure.custom_exceptions;

public class ConcurrencyException extends ApplicationException {
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
