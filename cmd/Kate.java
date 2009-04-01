/*
 * 
 */
package cmd;
import obj.Player;
import iface.Command;

// TODO: Auto-generated Javadoc
/**
 * The Class Kate.
 */
public class Kate implements Command {
   
   /* (non-Javadoc)
    * @see iface.Command#exec(obj.Player)
    */
   public void exec (Player p) {
      System.out.println("Kate disapproves.");
   }
   
   /* (non-Javadoc)
    * @see iface.Command#construct(java.lang.String[])
    */
   public void construct(String params[]){
	   
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   public String toString () {
      return "Help not implemented for Kate.";
   }
   
   /* (non-Javadoc)
    * @see iface.Command#setDir(java.lang.String)
    */
   public void setDir (String d) {} 
   
   /* (non-Javadoc)
    * @see iface.Command#setName(java.lang.String)
    */
   public void setName (String n) {}
}
