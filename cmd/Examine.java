package cmd;
import obj.Item;
import obj.Player;
import obj.Room;
import iface.Command;

public class Examine implements Command {
   private String object;

   /** Each object that can be examined should have
    * a toString that will print relevant information.*/
   public void exec (Player p) {
      Item i;
      Room r = p.getRoom();

      // Defaults to checking room first
      i = r.getItem(object);
      
      // Checks inventory if item not in room
      if (i == null)
         i = p.getItem(object);
      
      // If the item was found in inventory or in room
      if (i != null)
         System.out.println(i);
   }

   public void construct(String params[]){
	   
   }
   
   public void setDir (String d) {}

   public void setName (String objectToExamine) {
      object = objectToExamine;
   }
}

