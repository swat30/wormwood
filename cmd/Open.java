package cmd;
import obj.Exit;
import obj.Player;
import obj.Room;
import iface.Command;

public class Open implements Command {
   private String name;
   private char dir;

   public void exec (Player p) {
      Room r = p.getRoom();
      Exit e = r.getExit(dir);

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
   
   public void setDir (char d) {
      dir = d;
   }

   public void setName (String n) {
      name = n;
   }
}
