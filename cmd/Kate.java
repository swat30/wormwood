package cmd;
import core.Output;
import obj.Player;
import iface.Command;

/**
 * A simple test class that prints a statement. 
 */
public class Kate implements Command {
   public void exec (Player p) {
      Output.println("Kate disapproves.");
   }
   
   public void construct(String params[]){}

   public String toString () {
      return "Kate - Prints a trivial message.";
   }
}
