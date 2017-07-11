package fr.exia.rover.impl.elements;

import fr.exia.rover.contracts.IMap;
import fr.exia.rover.contracts.IMobileElement;
import fr.exia.rover.contracts.Orientation;

public class Rover extends AbstractElement implements IMobileElement {

	private Orientation orientation;

	public Rover(IMap map) {
		super(map, 'R');
		setOrientation(Orientation.NORTH);
	}
	
	@Override
	public void setOrientation(Orientation value) {
		this.orientation = value;
	}
	
	@Override
	public char getSymbol() {
		return orientation.getSymbol();
	}

	@Override
	public Orientation getOrientation() {
		return orientation;
	}

}
