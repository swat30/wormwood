/*
 * 
 */
package cmd;
import core.Grid;
import obj.Exit;
import obj.Player;
import obj.Room;
import iface.Command;

// TODO: Auto-generated Javadoc
/**
 * The Class Open.
 */
public class Open implements Command {
   
   /** The name. */
   private String name;
   
   /** The dir. */
   private String dir;

   /* (non-Javadoc)
    * @see iface.Command#exec(obj.Player)
    */
   public void exec (Player p) {
	  // Get current room to find exits
	  Room r = p.getRoom();
	  Grid g = p.getGrid();
	  Exit e = g.getExit(r, this.dir);
	
	  // A null room is returned if the exit doesn't exist
      if (e != null) {
         if (e.isPassable()) 
            System.out.println("The " + e.getName() + " is already open.");
         else if (e.isLocked())
            System.out.println("Locked.");
         else if (e.isPassable() == false && e.isLocked() == false)
            e.setPassable(true);
      }

      else 
         System.out.println("Nothing to open here.");
   }

   /* (non-Javadoc)
    * @see iface.Command#construct(java.lang.String[])
    */
   public void construct(String params[]){
	   if (params.length > 0) {
         setDir(params[0]);
         if (params.length == 2)
            setName(params[1]);
      }
   }
   
   /* (non-Javadoc)
    * @see iface.Command#setDir(java.lang.String)
    */
   public void setDir (String d) {
      dir = d;
   }

   /* (non-Javadoc)
    * @see iface.Command#setName(java.lang.String)
    */
   public void setName (String n) {
      name = n;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   public String toString () {
      return "Usage: Open <direction> <object>\nOpens a door (or other object, such as a box) that lies in the direction specified,";
   }
}
