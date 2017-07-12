package fr.exia.rover.contracts;

import java.util.List;

import fr.exia.rover.contracts.ex.AlreadyOccupiedCoordinateException;
import fr.exia.rover.contracts.ex.OutOfMapCoordinateException;

public interface IMap {

	/**
	 * Returns the width of the map. The unit used is the number
	 * of columns of the grid (abscissa).
	 */
	public int getWidth();
	
	/**
	 * Returns the height of the map. The unit used is the number
	 * of rows of the grid (ordinate).
	 */
	public int getHeight();
	
	/**
	 * Returns the complete grid of coordinates of the map.
	 */
	public ICoordinate[][] getCoordinates();
	
	/**
	 * Returns the coordinate object at the given location.
	 */
	public ICoordinate getCoordinate(int x, int y)
		throws OutOfMapCoordinateException;
	
	/**
	 * Returns the coordinate of the object on the map, of null is the
	 * element isn't in any coordinate.
	 */
	public ICoordinate getCoordinate(IElement element);
	
	/**
	 * Returns the element at the given location, or null if the coordinate
	 * is empty or not attached to the map.
	 */
	public IElement getElementAt(ICoordinate location);
	
	/**
	 * Returns the element at the given location, or null if the coordinate
	 * is empty or out of bounds.
	 */
	public IElement getElementAt(int x, int y);
	
	/**
	 * Attach an element inside the map at the given location.
	 */
	public void setElementAt(ICoordinate location, IElement element);
	
	/**
	 * Attach an element inside the map at the given location.
	 */
	public void setElementAt(int x, int y, IElement element);

	/**
	 * Returns the coordinate just next to the given one in the
	 * heading orientation given.
	 */
	public ICoordinate getCloseCoordinate(ICoordinate coordinate, 
			EOrientation orientation);

	/**
	 * Move an element to a given coordinate in the map.
	 * This method will execute both operations of removing the
	 * element from the previous location, then attach the element
	 * to the new location given.
	 */
	public void move(IMobileElement element, ICoordinate coordinate)
			 throws AlreadyOccupiedCoordinateException;

	/**
	 * Returns the list of nearby coordinates around the given coordinate,
	 * in the four heading orientations (North, South, East, West).
	 * If a nearby coordinate is not available for a move (occupied by
	 * an obstacle of any other element) it will not be added to the
	 * returned list.
	 */
	public List<ICoordinate> getCloseCoordinates(ICoordinate coordinate);

}
