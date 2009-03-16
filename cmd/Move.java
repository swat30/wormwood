package cmd;
import core.Output;
import core.Grid;
import obj.Exit;
import obj.Player;
import obj.Room;
import iface.Command;

public class Move implements Command {
   private String dir;

   public void exec (Player player) {
      // Get current room to find exits
      Room r = player.getRoom();
      Grid g = player.getGrid();
      Exit e = g.getExit(r, this.dir);

      // A null room is returned if the exit doesn't exist
      if (e != null) {
    	 Room newRoom = e.getDestRoom(r);
         player.setRoom(newRoom);
         // Print the description of the room
         System.out.println(newRoom);
      }
      else
         Output.println("You cannot go that way.");
   }

   public void construct(String params[]){
	   this.setDir(params[0].toLowerCase());
   }  
   
   public void setDir (String d) {
      dir = d;
   }

   public String toString () {
      return "Usage: Move <direction>\nMoves player from one room to another. For example, 'move n' will move you from the current room to the north room that it connects to.";
   }

   public void setName (String n) {}
}
