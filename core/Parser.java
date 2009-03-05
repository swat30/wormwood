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
      cmd = handleData.upperFirst(stringParse[0]);
      if(stringParse.length > 1)
    	  params = handleData.removeFirst(stringParse);

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
    	  cmd = handleData.upperFirst(curAlias.getCommand());
      }
      
      try {
    	  //Try to create a class object for the inputted command
    	  //TODO: dynamically create ReferenceType to be parameterized
    	  Class tClass = Class.forName("cmd."+cmd); 
    	  //Create a new instance of this class
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
