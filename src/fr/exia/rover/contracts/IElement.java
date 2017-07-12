package fr.exia.rover.contracts;

public interface IElement {

	/**
	 * Returns the coordinate of the element on the map, or null if
	 * the element is not attached to the map.
	 */
	public ICoordinate getCoordinate();
	
	/**
	 * Returns the element as a character symbol for text-based display.
	 */
	public char getSymbol();
	
}
