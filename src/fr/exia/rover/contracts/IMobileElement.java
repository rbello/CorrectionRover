package fr.exia.rover.contracts;

public interface IMobileElement extends IElement {

	/**
	 * Get the current magnetic orientation of the mobile element.
	 */
	EOrientation getOrientation();

	/**
	 * Set the current magnetic orientation of the mobile element.
	 */
	void setOrientation(EOrientation orientation);

}
