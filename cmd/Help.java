package cmd;
import java.lang.reflect.Method;
import java.io.File;
import java.util.regex.Pattern;
import iface.Command;
import obj.Player;
import core.Output;
import core.handleData;

public class Help implements Command {
   private String cmdName;
   private File cmdDir = new File("./cmd");

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

   public void construct (String params[]) {
      if (params.length > 0)
         setName(params[0]); 
   }

   public void setName (String n) {
      cmdName = handleData.upperFirst(n);
   }

   public String toString () {
      return "Usage: Help <cmd_name> \nPrints a message describing the command given to it. If used without arguments, prints a list of all the game commands.";
   }
   
   public void setDir (String d) {}
}

   
