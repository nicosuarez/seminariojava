package ar.com.infocompany.infraestructure.exceptions;

public class InvalidLocationException extends ApplicationException {
	
	private static final long serialVersionUID = 2502046996813014739L;
	
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
