package obj;
import iface.Command;

public class Item extends Entity {
   private Command cmd;
   private int numUses;

   /** Creates a new item. */
   public Item (String name, String description, String roomDescription, int numUses, Command cmd) {
      super(name, description, roomDescription);
      setCmd(cmd);
      setNumUses(numUses);
   }

   /** Sets the command that the item is associated with. */
   public void setCmd (Command c) {
      cmd = c;
   }

   /** Sets how many times the item can be used. */
   public void setNumUses (int n) {
      numUses = n;
   }

   /**@return: The command that the item performs when used.*/
   public Command getCmd () {
      return cmd;
   }

   /**@return: How many uses the item has left. */
   public int getNumUses () {
      return numUses;
   }

   /** The item has a command assoicated with it.
    * Each instance of an item has a unique command.
    * This is invoked by calling this use method.
    * The use method is called by the Use class,
    * which is a general command, so that "use item"
    * can be called instead of the specific command
    * name associated with a particular item. */
   public void use (Player p) {
      cmd.exec(p);
      numUses--;
   }
}
