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
 * The Class Inventory.
 */
public class Inventory implements Command {
	
	/* (non-Javadoc)
	 * @see iface.Command#exec(obj.Player)
	 */
	public void exec (Player p) {
		int num = 0;
    
		for(int i=0;i<p.getInventory().size();i++){
			num++;
         Output.println(num + ". " + p.getInventory().get(i).getName() + " - " + p.getInventory().get(i));
		}

      if (p.getInventory().size() == 0) 
         Output.println("You are not carrying any items.");
	}
   
	/* (non-Javadoc)
	 * @see iface.Command#construct(java.lang.String[])
	 */
	public void construct(String params[]){}
	
	/* (non-Javadoc)
	 * @see iface.Command#setDir(java.lang.String)
	 */
	public void setDir (String d) {}
	
	/* (non-Javadoc)
	 * @see iface.Command#setName(java.lang.String)
	 */
	public void setName (String n) {}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString () {
		return "Usage: Inventory\nPrints a list of the items and their descriptions that the player is carrying.";
	}
}
