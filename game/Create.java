/**
 * 
 * Used to create a game based on the wormwood engine
 * 
 */
package game;
import iface.Command;

import java.util.ArrayList;

import cmd.Kate;
import obj.*;
import core.*;

public class Create {
	/**
	 * 
	 * Used to create the game. The initial map ArrayList<Grid> must be used and returned.
	 * The first grid added to the list is the starting grid, and the first room added to
	 * this grid is the starting room.
	 * 
	 */
	public static ArrayList<Grid> init(){
		ArrayList<Grid> map = new ArrayList<Grid>();
		Command kate = new Kate();
      NPC srini = new NPC("Srini", "The Java King.");
	   Item gun = new Item("gun", "a frikkin gun", 3, kate);
	   Item[] items = {gun};
      NPC[] npcs = {srini};
		Room r5 = new Room("North Forrest", "Northerly!");
		Room r2 = new Room("East Forrest", "Easterly!");
		Room r3 = new Room("West Forrest", "Westerly!");
		Room r4 = new Room("South Forrest", "Southerly!");
		Room r1 = new Room("Forrest Entrance", "A dark forrest.", items, npcs);
		
		Grid g1 = new Grid(20, 20);
		g1.add(r1, 0, 0);
		g1.add(r2, 1, 0);
		g1.add(r3, 1, 1);
		g1.add(r4, 4, 4);
		g1.add(r5, 2, 0);
		g1.linkRooms(r1, r2, true, false, "East-west gate");
		g1.linkRooms(r2, r3, true, true, "Locked door");
		g1.linkRooms(r2, r5, false, false, "Door blocked by large pile of cement blocks");
		g1.linkRooms(r1, r4, true, true, "Impossible");
		
		map.add(g1);
		
		return map;
	}
}	
