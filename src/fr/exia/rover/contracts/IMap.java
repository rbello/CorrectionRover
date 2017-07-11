package fr.exia.rover.contracts;

import java.util.List;

import fr.exia.rover.contracts.ex.AlreadyOccupiedCoordinateException;
import fr.exia.rover.contracts.ex.OutOfMapCoordinateException;

public interface IMap {

	public int getWidth();
	
	public int getHeight();
	
	public ICoordinate[][] getCoordinates();
	
	public ICoordinate getCoordinate(int x, int y)
		throws OutOfMapCoordinateException;
	
	public ICoordinate getCoordinate(IElement element);
	
	public IElement getElementAt(ICoordinate location);
	
	public IElement getElementAt(int x, int y);
	
	public void setElementAt(ICoordinate location, IElement element);
	
	public void setElementAt(int x, int y, IElement element);

	public ICoordinate getCloseCoordinate(ICoordinate coordinate, Orientation orientation);

	public void move(IMobileElement element, ICoordinate coordinate)
			 throws AlreadyOccupiedCoordinateException;

	public List<ICoordinate> getCloseCoordinates(ICoordinate last);

}
