/*
 * 
 */
package iface;
import obj.Player;

/** Datatype that abstracts a basic game command entered at the game prompt. */
public interface Command {
   /** exec is the main method of the command. exec is called by 
    * executeCommand in the core.Game class. Everything that should happen
    * when you execute the command, besides the initialisation of what
    * the command should execute on, should happen in this method.
    *
    * @param p is the main player. The player is passed to exec because
    * a lot of useful info, such as the current room, are attached to the
    * Player class.
    */
   public void exec(Player p);

   /** construct is called when the Command is created. construct 
    * should parse the params array, and get relevant information 
    * from it. For example, if the command was "move e", the params
    * array would contain "e", so the construct command should set
    * an instance variable dir that has "e" as its value. Then, 
    * when exec is called, it can use this information.
    *
    * @param Array of arguments to construct the command. Commands
    * can take no arguments.
    */
   public void construct(String params[]);
   
   /** @return The description of the command created for the Help
    * command to print when the player types "help your_cmd_name". 
    */
   public String toString();
}
