package fr.exia.rover.impl.missions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import fr.exia.rover.contracts.ICoordinate;
import fr.exia.rover.contracts.IMap;
import fr.exia.rover.contracts.IMapRenderer;
import fr.exia.rover.contracts.IMission;
import fr.exia.rover.contracts.IMobileElement;
import fr.exia.rover.contracts.ex.AlreadyOccupiedCoordinateException;

public class ReachLocationMission implements IMission {

	private int x;
	private int y;

	public ReachLocationMission(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void execute(IMobileElement element, IMap map, IMapRenderer rdr) 
			throws Exception {
		
		ICoordinate target = map.getCoordinate(x, y);
		
		System.out.println("New mission: reach location " + target);
		
		if (target.equals(element.getCoordinate()))
			throw new AlreadyOccupiedCoordinateException(target);
		
		if (target.hasElement())
			throw new AlreadyOccupiedCoordinateException(target);
		
		// Create a first path beginning from the original location
		List<Path> paths = new ArrayList<Path>();
		paths.add(new Path(element.getCoordinate()));
		
		Path found = null;
		
		// Iterate to the end
		while (true) {
			
			// Search the shortest path
			Path min = null;
			for (Path p : paths) {
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
			
			if (min == null) break; // TODO
			
			// Explore the shortest path
			explore(map, paths, min, target);
		}
		
		// Logs
		if (found != null) {
			System.out.println("Mission was SUCCESSFUL !!");
			System.out.println("Path found: " + found);
			map.move(element, target);
		}
		else {
			System.out.println("Mission was a FAILURE !!");
			System.out.println("No path found");
		}
		
		// Display the map
		System.out.println(rdr.render(map));
	}
	
	private void explore(IMap map, List<Path> paths, Path path, ICoordinate target) {
		// Get the last coordinate (vertex) of the path
		ICoordinate last = path.getLast();
		
		// Remove the current path
		paths.remove(path);
		
		// Fetch all paths from current location
		for (ICoordinate c : map.getCloseCoordinates(last)) {

			Path newPath = path.fork(c);

			// This coordinate was already visited
			if (newPath == null) continue;
			
			// Add this new path to the list
			paths.add(newPath);
			
			// Mark this path as reached
			if (c.equals(target)) {
				newPath.setTargetReached();
			}
		}
	}

	public static class Path {

		private LinkedList<ICoordinate> path = new LinkedList<>();
		private boolean reached;
		
		public Path(ICoordinate coordinate) {
			this.path.add(coordinate);
		}

		public Path(LinkedList<ICoordinate> path, ICoordinate coordinate) {
			this.path.addAll(path);
			this.path.add(coordinate);
		}

		public void setTargetReached() {
			reached = true;
		}

		public Path fork(ICoordinate c) {
			if (path.contains(c)) return null;
			return new Path(path, c);
		}

		public ICoordinate getLast() {
			return path.getLast();
		}

		public int getDistance() {
			return path.size();
		}

		public boolean hasReachedTarget() {
			return reached;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (ICoordinate coordinate : path) {
				if (sb.length() > 0) sb.append(" -> ");
				sb.append(coordinate.toString());
			}
			return sb.toString();
		}
		
	}

}
