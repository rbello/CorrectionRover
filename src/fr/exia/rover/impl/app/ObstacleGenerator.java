package fr.exia.rover.impl.app;

import java.util.Random;

import fr.exia.rover.contracts.ICoordinate;
import fr.exia.rover.contracts.IMap;
import fr.exia.rover.contracts.ex.OutOfMapCoordinateException;
import fr.exia.rover.impl.elements.Obstacle;

public class ObstacleGenerator {

	private double obstacleRatio;

	public ObstacleGenerator(double obstacleRatio) {
		this.obstacleRatio = obstacleRatio;
	}

	public void generate(IMap map) {
		int count = (int)(map.getHeight() * map.getWidth() * obstacleRatio);
		Random rdn = new Random();
		while (count > 0) {
			int x = (int)(rdn.nextFloat() * map.getWidth());
			int y = (int)(rdn.nextFloat() * map.getHeight());
			ICoordinate location;
			try {
				location = map.getCoordinate(x, y);
			} catch (OutOfMapCoordinateException e) {
				continue;
			}
			if (location.hasElement()) continue;
			location.setElement(new Obstacle(map));
			count--;
		}
	}

}
