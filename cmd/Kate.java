package cmd;
import obj.Player;
import iface.Command;

public class Kate implements Command {
   public void exec (Player p) {
      System.out.println("Kate disapproves.");
   }
   
   public void construct(String params[]){
	   
   }

   public void setDir (String d) {} 
   public void setName (String n) {}
}
