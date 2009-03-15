/**
 * 
 * Extends the ArrayList class. This allows for customizable manipulation
 * of points.
 * 
 */
package core;
import java.util.ArrayList;

public class Point extends ArrayList<Object> {
	public static final long serialVersionUID = 8683452581122892189L;
	
	public Point(Object obj){
		this.add(obj);
	}
}
