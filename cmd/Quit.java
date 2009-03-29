package cmd;
import core.Input;
import core.Output;
import obj.Player;
import iface.Command;

public class Quit implements Command {
   public void exec (Player p) {
      Output.println("Are you sure you wish to quit? (y/n)");
      String answer;

      do {
         answer = Input.nextLine(); 
         if (answer.equalsIgnoreCase("y")) 
            System.exit(0);
         else if (!answer.equalsIgnoreCase("n"))
            // Continue loop
            Output.println("You must answer with y or n.");
      } while (!answer.equalsIgnoreCase("n"));
   }
   
   public String toString () {
      return "Usage: Quit\nQuits the game.";
   }

   public void construct(String params[]){}
   public void setDir (String d) {}
   public void setName (String n) {}
      
}
