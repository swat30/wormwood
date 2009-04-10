package cmd;
import obj.Item;
import obj.Player;
import obj.Room;
import core.Output;
import iface.Command;

/**
* Drop
* When executed by a player, the drop command takes the item to be dropped
* from the player's inventory (unless it's not present) and places it in the
* current room's list of items.
*/
public class Drop implements Command {
   String itemName;

    /**
    * @param p	the player executing the Drop command.
    */
   public void exec (Player p) {
      Room r = p.getRoom();
      Item item = p.getItem(itemName);
      boolean removed = p.removeItem(itemName);

      // If the item was dropped
      if (removed == true) {
         // Drop it into the room 
         // The original room description won't apply anymore, 
         // as it has been picked up and dropped
         item.setRoomDesc("There is a " + item.getName() + " lying on the ground.");
         r.addItem(item);
         Output.println("You dropped " + itemName + ".");
      }
      else 
         Output.println("You don't have a " + itemName + " to drop.");
   }

   /**
    * @param params[]	the parameters taken for the drop command.
    */
   public void construct(String params[]){
	   if(params[0].length() > 0)
		   this.setName(params[0]);   
   }
   
   /** 
    * @param itemToDrop	the item to be dropped
    */
   public void setName (String itemToDrop) {
      itemName = itemToDrop;
   }

   public String toString () {
      return "Usage: Drop <item_name>\nDrops an item held in the inventory into the current room.";
   }
}
