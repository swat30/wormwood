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
   
   public void construct(String params[]){}
   public void setDir (String d) {}
   public void setName (String n) {}

   public String toString () {
      return "Usage: Look\nPrints the description of the current room.";
   }
}
