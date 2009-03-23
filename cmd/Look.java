package cmd;
import core.Output;
import obj.Player;
import iface.Command;
import obj.Room;
import core.Grid;
import obj.Exit;
import core.handleData;

/** Look just prints out the description of the room
 * passed to it - generally the current room */
public class Look implements Command {
   public void exec (Player p) {
	  Room curRoom = p.getRoom();
	  Grid curGrid = p.getGrid();
	  String[] dirs = {"north", "east", "west", "south"};
	 
      Output.println(curRoom);
      
      for(int i = 0; i < dirs.length; i++){
    	  Exit curExit = curGrid.getExit(curRoom, dirs[i].substring(0, 1));
    	  if(curExit == null)
    		  dirs[i] = null;
      }
      
      String exits = handleData.arrToString(dirs);
      if(!exits.equalsIgnoreCase("")){
    	  Output.print("There ");
    	  if(exits.contains("and"))
    	  	Output.print("are exits");
    	  else
    		  Output.print("is an exit");
    	  Output.println(" to the "+exits);
      }
   }
   
   public void construct(String params[]){}
   public void setDir (String d) {}
   public void setName (String n) {}

   public String toString () {
      return "Usage: Look\nPrints the description of the current room.";
   }
}
