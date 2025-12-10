package hust.soict.dsai.aims.exception;

public abstract class AimsException extends Exception {
    public AimsException(String message) {
        super(message);
    }


	public AimsException() {
		// TODO Auto-generated constructor stub
	}

	public AimsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public AimsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AimsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
