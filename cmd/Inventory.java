package cmd;
import obj.Item;
import obj.Player;
import core.Output;
import iface.Command;

public class Inventory implements Command {
	public void exec (Player p) {
		Output.println(p.getInventory());       
	}
   
	public void construct(String params[]){}
	public void setDir (String d) {}
	public void setName (String n) {}

	public String toString () {
		return "Usage: Look\nPrints a list of items that the player has on them.";
	}
}
