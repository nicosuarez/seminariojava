package ar.com.infocompany.infraestructure.custom_exceptions;

public class InvalidLocationException extends ApplicationException {
	
    protected Throwable cause;

    public InvalidLocationException() {
        
    }

    public InvalidLocationException(String message)  {
        super(message);
    }

    public InvalidLocationException(String message, Throwable cause)  {
        super(message);
        this.cause = cause;
    }
}
