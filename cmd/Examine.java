/*
 * 
 */
package cmd;
import core.Output;
import obj.Item;
import obj.Exit;
import core.Grid;
import obj.NPC;
import obj.Player;
import obj.Room;
import iface.Command;

// TODO: Auto-generated Javadoc
/**
 * The Class Examine.
 */
public class Examine implements Command {
   
   /** The object. */
   private String object;

   /**
    * Each object that can be examined should have
    * a toString that will print relevant information.
    * 
    * @param p the p
    */
   public void exec (Player p) {
      NPC npc = null;
      Item i = null;
      Exit e = null;
      Room r = p.getRoom();
      Grid g = p.getGrid();

      // Defaults to checking room first
      i = r.getItem(object);
      npc = r.getNPC(object);
      e = g.getExit(r, this.object);
      
      // If the object is not in the room, it might be an item
      // held in the player's inventory
      if (i == null)
         i = p.getItem(object);
      
      // If the object was found in inventory or in room
      if (i != null)
         Output.println(i);
      // If it was an NPC
      else if (npc != null)
         Output.println(npc);
      // If it was an Exit
      else if (e != null)
         Output.println(e);
      else
         Output.println(object + " not found.");
   }

   /* (non-Javadoc)
    * @see iface.Command#construct(java.lang.String[])
    */
   public void construct(String params[]){
	   if (params[0].length() > 0)
         this.setName(params[0]);
   }
   
   /* (non-Javadoc)
    * @see iface.Command#setDir(java.lang.String)
    */
   public void setDir (String d) {}

   /* (non-Javadoc)
    * @see iface.Command#setName(java.lang.String)
    */
   public void setName (String objectToExamine) {
      object = objectToExamine;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   public String toString () {
      return "Usage: Examine <item_name>\nExamines an item in the player's inventory, an item lying in the room, or an NPC in the room. If two items have the same name, it defaults to examining the room before the inventory.";
   }
}

