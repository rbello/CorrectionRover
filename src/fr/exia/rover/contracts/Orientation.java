package fr.exia.rover.contracts;

public enum Orientation {
	
	NORTH('^', 2),
	SOUTH('v', 4),
	EAST('>', 3),
	WEST('<', 1);
	
	private char symbol;
	private int val;

	private Orientation(char symbol, int val) {
		this.symbol = symbol;
		this.val = val;
	}

	public char getSymbol() {
		return this.symbol;
	}
	
	public Orientation valueOf(int value) {
		while (value <= 0) value += 4;
		while (value > 4) value -= 4;
		switch (value) {
		case 1 : return WEST;
		case 2 : return NORTH;
		case 3 : return EAST;
		case 4 : return SOUTH;
		}
		return null;
	}

	public Orientation apply(Direction direction) {
		int nextval = val;
		switch (direction) {
		case LEFT: nextval += -1; break;
		case RIGHT: nextval += 1; break;
		case BACKWARD: nextval += -2; break;
		case FORWARD: nextval += 0; break;
		}
		return valueOf(nextval);
	}

}
