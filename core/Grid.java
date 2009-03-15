/**
 * 
 * Collects an array of points (ArrayList extensions) to be manipulated
 * in a map-like manner.
 *
 */
package core;
public class Grid {
	private Point[][] points;
	
	/** Starts a new grid with specified dimensions, Xmax by Ymax */
	public Grid(int Xmax, int Ymax){
		points = new Point[Xmax][Ymax];
	}
	
	/** Adds an object at the specified point */
	public void add(Object obj, int x, int y){
		try {
			//If there isn't a point at the location, create it
			if(points[x][y] == null){
				Point newPt = new Point(obj);
				points[x][y] = newPt;
			//Else just add the obj to the existing point
			} else 
				points[x][y].add(obj);
		} catch(Exception e){
			Output.error("Point ("+x+","+y+") is outside the grid.");
		}
	}
	
	/** Returns the object(s) north of point p */
	public Point objNorth(Point p){
		return this.objAtOffset(p, 0, 1);
	}
	
	/** Returns the object(s) east of point p */
	public Point objEast(Point p){
		return this.objAtOffset(p, 1, 0);
	}
	
	/** Returns the object(s) south of point p */
	public Point objSouth(Point p){
		return this.objAtOffset(p, 0, -1);
	}
	
	/** Returns the object(s) west of point p */
	public Point objWest(Point p){
		return this.objAtOffset(p, -1, 0);
	}
	
	/** Returns the object(s) at an offset of point p */
	public Point objAtOffset(Point p, int xOffset, int yOffset){
		try {
			int[] coordinates = this.getCoord(p);
			return this.points[coordinates[0]+xOffset][coordinates[1]+yOffset];
		} catch(Exception e){
			Output.error("The grid ends below this object.");
		}
		return null;
	}
	
	/** Returns the coordinates of point p in an array
	 *  with index 0 = x and 1 = y */
	public int[] getCoord(Point p){
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
}	
