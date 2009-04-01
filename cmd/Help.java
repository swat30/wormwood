/*
 * 
 */
package cmd;
import java.lang.reflect.Method;
import java.io.File;
import java.util.regex.Pattern;
import iface.Command;
import obj.Player;
import core.Output;
import core.handleData;

// TODO: Auto-generated Javadoc
/**
 * The Class Help.
 */
public class Help implements Command {
   
   /** The cmd name. */
   private String cmdName;
   
   /** The cmd dir. */
   private File cmdDir = new File("./cmd");

   /* (non-Javadoc)
    * @see iface.Command#exec(obj.Player)
    */
   public void exec (Player p) {
      if (cmdName != null) {
         try {
            Class cmdClass = Class.forName("cmd." + cmdName);	
            Object obj = cmdClass.newInstance();
            Output.println(obj);
         } catch (Exception classNotFoundException) {
            Output.println(cmdName + " does not exist.");  
         }
      }

      // Help not supplied with parameters, print a list of commands
      else {
         Output.println("Game Commands: "); 

         // Get a list of filenames in the command directory
         String[] cmdList = cmdDir.list();   
         for (int i = 0; i < cmdList.length; i++) 
            // Command names will be .java files
            if (Pattern.matches(".*java$", cmdList[i])) {
               // Remove the .java from the command name
               String cmd = cmdList[i].substring(0, cmdList[i].indexOf("."));
               Output.println(cmd);
            }

         Output.println("Type help <cmd_name> for help on a specific command.");
      }
   }

   /* (non-Javadoc)
    * @see iface.Command#construct(java.lang.String[])
    */
   public void construct (String params[]) {
      if (params.length > 0)
         setName(params[0]); 
   }

   /* (non-Javadoc)
    * @see iface.Command#setName(java.lang.String)
    */
   public void setName (String n) {
      cmdName = handleData.upperFirst(n);
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   public String toString () {
      return "Usage: Help <cmd_name> \nPrints a message describing the command given to it. If used without arguments, prints a list of all the game commands.";
   }
   
   /* (non-Javadoc)
    * @see iface.Command#setDir(java.lang.String)
    */
   public void setDir (String d) {}
}

   
