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
      NPC srini = new NPC("Srini", sriniIdentifiers , "This man is the Java King.", "A man wearing a blue dress shirt and a tie is standing at the front of the auditorium.");
      srini.addDialog("Hello to you, and a very happy new year!");
      Item laptop = new Item("laptop", "A broken laptop.", "There is a laptop on the ground.", 99, kate);
		
      Room cs_entrance = new Room("CS Building Entrance", "A large building looms in front of you. The Goldberg Computer Science Building. You're late for Srini's class, so you had better get in there!");
		Room cs_foyer = new Room("Computer Science Building Foyer", "No one is around. That's odd for the usually bustling Computer Science Building.");
		Room cs_auditorium = new Room("Auditorium", "The auditorium is in good condition, with rows upon rows of chairs and desks.", laptop, srini);
		
		Grid g1 = new Grid(20, 20);
		g1.add(cs_entrance, 0, 1);
		g1.add(cs_foyer, 0, 0);
		g1.add(cs_auditorium, 1, 0);
		g1.linkRooms(cs_entrance, cs_foyer, true, false, "doors", "Several glass doors greet you at the front of the Goldberg Computer Science Building. They all point you to the right, telling you to 'Use the Rightmost door after 5pm'.");
		g1.linkRooms(cs_foyer, cs_auditorium, true, false, "door", "Nothing special here.");
		map.add(g1);
		
		return map;
	}
	
	/**
	 * Adds default aliases to the game
	 * Structure: aliases.add("<command> <params>");
	 */
	public static void defaultAliases(){
		ArrayList<String> aliases = new ArrayList<String>();
		aliases.add("north move n");
		
		for(int i = 0; i < aliases.size(); i++)
			Parser.parse("alias @"+aliases.get(i));
	}
}	
