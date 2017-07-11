package fr.exia.rover.contracts.ex;

import fr.exia.rover.contracts.ICoordinate;

public class InvalidTargetCoordinateException extends AlreadyOccupiedCoordinateException {

	private static final long serialVersionUID = 1L;

	public InvalidTargetCoordinateException() {
		super();
	}

	public InvalidTargetCoordinateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidTargetCoordinateException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidTargetCoordinateException(String message) {
		super(message);
	}

	public InvalidTargetCoordinateException(Throwable cause) {
		super(cause);
	}

	public InvalidTargetCoordinateException(ICoordinate coordinate) {
		this(coordinate.toString());
	}

}
