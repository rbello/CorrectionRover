package fr.exia.rover.impl.app;

import fr.exia.rover.contracts.IMap;
import fr.exia.rover.contracts.IMapRenderer;

public class ConsoleMapRenderer implements IMapRenderer {
	
	public String render(IMap map) {
		StringBuilder sb = new StringBuilder();
		sb.append('.');
		for (int i = 0; i < map.getWidth(); ++i)
			sb.append('-');
		sb.append(".\n");
		for (int y = 0; y < map.getHeight(); ++y) {
			sb.append('|');
			for (int x = 0; x < map.getWidth(); ++x) {
				sb.append(map.getCoordinate(x, y).getSymbol());
			}
			sb.append("|\n");
		}
		sb.append('.');
		for (int i = 0; i < map.getWidth(); ++i)
			sb.append('-');
		sb.append('.');
		return sb.toString();
	}

}
