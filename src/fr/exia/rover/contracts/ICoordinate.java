package fr.exia.rover.contracts;

public interface ICoordinate {

	/**
	 * Get the abscissa value of this coordinate.
	 */
	public int getX();
	
	/**
	 * Get the ordinate value of this coordinate.
	 */
	public int getY();
	
	/**
	 * Attach an element at this coordinate.
	 */
	public void setElement(IElement element);

	/**
	 * Returns the element attached to this location, or null if
	 * there isn't an element at this coordinate.
	 */
	public IElement getElement();

	/**
	 * Returns TRUE if an element is attached to this location.
	 */
	public boolean hasElement();

	/**
	 * Get a character symbol describing the content of this location.
	 * By convention, a space (empty) character represents an empty location.
	 * If the coordinate is not empty, returns the symbol of the contained element.
	 */
	public char getSymbol();
	
	/**
	 * Returns TRUE if the given coordinate is equals to this one.
	 * This method compares x and y values, not the contained element.
	 */
	public boolean equals(ICoordinate coordinate);

}
