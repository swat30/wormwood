/*
 * 
 */
package cmd;
import obj.Item;
import obj.Player;
import obj.Room;
import core.Output;
import iface.Command;

/**
 * The Drop Class.
 */
public class Drop implements Command {
   
   /** The Drop Command. */
   String itemName;

   /** 
    * When executed by a player, the drop command takes the item to be dropped from the players
    * list of items (unless it's not present) and places it in the current rooms list of items.
    *
    * @param p	the player executing the Drop command.
    * @see iface.Command#exec(obj.Player)
    * @see obj.Player
    * @see obj.Room
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
    * @see iface.Command#construct(java.lang.String[])
    * @see core.Parser
    */
   public void construct(String params[]){
	   if(params[0].length() > 0)
		   this.setName(params[0]);   
   }
   
   /** 
    * @param itemToDrop	the item to be dropped
    * @see iface.Command#setName(java.lang.String)
    */
   public void setName (String itemToDrop) {
      itemName = itemToDrop;
   }

   /**
    * @see java.lang.Object#toString()
    */
   public String toString () {
      return "Usage: Drop <item_name>\nDrops an item held in the inventory into the current room.";
   }
}
