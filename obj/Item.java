package obj;
import iface.Command;

public class Item {
   private String name;
   private String desc;
   private Command cmd;
   private int numUses;

   public Item (String name, String description, int numUses, Command cmd) {
      setName(name);
      setDesc(description);
      setCmd(cmd);
      setNumUses(numUses);
   }

   public void setName (String n) {
      name = n;
   }

   public void setDesc (String d) {
      desc = d;
   }

   public void setCmd (Command c) {
      cmd = c;
   }

   public void setNumUses (int n) {
      numUses = n;
   }

   public String getName () {
      return name;
   }

   public String getDesc () {
      return desc;
   }

   public Command getCmd () {
      return cmd;
  }

   public int getNumUses () {
      return numUses;
   }

   /** The item has a command assoicated with it
    * Each instance of an item has a unique command
    * This is invoked by calling this use method
    * The use method is called by the Use class,
    * which is a general command, so that "use item"
    * can be called instead of the specific command
    * name associated with a particular item. */
   public void use (Player p) {
      cmd.exec(p);
      numUses--;
   }
   
   public String toString () {
      return name + ": " + desc;
   }
}
