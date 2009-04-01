/*
 * 
 */
package cmd;

import iface.Command;

import java.util.ArrayList;

import obj.Item;
import obj.Player;
import obj.Room;
import core.Output;

// TODO: Auto-generated Javadoc
/**
 * The Class Take.
 */
public class Take implements Command {
   
   /** The name. */
   private String name;

   /* (non-Javadoc)
    * @see iface.Command#exec(obj.Player)
    */
   public void exec (Player p) {
      Room r = p.getRoom();
      Item i = null;
      ArrayList<Item> items = r.getItems();
      boolean somethingTaken = false;

      i = r.getItem(name);
      
      if (i != null) {
         Output.println("You picked up " + i.getName() + ".");
         p.addToInventory(i);
         r.removeItem(i);
      }

      else 
         Output.println("Unable to pick up " + name + ".");
   }

   /* (non-Javadoc)
    * @see iface.Command#construct(java.lang.String[])
    */
   public void construct(String params[]){
	   if(params[0].length() > 0)
		   this.setName(params[0]);
   }
   
   /* (non-Javadoc)
    * @see iface.Command#setDir(java.lang.String)
    */
   public void setDir (String d) {}

   /* (non-Javadoc)
    * @see iface.Command#setName(java.lang.String)
    */
   public void setName (String n) {
      name = n;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   public String toString () {
      return "Usage: Take <item_name>\nPicks up an item in the current room, if it is able to be picked up.";
   }
}
