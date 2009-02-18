/** Datatype that abstracts a basic game command entered at the game prompt. */
public interface Command {
   public void exec (Player p); 
   public void setDir (char d);
   public void setName (String n);
}
      
      


