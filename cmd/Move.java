package cmd;
import core.Output;
import obj.Exit;
import obj.Player;
import obj.Room;
import iface.Command;

public class Move implements Command {
   private String dir;

   public void exec (Player player) {
      // Get current room to find exits
      Room r = player.getRoom();
      Exit e = r.getExit(dir);      

      // A null room is returned if the exit doesn't exist
      if (e != null) {
         Room newRoom = e.getRoom();
         player.setRoom(newRoom);
         // Print the description of the room
         System.out.println(newRoom);
      }
      else
         Output.println("You cannot go that way.");
   }

   public void construct(String params[]){
      s.setDir(params[0].toLowerCase().charAt(0));
   }  
   
   public void setDir (String d) {
      dir = d;
   }

   public String toString () {
      return "Usage: Move <direction>\nMoves player from one room to another. For example, 'move n' will move you from the current room to the north room that it connects to.";
   }

   public void setName (String n) {}
}
