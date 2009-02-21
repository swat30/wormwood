package cmd;

import iface.Command;

import java.util.Vector;

import obj.Item;
import obj.Player;
import obj.Room;

public class Take implements Command {
   private String name;

   public void exec (Player p) {
      Room r = p.getRoom();
      Vector<Item> items = r.getItems();
      boolean somethingTaken = false;

      // jump through items in the room and see if the
      // item requested is there
      for (int i = 0; i < items.size(); i++) {
         if (name.equals(items.get(i).getName())) {
            somethingTaken = true;
            System.out.println("You picked up " + items.get(i).getName() + "."); 
            p.addToInventory(items.get(i)); 
            r.removeItem(items.get(i));
         }
      }

      if (somethingTaken == false)
         System.out.println("Unable to pick up " + name + ".");
   }

   public void construct(String params[]){
	   if(params[0].length() > 0)
		   this.setName(params[0]);
   }
   
   public void setDir (char d) {}

   public void setName (String n) {
      name = n;
   }
}
