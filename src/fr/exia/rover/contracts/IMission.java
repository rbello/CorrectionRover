package fr.exia.rover.contracts;

public interface IMission {

	/**
	 * Execute the current mission.
	 * 
	 * @param element The mobile element (rover)
	 * @param map The map
	 * @param rdr The map renderer
	 * @throws Exception
	 */
	void execute(IMobileElement element, IMap map, IMapRenderer<?> rdr)
			throws Exception;

}
