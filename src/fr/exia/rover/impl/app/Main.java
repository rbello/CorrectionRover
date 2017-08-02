package fr.exia.rover.impl.app;

import java.util.Scanner;

import fr.exia.rover.contracts.IMap;
import fr.exia.rover.contracts.IMapRenderer;
import fr.exia.rover.contracts.IMission;
import fr.exia.rover.impl.elements.Rover;
import fr.exia.rover.impl.map.PlanetProjectionMap;

public class Main {

	public static void main(String[] args) {
	
		// Create map
		IMap map = new PlanetProjectionMap("Mars", 40, 10);
		
		// Generate obstacles
		new ObstacleGenerator(0.18).generate(map);
		
		// Create rover
		Rover rover = new Rover(map);
		map.getCoordinate(0, 0).setElement(rover);
		
		// Display
		IMapRenderer<String> rdr = new ConsoleMapRenderer();
		System.out.println(rdr.render(map));
		
		// Input
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				
				System.out.println("Enter a coma-separated sequence of orders using: f(orward), b(ackward), r(ight), l(eft)   (Eg. r,r,r,f,f,l,b)");
				System.out.println("Or enter a target location using X,Y   (Eg. 10,15)");
				System.out.println("Or enter 'exit' to shutdown");
				
				String sentence = scanner.nextLine();
				if ("exit".equals(sentence)) break;
				IMission order = new MissionFactory().parse(sentence);
				
				if (order == null) {
					System.err.println("Error: invalid mission syntax");
					continue;
				}
				
				try {
					order.execute(rover, map, rdr);
				}
				catch (Exception ex) {
					System.err.println("Error during mission: " + 
						ex.getClass().getSimpleName() + " - " + ex.getMessage());
					System.out.println(rdr.render(map));
				}
				System.out.println();
			}
		}
	}

}
