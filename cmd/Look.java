/*
 * 
 */
package cmd;
import core.Output;
import obj.Player;
import iface.Command;
import obj.Room;
import core.Grid;
import obj.Exit;
import core.handleData;

// TODO: Auto-generated Javadoc
/**
 * Look just prints out the description of the room
 * passed to it - generally the current room.
 */
public class Look implements Command {
   
   /* (non-Javadoc)
    * @see iface.Command#exec(obj.Player)
    */
   public void exec (Player p) {
	   Room curRoom = p.getRoom();
	   Grid curGrid = p.getGrid();
	   String[] dirs = {"north", "east", "west", "south"};
	 
      String d = "";

      
      for(int i = 0; i < dirs.length; i++){
    	   Exit curExit = curGrid.getExit(curRoom, dirs[i].substring(0, 1));
    	   if(curExit == null)
    	  	   dirs[i] = null;
      }
      
      String exits = handleData.arrToString(dirs);
      if(!exits.equalsIgnoreCase("")){
    	    d += " There ";
    	   if(exits.contains("and"))
    	      d += "are exits";
    	   else
    	      d += "is an exit";
    	   d += " to the "+exits;
      }
      d += ".";
      
      Output.println(curRoom + d);
   }
   
   /* (non-Javadoc)
    * @see iface.Command#construct(java.lang.String[])
    */
   public void construct(String params[]){}
   
   /* (non-Javadoc)
    * @see iface.Command#setDir(java.lang.String)
    */
   public void setDir (String d) {}
   
   /* (non-Javadoc)
    * @see iface.Command#setName(java.lang.String)
    */
   public void setName (String n) {}

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   public String toString () {
      return "Usage: Look\nPrints the description of the current room.";
   }
}
