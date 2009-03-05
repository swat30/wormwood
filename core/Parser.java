package core;
import java.lang.reflect.Method;
import java.lang.String;
import cmd.*;

public class Parser {
   /** Takes a raw command and turns it into something the game can understand*/
   public static Object parse (String rawCmd) { 
      String cmd;
      String[] params;
      String[] stringParse;

      // Remove leading/trailing whitespace
      rawCmd = rawCmd.trim();         
      rawCmd = rawCmd.toLowerCase();
      
      //Separate input into individual words and separate into the command and its parameters
      stringParse = rawCmd.split(" ");
      params = new String[stringParse.length - 1];
      // Switch the first letter of the command name from lowercase to upper case 
      // So that it can be matched (eg, it's Look.java, not look.java)
      cmd = handleData.upperFirst(stringParse[0]);
      if(stringParse.length > 1)
    	  params = handleData.removeFirst(stringParse);

      // Default null cmd, unless proven otherwise
      Object obj = null;

      try {
    	  // Get the class object associated with the command name
        Class tClass = Class.forName("cmd."+cmd);
		  obj = tClass.newInstance();
		  Object parameters[] = {params};
		  Method con = tClass.getMethod("construct", String[].class);
		  con.invoke(obj, parameters);
      } catch(java.lang.reflect.InvocationTargetException e){
    	  Output.print("Invalid parameters for command. Type 'help "+cmd+"' for options.");
      } catch(Exception e){
    	  Output.print("Invalid command. Type 'help' for a list of commands.\n");
      }
      
      return obj;
   }
}
