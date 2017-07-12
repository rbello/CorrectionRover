package fr.exia.rover.contracts;

public interface IPath<T> {

	/**
	 * Mark this path as reached, namely if the last step of this path
	 * is the target coordinate.
	 */
	void setTargetReached();

	/**
	 * Returns true if the target is reached, see the setter for more infos.
	 */
	boolean hasReachedTarget();

	/**
	 * Returns the total distance between the first coordinate of the
	 * path and the last one.
	 */
	int getDistance();

	/**
	 * Return the Nth step of this path, relative to the beginning.
	 */
	T getStep(int n);

	/**
	 * Return the last step of this path, relative to the end.
	 */
	T getLast();
	
	/**
	 * Return the Nth step of this path, relative to the end.
	 */
	T getLast(int n);

	/**
	 * Create a new path containning all steps of this one, and add the
	 * step given in argument to the end.
	 */
	IPath<T> fork(T step);
	
	/**
	 * Returns TRUE if this path contains the given step.
	 */
	boolean contains(T step);

	/**
	 * Returns TRUE if the given path is exactly the same than
	 * this one. This meen that all steps of the path and the
	 * order of the steps are equals.
	 */
	boolean equals(IPath<T> path);

}