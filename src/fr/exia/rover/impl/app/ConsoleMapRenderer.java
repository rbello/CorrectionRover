package fr.exia.rover.impl.app;

import fr.exia.rover.contracts.ICoordinate;
import fr.exia.rover.contracts.IMap;
import fr.exia.rover.contracts.IMapRenderer;
import fr.exia.rover.contracts.IPath;

public class ConsoleMapRenderer implements IMapRenderer {
	
	public String render(IMap map) {
		return render(map, null);
	}

	@Override
	public String render(IMap map, IPath path) {
		StringBuilder sb = new StringBuilder();
		sb.append('.');
		for (int i = 0; i < map.getWidth(); ++i)
			sb.append('-');
		sb.append(".\n");
		for (int y = 0; y < map.getHeight(); ++y) {
			sb.append('|');
			for (int x = 0; x < map.getWidth(); ++x) {
				ICoordinate coordinate = map.getCoordinate(x, y);
				if (path != null && path.contains(coordinate) && !coordinate.hasElement())
					sb.append(".");
				else
					sb.append(coordinate.getSymbol());
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
