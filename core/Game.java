package core;
import java.lang.reflect.Method;
import java.util.ArrayList;
import obj.*;
import iface.*;
import cmd.*;
import game.*;

/**
 * Game
 * Contains basic methods for running a game in wormwood. Most notably,
 * includes the essential prompt() and executeCommand() methods. */
public class Game {
   private Object cmd;
   private Parser gp;
   private Player p;
   private ArrayList<Grid> map;
   private static boolean alive;

   /**
    * Instantiates a new game.
    * 
    * @param VERSION the version
    */
   public Game (String VERSION) {
      // If getInfo is passed to player, then the game will prompt
      // them to enter some info (name, age, etc)
      Output.clearScreen();
      Look l = new Look();
      this.map = Create.init();
      Create.aliases();
      Room startRoom = this.map.get(0).getStart();
      p = new Player(this.map.get(0), startRoom);
      Output.println("--- Welcome to Wormwood Version " + VERSION + " ---"); 
      // Print initial room description
      l.exec(p);
      alive = true;
   }
   
   /**
    * @return Whether or not the game has been shut down. 
    */
   public static boolean isAlive(){
	   return alive;
   }
   
   /**
    * Shuts down the game. 
    */
   public static void kill(){
	   alive = false;
   }
    /**
     * The prompt gets user input from the keyboard.
     * The input is then executed.
     */
   public void prompt () {
      Output.print("> ");

      // Get user's input and parse it
      String rawCmd = Input.nextLine();
      this.cmd = Parser.parse(rawCmd);

      if (this.cmd != null)
         executeCommand();
   }

   /**
    * Execute command.
    * Attempts to execute the command
    * @see core.Parser
    */
   private void executeCommand () {
	  try {
		  //Gets the class of the cmd object passed
		  Class tClass = cmd.getClass();
		  //Creates the method 'exec' belonging to this instance and executes it
		  Method exec = tClass.getMethod("exec", Player.class);
		  exec.invoke(cmd, p);
	  //Catches any errors
	  } catch(Exception e){
		  Output.println("Problem executing command.");
	  }
   }
}
