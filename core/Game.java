package core;
import java.lang.reflect.Method;
import java.util.ArrayList;
import obj.*;
import iface.*;
import cmd.*;
import game.*;

public class Game {
   private Object cmd;
   private Parser gp;
   private Player p;
   private ArrayList<Grid> map;

   public static void clearScreen() {
      for (int i = 0; i < 100; i++)
         System.out.println();
   }

   // Initialize some junk
   public Game (String VERSION) {
      // If getInfo is passed to player, then the game will prompt
      // them to enter some info (name, age, etc)
      clearScreen();
      this.map = Create.init();
      Room startRoom = this.map.get(0).getStart();
      p = new Player(this.map.get(0), startRoom);
      System.out.println("--- Welcome to Wormwood Version " + VERSION + " ---"); 
      // Print initial room description
      System.out.println(p.getRoom());
   }

    /** The prompt gets user input from the keyboard. 
     * The input is then executed. */
   public void prompt () {
      System.out.print("> ");

      // Get user's input and parse it
      String rawCmd = Input.nextLine();
      this.cmd = Parser.parse(rawCmd);

      if (this.cmd != null)
         executeCommand();
   }

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
