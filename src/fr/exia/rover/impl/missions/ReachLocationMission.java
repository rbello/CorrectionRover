package fr.exia.rover.impl.missions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import fr.exia.rover.contracts.ICoordinate;
import fr.exia.rover.contracts.IMap;
import fr.exia.rover.contracts.IMapRenderer;
import fr.exia.rover.contracts.IMission;
import fr.exia.rover.contracts.IMobileElement;
import fr.exia.rover.contracts.IPath;
import fr.exia.rover.contracts.EOrientation;
import fr.exia.rover.contracts.ex.AlreadyOccupiedCoordinateException;

public class ReachLocationMission implements IMission {

	private int x;
	private int y;

	public ReachLocationMission(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void execute(IMobileElement element, IMap map, IMapRenderer<?> rdr) 
			throws Exception {
		
		ICoordinate target = map.getCoordinate(x, y);
		
		System.out.println("New mission: reach location " + target);
		
		if (target.equals(element.getCoordinate()))
			throw new AlreadyOccupiedCoordinateException(target);
		
		if (target.hasElement())
			throw new AlreadyOccupiedCoordinateException(target);
		
		// Create a first path beginning from the original location
		List<IPath<ICoordinate>> paths = new ArrayList<IPath<ICoordinate>>();
		paths.add(new Path(element.getCoordinate()));
		
		// Create the list of visited coordinates (faster algo)
		List<ICoordinate> visited = new ArrayList<>();
		
		// Found path (futur)
		IPath<ICoordinate> found = null;
		
		// Iterate to the end
		while (true) {
			
			// Search the shortest path
			IPath<ICoordinate> min = null;
			for (final IPath<ICoordinate> p : paths) {
				// The path matches the target
				if (p.hasReachedTarget()) {
					found = p;
					break;
				}
				// Search for the shortest path
				if (min == null || p.getDistance() < min.getDistance()) {
					min = p;
				}
			}
			
			if (min == null) break;
			
			// Explore the shortest path
			explore(map, paths, min, target, visited);
		}
		
		// Logs
		if (found != null) {
			System.out.println("Mission was SUCCESSFUL !!");
			System.out.println("Path found: " + found);
			map.move(element, target);
			element.setOrientation(EOrientation.getOrientation(found.getLast(1), found.getLast()));
			System.out.println(rdr.render(map, found));
		}
		else {
			System.out.println("Mission was a FAILURE !!");
			System.out.println("No path found");
			System.out.println(rdr.render(map));
		}

	}
	
	private void explore(IMap map, List<IPath<ICoordinate>> paths, IPath<ICoordinate> path,
			ICoordinate target, List<ICoordinate> visited) {
		// Get the last coordinate (vertex) of the path
		ICoordinate last = path.getLast();
		
		// Remove the current path
		paths.remove(path);
		
		// Fetch all paths from current location
		for (final ICoordinate c : map.getCloseCoordinates(last)) {

			// Fork a new path to this coordinate
			IPath<ICoordinate> newPath = path.fork(c);

			// This coordinate was already visited
			if (newPath == null) continue;
			if (visited.contains(c)) continue;
			
			// Save this coordinate as visited (faster algo)
			visited.add(c);
			
			// Add this new path to the list
			if (!paths.contains(newPath))
				paths.add(newPath);
			
			// Mark this path as reached
			if (c.equals(target)) {
				newPath.setTargetReached();
			}
		}
	}

	public static class Path implements IPath<ICoordinate> {

		private LinkedList<ICoordinate> path = new LinkedList<>();
		private boolean reached;
		
		public Path(ICoordinate coordinate) {
			this.path.add(coordinate);
		}

		public Path(LinkedList<ICoordinate> path, ICoordinate coordinate) {
			this.path.addAll(path);
			this.path.add(coordinate);
		}

		@Override
		public void setTargetReached() {
			reached = true;
		}

		@Override
		public Path fork(ICoordinate c) {
			if (path.contains(c)) return null;
			return new Path(path, c);
		}

		@Override
		public ICoordinate getLast() {
			return path.getLast();
		}

		@Override
		public int getDistance() {
			return path.size();
		}

		@Override
		public boolean hasReachedTarget() {
			return reached;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Path) {
				return equals((IPath<ICoordinate>)obj);
			}
			return super.equals(obj);
		}
		
		@Override
		public boolean equals(IPath<ICoordinate> path) {
			if (path.getDistance() != getDistance()) return false;
			for (int i = 0, l = path.getDistance(); i < l; ++i)
			{
				if (!this.path.get(i).equals(path.getStep(i)))
					return false;
			}
			return true;
		}
		
		@Override
		public ICoordinate getStep(int index) {
			return this.path.get(index);
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (final ICoordinate coordinate : path) {
				if (sb.length() > 0) sb.append(" -> ");
				sb.append(coordinate.toString());
			}
			return sb.toString();
		}

		@Override
		public boolean contains(ICoordinate coordinate) {
			for (final ICoordinate c : path) {
				if (c.equals(coordinate)) return true;
			}
			return false;
		}

		@Override
		public ICoordinate getLast(int n) {
			return path.get(path.size() - n - 1);
		}
		
	}

}
