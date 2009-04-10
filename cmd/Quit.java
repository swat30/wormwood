package cmd;
import core.Input;
import core.Output;
import obj.Player;
import iface.Command;
import core.Game;

/**
 * Quit 
 * Quits the game.
 */
public class Quit implements Command {
   
   public void exec (Player p) {
      Output.println("Are you sure you wish to quit? (y/n)");
      String answer;

      do {
         answer = Input.nextLine(); 
         if (answer.equalsIgnoreCase("y")) 
            Game.kill();
         else if (!answer.equalsIgnoreCase("n") && !answer.equalsIgnoreCase("y"))
            // Continue loop
            Output.println("You must answer with y or n.");
      } while (!answer.equalsIgnoreCase("n") && !answer.equalsIgnoreCase("y"));
   }
   
   public String toString () {
      return "Usage: Quit\nQuits the game.";
   }

   public void construct(String params[]){}
}
