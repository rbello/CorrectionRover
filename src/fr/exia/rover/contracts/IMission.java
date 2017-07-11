package fr.exia.rover.contracts;

public interface IMission {

	void execute(IMobileElement element, IMap map, IMapRenderer rdr)
			throws Exception;

}
