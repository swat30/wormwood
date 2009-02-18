/** Look just prints out the description of the room
 * passed to it - generally the current room */
public class Look implements Command {
   public void exec (Player p) {
      Output.println(p.getRoom());       
   }

   public void setDir (char d) {}
   public void setName (String n) {}
}
