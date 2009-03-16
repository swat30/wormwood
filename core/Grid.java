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
	private Room firstRoom;
	private ArrayList<Exit> exits;
	
	/** 
	 * Starts a new grid with specified dimensions, Xmax by Ymax 
	 * @param Xmax define the maximum x value on the grid
	 * @param Ymax define the maximum y value on the grid
	 */
	public Grid(int Xmax, int Ymax){
		points = new Room[Xmax][Ymax];
		exits = new ArrayList<Exit>();
	}
	
	/** 
	 * Returns the start room 
	 * @return the first room added to the grid. This is considered the first room. 
	 */
	public Room getStart(){
		return this.firstRoom;
	}
	
	/** 
	 * Adds an object at the specified point 
	 * @param obj room to be added to the grid
	 * @param x x value of room on grid
	 * @param y y value of room on grid 
	 */
	public void add(Room obj, int x, int y){
		try {
			//If there isn't a point at the location, create it
			if(points[x][y] == null){
				points[x][y] = obj;
				if(this.firstRoom == null)
					this.firstRoom = points[x][y];
			}
			//Else just add the obj to the existing point
			else 
				Output.error("Point ("+x+","+y+") already has a room on it.");
		} catch(Exception e){
			Output.error("Point ("+x+","+y+") is outside the grid.");
		}
	}
	
	/** 
	 * Returns the object(s) north of point p 
	 * @param p reference room
	 * @return the room to the north of room 'p' 
	 */
	public Room objNorth(Room p){
		return this.roomAtOffset(p, 0, 1);
	}
	
	/** Returns the object(s) east of point p */
	public Room objEast(Room p){
		return this.roomAtOffset(p, 1, 0);
	}
	
	/** Returns the object(s) south of point p */
	public Room objSouth(Room p){
		return this.roomAtOffset(p, 0, -1);
	}
	
	/** Returns the object(s) west of point p */
	public Room objWest(Room p){
		return this.roomAtOffset(p, -1, 0);
	}
	
	/** Returns the object(s) at an offset of point p */
	public Room roomAtOffset(Room p, int xOffset, int yOffset){
		try {
			int[] coordinates = this.getCoord(p);
			return this.points[coordinates[0]+xOffset][coordinates[1]+yOffset];
		} catch(Exception e){
			Output.error("The grid ends before/att the specified offset from \""+p.getName()+"\".");
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
			if(Math.abs(offset[0]) == 1 || Math.abs(offset[1]) == 1){
				Exit link = new Exit(passable, locked, name);
				link.link(r1);
				link.link(r2);
				this.exits.add(link);
			} else 
				Output.error("The rooms are not adjacent. Cannot link room \""+r1.getName()+"\" with \""+r2.getName()+"\"");
		} 
	}
	
	/** Returns the exit corresponding to the room and direction specified */
	public Exit getExit(Room r, String d){
		int[] offset = {0,0};
		
		if(d.equalsIgnoreCase("n"))
			offset[1] = 1;
		else if(d.equalsIgnoreCase("e"))
			offset[0] = 1;
		else if(d.equalsIgnoreCase("s"))
			offset[1] = -1;
		else if(d.equalsIgnoreCase("w"))
			offset[0] = -1;
		else 
			return null;

		Room newRoom = this.roomAtOffset(r, offset[0], offset[1]);
		
		for(int i = 0; i < exits.size(); i++){
			Room[] exitRooms = exits.get(i).getRooms();
			if((exitRooms[0] == r && exitRooms[1] == newRoom) || (exitRooms[1] == r && exitRooms[0] == newRoom))
				return exits.get(i);
		}
		
		return null;
	}
}
