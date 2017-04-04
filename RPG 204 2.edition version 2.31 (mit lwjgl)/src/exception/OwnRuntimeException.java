package exception;

public class OwnRuntimeException extends Exception {
	private static final long serialVersionUID = 1L;
	public OwnRuntimeException() { super(); }
	  public OwnRuntimeException(String message) { super(message); }
	  public OwnRuntimeException(String message, Throwable cause) { super(message, cause); }
	  public OwnRuntimeException(Throwable cause) { super(cause); }
	}