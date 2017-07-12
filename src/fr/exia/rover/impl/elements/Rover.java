package fr.exia.rover.impl.elements;

import fr.exia.rover.contracts.IMap;
import fr.exia.rover.contracts.IMobileElement;
import fr.exia.rover.contracts.EOrientation;

public class Rover extends AbstractElement implements IMobileElement {

	private EOrientation orientation;

	public Rover(IMap map) {
		super(map, 'R');
		setOrientation(EOrientation.NORTH);
	}
	
	@Override
	public void setOrientation(EOrientation value) {
		this.orientation = value;
	}
	
	@Override
	public char getSymbol() {
		return orientation.getSymbol();
	}

	@Override
	public EOrientation getOrientation() {
		return orientation;
	}

}
