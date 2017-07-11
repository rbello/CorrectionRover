package fr.exia.rover.contracts;

public enum Direction {

	RIGHT, LEFT, FORWARD, BACKWARD;

	public static Direction valueOfString(String order) {
		switch (order.toLowerCase()) {
		case "r" : return RIGHT;
		case "l" : return LEFT;
		case "f" : return FORWARD;
		case "b" : return BACKWARD;
		}
		return null;
	}
	
}
