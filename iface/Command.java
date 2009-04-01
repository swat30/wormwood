/*
 * 
 */
package iface;
import obj.Player;

/** Datatype that abstracts a basic game command entered at the game prompt. */
public interface Command {
   public void exec (Player p);
   public void construct(String params[]);
   public void setDir (String d);
   public void setName (String n);
   // toString returns the help description of the command
   public String toString ();
}
