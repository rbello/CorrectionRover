package fr.exia.rover.contracts;

public interface IPath {

	void setTargetReached();

	boolean hasReachedTarget();

	int getDistance();

	ICoordinate getStep(int index);

	ICoordinate getLast();
	
	ICoordinate getLast(int n);

	IPath fork(ICoordinate c);
	
	boolean contains(ICoordinate coordinate);

	boolean equals(IPath path);

	
	
}