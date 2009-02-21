package core;
import java.lang.reflect.Method;
import obj.*;
import iface.*;
import cmd.*;

public class Game {
   private Command cmd;
   private Parser gp;
   private Player p;

   public static void clearScreen() {
      for (int i = 0; i < 100; i++)
         System.out.println();
   }

   // Initialize some junk
   public Game (String VERSION) {
      // If getInfo is passed to player, then the game will prompt
      // them to enter some info (name, age, etc)
      boolean getInfo = true;
      clearScreen();
      Room startRoom = createRooms(); 
      p = new Player(startRoom); 
      System.out.println("--- Welcome to Wormwood Version " + VERSION + " ---"); 
      // Print initial room description
      System.out.println(p.getRoom());
   }

   /** The main user-game interaction is getting input
    * from the keyboard at the prompt - the prompt then
    * executes this input. */
   public void prompt () {
      System.out.print("> ");

      // Get user's input and parse it
      String rawCmd = Input.nextLine();
      Object cmd = Parser.parse(rawCmd);

      if (cmd != null)
         executeCommand(cmd);
   }

   /** Creates all the rooms, returns starting room */
   private Room createRooms () {
      Command kate = new Kate();
      Item gun = new Item("gun", "a frikkin gun", 3, kate);
      Item[] items = {gun};
      Room nRoom = new Room("North Forrest", "Northerly!");
      Room eRoom = new Room("East Forrest", "Easterly!");
      Room wRoom = new Room("West Forrest", "Westerly!");
      Room sRoom = new Room("South Forrest", "Southerly!");
      Room startRoom = new Room("Forrest Entrance", "A dark forrest.", items);
      Exit sen = new Exit('s', startRoom, true, false, "empty");
      Exit nes = new Exit('n', startRoom, false, false, "door");
      Exit nExit = new Exit('n', nRoom, true, false, "empty");
      Exit sExit = new Exit('s', sRoom, false, false, "empty");
      startRoom.setExit(nExit);
      startRoom.setExit(sExit);
      nRoom.setExit(sen);
      sRoom.setExit(nes);

      return startRoom;
   }

   private void executeCommand (Object cmd) {
      //cmd.exec(p);
	  try{
		  Class tClass = cmd.getClass();
		  Method exec = tClass.getMethod("exec", Player.class);
		  exec.invoke(cmd, p);
	  } catch(Exception e){
		  Output.println(e);
	  }
   }
}
