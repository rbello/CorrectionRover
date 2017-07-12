package fr.exia.rover.contracts;

public enum EDirection {

	RIGHT, LEFT, FORWARD, BACKWARD;

	public static EDirection valueOfString(String order) {
		switch (order.toUpperCase()) {
		case "R" : return RIGHT;
		case "L" : return LEFT;
		case "F" : return FORWARD;
		case "B" : return BACKWARD;
		}
		return null;
	}
	
}
