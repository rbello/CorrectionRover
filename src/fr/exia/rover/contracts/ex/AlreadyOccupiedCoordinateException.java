package fr.exia.rover.contracts.ex;

import fr.exia.rover.contracts.ICoordinate;

public class AlreadyOccupiedCoordinateException extends Exception {

	private static final long serialVersionUID = 1L;

	public AlreadyOccupiedCoordinateException() {
		super();
	}

	public AlreadyOccupiedCoordinateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AlreadyOccupiedCoordinateException(String message, Throwable cause) {
		super(message, cause);
	}

	public AlreadyOccupiedCoordinateException(String message) {
		super(message);
	}

	public AlreadyOccupiedCoordinateException(Throwable cause) {
		super(cause);
	}

	public AlreadyOccupiedCoordinateException(ICoordinate coordinate) {
		this(coordinate.toString());
	}

}
