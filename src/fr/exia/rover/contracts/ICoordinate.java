package fr.exia.rover.contracts;

public interface ICoordinate {

	public int getX();
	
	public int getY();
	
	public void setElement(IElement element);
	
	public IElement getElement();
	
	public boolean hasElement();

	public char getSymbol();
	
	public boolean equals(ICoordinate coordinate);

}
