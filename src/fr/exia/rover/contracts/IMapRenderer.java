package fr.exia.rover.contracts;

public interface IMapRenderer {
	
	String render(IMap map);

	String render(IMap map, IPath path);

}
