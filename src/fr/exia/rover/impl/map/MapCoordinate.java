package fr.exia.rover.impl.map;

import fr.exia.rover.contracts.ICoordinate;
import fr.exia.rover.contracts.IElement;

public class MapCoordinate implements ICoordinate {

	private int x;
	private int y;
	private IElement element;

	public MapCoordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setElement(IElement element) {
		this.element = element;
	}

	@Override
	public IElement getElement() {
		return this.element;
	}

	@Override
	public boolean hasElement() {
		return this.element != null;
	}

	@Override
	public char getSymbol() {
		return hasElement() ? this.element.getSymbol() : ' ';
	}
	
	@Override
	public String toString() {
		return x + ";" + y;
	}

	@Override
	public boolean equals(ICoordinate coordinate) {
		return x == coordinate.getX() && y == coordinate.getY();
	}

}
