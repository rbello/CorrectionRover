package fr.exia.rover.impl.elements;

import fr.exia.rover.contracts.ICoordinate;
import fr.exia.rover.contracts.IElement;
import fr.exia.rover.contracts.IMap;

public class AbstractElement implements IElement {

	private IMap map;
	private char symbol;

	public AbstractElement(IMap map, char symbol) {
		this.map = map;
		this.symbol = symbol;
	}
	
	@Override
	public ICoordinate getCoordinate() {
		return this.map.getCoordinate(this);
	}

	@Override
	public char getSymbol() {
		return this.symbol;
	}

}
