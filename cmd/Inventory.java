package cmd;
import obj.Item;
import obj.Player;
import core.Output;
import iface.Command;

public class Inventory implements Command {
	public void exec (Player p) {
		int num = 0;
		String str = "";
		for(int i=0;i<p.getInventory().size();i++){
			num++;
			str += num+".\t"+p.getInventory().get(i)+"\n";
		}
		Output.println(str);       
	}
   
	public void construct(String params[]){}
	public void setDir (String d) {}
	public void setName (String n) {}

	public String toString () {
		return "Usage: Look\nPrints a list of items that the player has on them.";
	}
}
