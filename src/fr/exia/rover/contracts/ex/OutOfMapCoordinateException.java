package fr.exia.rover.contracts.ex;

public class OutOfMapCoordinateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OutOfMapCoordinateException() {
		super();
	}

	public OutOfMapCoordinateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public OutOfMapCoordinateException(String message, Throwable cause) {
		super(message, cause);
	}

	public OutOfMapCoordinateException(String message) {
		super(message);
	}

	public OutOfMapCoordinateException(Throwable cause) {
		super(cause);
	}

	public OutOfMapCoordinateException(String axis, int value) {
		super("Out of bounds " + axis + " = " + value);
	}

}
