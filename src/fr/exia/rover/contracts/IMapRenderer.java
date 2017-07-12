package fr.exia.rover.contracts;

public interface IMapRenderer<T> {
	
	/**
	 * Render the map as a string.
	 */
	T render(IMap map);

	/**
	 * Render the map as a string and display the given path.
	 */
	T render(IMap map, IPath<ICoordinate> path);

}
