/*
 * 
 */
package cmd;
import obj.Item;
import obj.Player;
import core.Output;
import iface.Command;

// TODO: Auto-generated Javadoc
/**
 * The Class Use.
 */
public class Use implements Command {
   
   /** The item name. */
   private String itemName;

   /* (non-Javadoc)
    * @see iface.Command#exec(obj.Player)
    */
   public void exec (Player p) {
      Item item = p.getItem(itemName);

      if (item != null)
         if (item.getNumUses() > 0)
            item.use(p);
         else  
            Output.println("You can't use this item anymore.");
      else 
         Output.println("You don't have this item.");
   }

   /* (non-Javadoc)
    * @see iface.Command#construct(java.lang.String[])
    */
   public void construct(String params[]){
	   if (params.length > 0)
         setName(params[0]);
   }
   
   /* (non-Javadoc)
    * @see iface.Command#setDir(java.lang.String)
    */
   public void setDir (String dir) {}

   /* (non-Javadoc)
    * @see iface.Command#setName(java.lang.String)
    */
   public void setName (String itemToBeUsed) {
      itemName = itemToBeUsed;
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   public String toString () {
      return "Usage: Use <item_name>\nUses an item in the inventory. For example, if you have a gun, it will shoot the gun. Some items have a limited number of uses.";
   }
}


