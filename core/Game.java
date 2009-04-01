/*
 * 
 */
package core;
import java.lang.reflect.Method;
import java.util.ArrayList;
import obj.*;
import iface.*;
import cmd.*;
import game.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Game.
 */
public class Game {
   
   /** The cmd. */
   private Object cmd;
   
   /** The gp. */
   private Parser gp;
   
   /** The p. */
   private Player p;
   
   /** The map. */
   private ArrayList<Grid> map;
   
   /** Keeps the game alive. */
   private static boolean alive;

   /**
    * Clear screen.
    */
   public static void clearScreen() {
      for (int i = 0; i < 100; i++)
         System.out.println();
   }

   // Initialize some junk
   /**
    * Instantiates a new game.
    * 
    * @param VERSION the version
    */
   public Game (String VERSION) {
      // If getInfo is passed to player, then the game will prompt
      // them to enter some info (name, age, etc)
      clearScreen();
      Look l = new Look();
      this.map = Create.init();
      Create.aliases();
      Room startRoom = this.map.get(0).getStart();
      p = new Player(this.map.get(0), startRoom);
      System.out.println("--- Welcome to Wormwood Version " + VERSION + " ---"); 
      // Print initial room description
      l.exec(p);
      alive = true;
   }
   
   /**
    * 
    */
   public static boolean isAlive(){
	   return alive;
   }
   
   /**
    * 
    */
   public static void kill(){
	   alive = false;
   }
    /**
     * The prompt gets user input from the keyboard.
     * The input is then executed.
     */
   public void prompt () {
      System.out.print("> ");

      // Get user's input and parse it
      String rawCmd = Input.nextLine();
      this.cmd = Parser.parse(rawCmd);

      if (this.cmd != null)
         executeCommand();
   }

   /**
    * Execute command.
    */
   private void executeCommand () {
	  try {
		  Class tClass = cmd.getClass();
		  Method exec = tClass.getMethod("exec", Player.class);
		  exec.invoke(cmd, p);
	  } catch(Exception e){
		  Output.println("Problem executing command.");
	  }
   }
}
