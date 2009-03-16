/**
 * 
 * Collects an array of points (ArrayList extensions) to be manipulated
 * in a map-like manner.
 *
 */
package core;
import obj.Room;
import obj.Exit;
import java.util.ArrayList;
public class Grid {
	private Room[][] points;
	private ArrayList<Exit> exits;
	
	/** Starts a new grid with specified dimensions, Xmax by Ymax */
	public Grid(int Xmax, int Ymax){
		points = new Room[Xmax][Ymax];
		exits = new ArrayList<Exit>();
	}
	
	/** Adds an object at the specified point */
	public void add(Room obj, int x, int y){
		try {
			//If there isn't a point at the location, create it
			if(points[x][y] == null)
				points[x][y] = obj;
			//Else just add the obj to the existing point
			else 
				Output.error("Point ("+x+","+y+") already has a room on it.");
		} catch(Exception e){
			Output.error("Point ("+x+","+y+") is outside the grid.");
		}
	}
	
	/** Returns the object(s) north of point p */
	public Room objNorth(Room p){
		return this.objAtOffset(p, 0, 1);
	}
	
	/** Returns the object(s) east of point p */
	public Room objEast(Room p){
		return this.objAtOffset(p, 1, 0);
	}
	
	/** Returns the object(s) south of point p */
	public Room objSouth(Room p){
		return this.objAtOffset(p, 0, -1);
	}
	
	/** Returns the object(s) west of point p */
	public Room objWest(Room p){
		return this.objAtOffset(p, -1, 0);
	}
	
	/** Returns the object(s) at an offset of point p */
	public Room objAtOffset(Room p, int xOffset, int yOffset){
		try {
			int[] coordinates = this.getCoord(p);
			return this.points[coordinates[0]+xOffset][coordinates[1]+yOffset];
		} catch(Exception e){
			Output.error("The grid ends below this object.");
		}
		return null;
	}
	
	/** Returns the offset from r1 to r2 */
	public int[] getOffset(Room r1, Room r2){
		if(isOnGrid(r1) && isOnGrid(r2)){
			int[] c1 = getCoord(r1);
			int[] c2 = getCoord(r2);
			int[] offset = {(c2[0] - c1[0]), (c2[1] - c1[1])};
			return offset;
		}
		Output.error("At least one of the rooms is not on the grid.");
		return null;
	}
	
	/** Checks to see if the room is on the grid */
	public boolean isOnGrid(Room r){
		int[] coords = this.getCoord(r);
		return (coords[0] != -1 && coords[1] != -1);
	}
	
	/** Returns the coordinates of point p in an array
	 *  with index 0 = x and 1 = y */
	public int[] getCoord(Room p){
		int[] coordinates = {-1, -1};
		//Scans through the points to find the coordinate of the passed point
		scan: for(int i = 0; i < points.length; i++){
			for(int j = 0; j < points[i].length; j++){
				//When the point is found, set the coordinates and break the scan
				if(points[i][j] != null && points[i][j].equals(p)){
					coordinates[0] = i;
					coordinates[1] = j;
					break scan;
				}
			}
		}
		return coordinates;
	}
	
	/** 'Links' two rooms using an exit */
	public void linkRooms(Room r1, Room r2, boolean passable, boolean locked, String name){
		int[] offset = this.getOffset(r1, r2);
		if(this.isOnGrid(r1) && this.isOnGrid(r2)){
			if(Math.abs(offset[0]) == 1 && Math.abs(offset[1]) == 1){
				Exit link = new Exit(passable, locked, name);
				link.link(r1);
				link.link(r2);
				this.exits.add(link);
			} else 
				Output.error("The rooms are not adjacent. Cannot link.");
		} 
	}
}
