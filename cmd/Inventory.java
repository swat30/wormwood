package cmd;
import obj.Item;
import obj.Player;
import core.Output;
import iface.Command;

/**
 * Inventory
 * Prints a list of the items and their descriptions that the player is 
 * carrying. 
 */
public class Inventory implements Command {
	
	public void exec (Player p) {
		int num = 0;
    
		for(int i=0;i<p.getInventory().size();i++){
			num++;
         Output.println(num + ". " + p.getInventory().get(i).getName() + " - " + p.getInventory().get(i));
		}

      if (p.getInventory().size() == 0) 
         Output.println("You are not carrying any items.");
	}
   
	public void construct(String params[]){}
	
	public String toString () {
		return "Usage: Inventory\nPrints a list of the items and their descriptions that the player is carrying.";
	}
}
