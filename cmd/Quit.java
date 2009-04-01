/*
 * 
 */
package cmd;
import core.Input;
import core.Output;
import obj.Player;
import iface.Command;
import core.Game;

// TODO: Auto-generated Javadoc
/**
 * The Class Quit.
 */
public class Quit implements Command {
   
   /* (non-Javadoc)
    * @see iface.Command#exec(obj.Player)
    */
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
   
   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   public String toString () {
      return "Usage: Quit\nQuits the game.";
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
      
}
