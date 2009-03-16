package cmd;
import core.Grid;
import obj.Exit;
import obj.Player;
import obj.Room;
import iface.Command;

public class Open implements Command {
   private String name;
   private String dir;

   public void exec (Player p) {
	  // Get current room to find exits
	  Room r = p.getRoom();
	  Grid g = p.getGrid();
	  Exit e = g.getExit(r, this.dir);
	
	  // A null room is returned if the exit doesn't exist
      if (e != null && e.getName() == name) {
         if (e.isPassable()) 
            System.out.println("Nothing to open here.");
         else if (e.isLocked())
            System.out.println("Locked.");
         else if (e.isPassable() == false && e.isLocked() == false)
            e.setPassable(true);
      }

      else 
         System.out.println("Nothing to open here.");
   }

   public void construct(String params[]){
	   
   }
   
   public void setDir (String d) {
      dir = d;
   }

   public void setName (String n) {
      name = n;
   }

   public String toString () {
      return "Usage: Open <direction> <object>\nOpens a door (or other object, such as a box) that lies in the direction specified,";
   }
}
