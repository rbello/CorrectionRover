package fr.exia.rover.contracts;

public enum EOrientation {
	
	NORTH('^', 2),
	SOUTH('v', 4),
	EAST('>', 3),
	WEST('<', 1);
	
	private char symbol;
	private int val;

	private EOrientation(char symbol, int val) {
		this.symbol = symbol;
		this.val = val;
	}
	
	protected int getValue() {
		return val;
	}

	public char getSymbol() {
		return this.symbol;
	}
	
	protected static EOrientation valueOf(int value) {
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

	/**
	 * Rotate this orientation to the given direction.
	 */
	public EOrientation rotate(EDirection direction) {
		return rotate(this, direction);
	}
	
	/**
	 * According to a solid having the initial given <var>orientation</var> and making
	 * a move to a given <var>direction</var>, returns the final orientation after the move.
	 */
	public static EOrientation rotate(EOrientation orientation, EDirection direction) {
		int nextval = orientation.getValue();
		switch (direction) {
		case LEFT: nextval += -1; break;
		case RIGHT: nextval += 1; break;
		case BACKWARD: nextval += -2; break;
		case FORWARD: nextval += 0; break;
		}
		return valueOf(nextval);
	}

	/**
	 * Return the orientation given from coordinate <var>from</var> heading 
	 * to orientation <var>to</var>.
	 */
	public static EOrientation getOrientation(ICoordinate from, ICoordinate to) {
		if (to.getX() > from.getX()) return EAST;
		if (to.getX() < from.getX()) return WEST;
		if (to.getY() > from.getY()) return SOUTH;
		if (to.getY() < from.getY()) return NORTH;
		return null;
	}

}
