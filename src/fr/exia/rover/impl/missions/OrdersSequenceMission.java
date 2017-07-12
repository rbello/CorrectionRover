package fr.exia.rover.impl.missions;

import fr.exia.rover.contracts.EDirection;
import fr.exia.rover.contracts.ICoordinate;
import fr.exia.rover.contracts.IMap;
import fr.exia.rover.contracts.IMapRenderer;
import fr.exia.rover.contracts.IMission;
import fr.exia.rover.contracts.IMobileElement;
import fr.exia.rover.contracts.EOrientation;

public class OrdersSequenceMission implements IMission {

	private String[] orders;
	
	public OrdersSequenceMission(String[] orders) {
		this.orders = orders;
	}

	@Override
	public void execute(IMobileElement element, IMap map, IMapRenderer<?> rdr)
			throws Exception {
		
		System.out.println("New mission: execute sequence of " + orders.length + " moves");
		
		for (String order : this.orders) {
			
			// Convert input char to valid direction (R,L,F,B)
			EDirection direction = EDirection.valueOfString(order);
			
			// Get next orientation according to current orientation and
			// the direction given.
			EOrientation orientation = element.getOrientation().rotate(direction);
			
			// Get the next coordinate in the given orientation
			ICoordinate coordinate = map.getCloseCoordinate(
					element.getCoordinate(), orientation);
			
			// Display some logs
			System.out.println("----");
			System.out.println("Go to the : " + direction);
			System.out.println("Actual orientation : " + element.getOrientation());
			System.out.println("Actual location : " + element.getCoordinate());
			System.out.println("Next orientation : " + orientation);
			System.out.println("Next location : " + coordinate);
			
			// Change orientation and move the rover
			element.setOrientation(orientation);
			map.move(element, coordinate);
			
			// Display the map
			System.out.println(rdr.render(map));
			
		}
		
		System.out.println("Mission was SUCCESSFUL !!");
		
	}

}
