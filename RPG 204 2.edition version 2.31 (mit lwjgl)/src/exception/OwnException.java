package exception;

public class OwnException extends Exception {
	private static final long serialVersionUID = 1L;
	public OwnException() { super(); }
	  public OwnException(String message) { super(message); }
	  public OwnException(String message, Throwable cause) { super(message, cause); }
	  public OwnException(Throwable cause) { super(cause); }
	}