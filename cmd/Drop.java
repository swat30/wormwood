/*
 * 
 */
package cmd;
import obj.Item;
import obj.Player;
import obj.Room;
import core.Output;
import iface.Command;

// TODO: Auto-generated Javadoc
/**
 * The Class Drop.
 */
public class Drop implements Command {
   
   /** The item name. */
   String itemName;

   /* (non-Javadoc)
    * @see iface.Command#exec(obj.Player)
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
   public void setName (String itemToDrop) {
      itemName = itemToDrop;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   public String toString () {
      return "Usage: Drop <item_name>\nDrops an item held in the inventory into the current room.";
   }
}
