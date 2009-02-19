package cmd;
import core.Output;
import obj.Player;
import iface.Command;

/** Look just prints out the description of the room
 * passed to it - generally the current room */
public class Look implements Command {
   public void exec (Player p) {
      Output.println(p.getRoom());       
   }
   
   public void construct(String params[]){
	   if(params[0].length() > 0)
		   this.setDir(params[0].charAt(0));
   }

   public void setDir (char d) {}
   public void setName (String n) {}
}
