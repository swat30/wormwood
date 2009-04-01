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
		g1.linkRooms(r1, r2, true, false, "gate", "A gate made of faded copper.");
		g1.linkRooms(r2, r3, false, true, "door", "This door is locked.");
		g1.linkRooms(r2, r5, false, true, "door", "There is a door behind a large pile of blocks, but you can't get to it.");
		g1.linkRooms(r1, r4, true, true, "door", "This door appears to be locked AND blocked.");
		
		map.add(g1);
		
		return map;
	}
	
	/**
	 * Adds default aliases to the game
	 * Structure: aliases.add("<command> <params>");
	 */
	public static void aliases(){
		ArrayList<String> aliases = new ArrayList<String>();
		aliases.add("north move n");
		
		for(int i = 0; i < aliases.size(); i++)
			Parser.parse("alias @"+aliases.get(i));
	}
}	
