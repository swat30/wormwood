package cmd;
import core.Output;
import obj.Item;
import obj.NPC;
import obj.Player;
import obj.Room;
import iface.Command;

public class Examine implements Command {
   private String object;

   /** Each object that can be examined should have
    * a toString that will print relevant information.*/
   public void exec (Player p) {
      NPC npc = null;
      Item i = null;
      Room r = p.getRoom();

      // Defaults to checking room first
      i = r.getItem(object);
      npc = r.getNPC(object);
      
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
      else
         Output.println(object + " not found.");
   }

   public void construct(String params[]){
	   if (params[0].length() > 0)
         this.setName(params[0]);
   }
   
   public void setDir (String d) {}

   public void setName (String objectToExamine) {
      object = objectToExamine;
   }

   public String toString () {
      return "Usage: Examine <item_name>\nExamines an item in the player's inventory or lying in the room. If two items have the same name, it defaults to examining the room before the inventory.";
   }
}

