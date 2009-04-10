package core;
import java.lang.reflect.Method;
import java.lang.String;
import cmd.*;

/*
 * Parser
 * The Parser takes a raw String entered at the prompt. The general form
 * for a command in Wormwood is cmd name arguments. For example, the user 
 * might type ”move e”. The Parser splits this input up into the command and
 * the arguments. It then uses Java’s generic class constructors to 
 * dynamically create the Command class, based on whether or not it can find
 * the corresponding cmd name.java file in the cmd package. 
 */
public class Parser {
   /** @param A raw command and turns it into something the game can understand*/
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
      cmd = HandleData.upperFirst(stringParse[0]);
      if(stringParse.length > 1)
    	  params = HandleData.removeFirst(stringParse);

      // Default null cmd, unless proven otherwise
      Object obj = null;

      //Checks to see if an alias exists
      if(Alias.exists(cmd)){
    	  Alias curAlias = Alias.get(cmd);
    	  
    	  //Adds the parameters passed to the alias to its param list
    	  if(params.length > 0){
    		  curAlias.addParams(params);
    	  }
    	  
    	  //Reassign the parameter list and the command to be run
   	  params = curAlias.getParams();
    	  cmd = HandleData.upperFirst(curAlias.getCommand());
      }
      
      try {
    	  //Try to create a class object for the inputted command
    	  //TODO: dynamically create ReferenceType to be parameterized
    	  //Create a new instance of this class
    	  // Get the class object associated with the command name
        Class tClass = Class.forName("cmd."+cmd);
		  obj = tClass.newInstance();
		  Object parameters[] = {params};
		  //Grab the method construct from the class
		  Method con = tClass.getMethod("construct", String[].class);
		  //Run construct on the object and pass it the parameters
		  con.invoke(obj, parameters);
      } catch(java.lang.reflect.InvocationTargetException e){ //Catches an error within the construct
    	  Output.println("Invalid parameters for command. Type 'help "+cmd+"' for options.");
    	  //Set the object to null so the command won't try to run
    	  obj = null;
      } catch(Exception e){ //Catches an error when trying to create the class
    	  Output.println("Invalid command. Type 'help' for a list of commands.");
      }
      
      return obj;
   }
}
