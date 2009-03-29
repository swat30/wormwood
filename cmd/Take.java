package cmd;

import iface.Command;

import java.util.ArrayList;

import obj.Item;
import obj.Player;
import obj.Room;
import core.Output;

public class Take implements Command {
   private String name;

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

   public void construct(String params[]){
	   if(params[0].length() > 0)
		   this.setName(params[0]);
   }
   
   public void setDir (String d) {}

   public void setName (String n) {
      name = n;
   }

   public String toString () {
      return "Usage: Take <item_name>\nPicks up an item in the current room, if it is able to be picked up.";
   }
}
