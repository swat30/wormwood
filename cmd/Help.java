package cmd;
import java.lang.reflect.Method;
import iface.Command;
import obj.Player;
import core.Output;
import core.handleData;

public class Help implements Command {
   private String cmdName;

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

      // Help not supplied with parameters
      else {
         Output.println("Type help <cmd_name> to receive a description of that specific command.");
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
      return "Help: prints a message describing the command given to it.";
   }
   
   public void setDir (String d) {}
}

   
