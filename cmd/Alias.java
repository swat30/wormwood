package cmd;
import obj.Player;
import core.Output;
import java.util.ArrayList;
import iface.Command;

/**
 * Alias
 * Creates a new alias. An alias is just another for the user to type 
 * a command. For example, "e" instead of "move e".
 */
public class Alias implements Command {
	private String name, command;
	private ArrayList<String> params;
	private static ArrayList<Alias> aliases = new ArrayList<Alias>();
	
	public void exec (Player p){}
	
	public void construct(String params[]){
		boolean silent = false;
		//Remove an alias of the same name if it already exists
		if(exists(params[0])){
			Alias temp = get(params[0]);
			temp.remove();
		}
		//Initialize params list
		this.params = new ArrayList<String>();
		
		//Set the name of the alias and the command to be aliased
		if(params[0].charAt(0) == '@'){
			params[0] = params[0].substring(1);
			silent = true;
		}
		this.name = params[0];
		this.command = params[1];
		
		//Grab the rest of the params array and set the params to be passed, if any, to the aliased command
		for(int i = 2; i < params.length; i++)
			this.params.add(params[i]);
		aliases.add(this);
		if(!silent)
			Output.println("Alias added.");
	}
	
	/**
	 *  Get specified alias
	 * 
	 * @param name
	 * @return alias with name, if found. Null otherwise.
	 */
	public static Alias get(String name){
		if(exists(name)){
			for(int i = 0; i < aliases.size(); i++){
				if(aliases.get(i).name.equalsIgnoreCase(name))
					return aliases.get(i);
			}
		}
		//Return a null alias if it doesn't exist
		return null;			
	}
	
	/**
	 * Casts the list of params into an array
	 * 
	 * @return parameter array
	 */
	public String[] getParams(){
		String[] params = new String[this.params.size()];
		for(int i = 0; i < this.params.size(); i++)
			params[i] = this.params.get(i);
		return  params;
	}
	
	/**
	 * Get the command that is tied to this alias
	 * 
	 * @return the command associated with current alias
	 */
	public String getCommand(){
		return this.command;
	}
	
	/** 
	 * Removes current alias
	 */
	public void remove(){
		for(int i = 0; i < aliases.size(); i++){
			if(aliases.get(i).name.equalsIgnoreCase(this.name)){
				aliases.remove(i);
			}
		}
	}
	
	/** Add an array of parameters to the current parameter list
	 * 
	 * @param newParams New array of parameters to add to the alias
	 */
	public void addParams(String[] newParams){
		for(int i = 0; i < newParams.length; i++)
			this.params.add(newParams[i]);
	}
	
	/** Checks to see if an alias exists with selected name
	 * 
	 * @param name alias name to check for
	 * @return true if it exists, false if not
	 */
	public static boolean exists(String name){
		for(int i = 0; i < aliases.size(); i++){
			if(aliases.get(i).name.equalsIgnoreCase(name))
				return true;
		}
		return false;
	}

   public String toString () {
      return "Usage: Alias <alias_name> <command_name> <command_paramater(s)>\nCreates an alias for a game command. For example, if you would rather type 'n' instead of 'move n', you could use the alias command as follows: alias n move n.";
   }
}
