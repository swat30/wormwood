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
      String[] sriniIdentifiers = {"man", "dude", "prof", "l33t"};
      NPC srini = new NPC("Srini", sriniIdentifiers , "This man is the Java King.", "A man wearing a blue dress shirt and a tie is standing to your left.");
	   Item gun = new Item("gun", "a frikkin gun", "There is a gun lying on the ground.", 3, kate);
	   Item[] items = {gun};
      NPC[] npcs = {srini};
           // new item to test inventory
           Item cigs = new Item("Cigs", "Jacobs half empty box of smokes", "There is a package of cigarettes on the ground", 5, kate);
           Item[] items2 = {cigs};
		Room r5 = new Room("North Forrest", "Northerly!");
		Room r2 = new Room("East Forrest", "Easterly!", items2);
		Room r3 = new Room("West Forrest", "Westerly!");
		Room r4 = new Room("South Forrest", "Southerly!");
		Room r1 = new Room("Forrest Entrance", "A dark forrest.", items, npcs);
		
		Grid g1 = new Grid(20, 20);
		g1.add(r1, 0, 0);
		g1.add(r2, 1, 0);
		g1.add(r3, 1, 1);
		g1.add(r4, 4, 4);
		g1.add(r5, 2, 0);
		g1.linkRooms(r1, r2, true, false, "e", "A gate made of faded copper.", "There is a gate to the east.");
		g1.linkRooms(r2, r3, true, true, "w", "This door is locked.", "There is a door to the west.");
		g1.linkRooms(r2, r5, false, false, "n", "There is a door behind the blocks, but you can't get to it.", "There is a large pile of cement blocks to the north.");
		g1.linkRooms(r1, r4, true, true, "s", "This door appears to be locked AND blocked.", "There is a door to the south.");
		
		map.add(g1);
		
		return map;
	}
}	
