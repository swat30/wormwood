package obj;

import java.util.Vector;
import core.Grid;
import core.Input;

public class Player {
   private String name;
   private int age;
   private String gender;
   private Vector<Item> inventory = new Vector();
   private Item curItem = null;
   private Room curRoom;
   private Grid curGrid;

   /** Initializes basic player characteristics, such as name, etc. */
   public Player(boolean getInfo, Grid startingGrid, Room startingRoom) {
      System.out.print("Enter a character name: ");
      name = Input.nextLine();
      System.out.println("Okay... you are " + name + ".");
       
      System.out.print("Enter an age: ");
      age = Input.nextInt();
      if (age < 0)  
         System.out.println("You're *too* young!");
      else if (age < 5)
         System.out.println("Baaaaby!");
      else if (age <= 80)
         System.out.println("Alright... I guess you're " + age + ".");
      else
         System.out.println("Are you really THAT old?!");

      System.out.print("Enter a gender: ");
      gender = Input.nextLine();
      
      curRoom = startingRoom;
      this.curGrid = startingGrid;
   }
   
   public Player (Grid startingGrid, Room startingRoom) {
      name = "buttface";
      age = 56;
      gender = "Neutral";

      curRoom = startingRoom;
      this.curGrid = startingGrid;
   }
      
   public void setCurItem (Item i) {
      // Ultimately should check if item is in player's inventory
      curItem = i;
   }

   /**@Return A specific item from the player's inventory
    * If the item is not found, null is returned instead.*/
   public Item getItem (String itemName) {
      Item item = null;

      for (int i = 0; i < inventory.size(); i++) 
         if (itemName.equals(inventory.get(i).getName()))
            item = inventory.get(i);

      return item;
   }

   public void addToInventory (Item i) {
      inventory.add(i);
   }

   // Returns true if item was removed, false if not
   public boolean removeItem (String itemName) {
      for (int i = 0; i < inventory.size(); i++)
         if (itemName.equals(inventory.get(i).getName())) {
            inventory.remove(i);
            return true;
         }

      return false;
   }

   public void setRoom (Room newRoom) {
      curRoom = newRoom;
   }

   public Room getRoom() {
      return curRoom;
   }
   
   public void setGrid(Grid newGrid){
	   this.curGrid = newGrid;
   }
   
   public Grid getGrid(){
	   return this.curGrid;
   }

   public void setGender(String g) {
      gender = g;
   }

   public String getGender() {
      return gender;
   }
}
