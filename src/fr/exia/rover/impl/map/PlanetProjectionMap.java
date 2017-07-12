package fr.exia.rover.impl.map;

import java.util.ArrayList;
import java.util.List;

import fr.exia.rover.contracts.ICoordinate;
import fr.exia.rover.contracts.IElement;
import fr.exia.rover.contracts.IMap;
import fr.exia.rover.contracts.IMobileElement;
import fr.exia.rover.contracts.EOrientation;
import fr.exia.rover.contracts.ex.AlreadyOccupiedCoordinateException;
import fr.exia.rover.contracts.ex.OutOfMapCoordinateException;

public class PlanetProjectionMap implements IMap {
	
	private String mapName;
	private int width;
	private int height;
	private ICoordinate[][] elements;

	public PlanetProjectionMap(String mapName, int width, int height) {
		this.mapName = mapName;
		this.width = width;
		this.height = height;
		this.elements = new ICoordinate[width][height];
		fillWithCoordinates();
	}

	private void fillWithCoordinates() {
		for (int x = 0; x < width; ++x) {
			for (int y = 0; y < height; ++y) {
				this.elements[x][y] = new MapCoordinate(x, y);
			}
		}
	}

	public String getMapName() {
		return mapName;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public ICoordinate[][] getCoordinates() {
		return elements;
	}

	@Override
	public ICoordinate getCoordinate(int x, int y) 
			throws OutOfMapCoordinateException {
		if (x > getWidth() - 1) {
			throw new OutOfMapCoordinateException("x", x);
		}
		if (y > getHeight() - 1) {
			throw new OutOfMapCoordinateException("y", y);
		}
		return elements[x][y];
	}

	@Override
	public ICoordinate getCoordinate(IElement element) {
		for (int x = 0; x < width; ++x) {
			for (int y = 0; y < height; ++y) {
				if (elements[x][y] != null && elements[x][y].getElement() == element)
					return elements[x][y];
			}
		}
		return null;
	}

	@Override
	public IElement getElementAt(ICoordinate location) {
		return getElementAt(location.getX(), location.getY());
	}

	@Override
	public IElement getElementAt(int x, int y) {
		return elements[x][y] != null ? elements[x][y].getElement() : null;
	}

	@Override
	public void setElementAt(ICoordinate location, IElement element) {
		setElementAt(location.getX(),  location.getY(), element);
	}

	@Override
	public void setElementAt(int x, int y, IElement element) {
		elements[x][y].setElement(element);
	}

	@Override
	public ICoordinate getCloseCoordinate(ICoordinate coordinate, EOrientation orientation) {
		int x = coordinate.getX(), y = coordinate.getY();
		switch (orientation) {
		case NORTH: y -= 1; break;
		case SOUTH: y += 1; break;
		case EAST:  x += 1; break;
		case WEST:  x -= 1; break;
		}
		if (x >= width) x = 0;
		if (y >= height) y = 0;
		if (x < 0) x = width - 1;
		if (y < 0) y = height - 1;
		return elements[x][y];
	}

	@Override
	public void move(IMobileElement element, ICoordinate coordinate) throws AlreadyOccupiedCoordinateException {
		if (coordinate.hasElement()) {
			throw new AlreadyOccupiedCoordinateException(coordinate);
		}
		// Remove from previous coordinate
		element.getCoordinate().setElement(null);
		// Add to new coordinate
		coordinate.setElement(element);
	}

	@Override
	public List<ICoordinate> getCloseCoordinates(ICoordinate coordinate) {
		List<ICoordinate> result = new ArrayList<>();
		for (EOrientation orientation : EOrientation.values()) {
			ICoordinate c = getCloseCoordinate(coordinate, orientation);
			if (!c.hasElement())
				result.add(c);
		}
		return result;
	}

}
