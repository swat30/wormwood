/*
 * 
 */
package obj;

import java.util.ArrayList;
import core.Grid;

public class Player extends Character {
   private ArrayList<Item> inventory = new ArrayList<Item>();
   private Room curRoom;
   private Grid curGrid;

   /** Initializes basic player characteristics, such as name, gender, etc. 
    * Sets the starting grid and room. */
   public Player(String name, int age, String gender, Grid startingGrid, Room startingRoom) {
      setName(name);
      setAge(age);
      setGender(gender);
      setRoom(startingRoom);
      setGrid(startingGrid);
   }
   
   public Player (Grid startingGrid, Room startingRoom) {
      setName("Johnny Neutral");
      setAge(20);
      setGender("Neutral");
      setRoom(startingRoom);
      setGrid(startingGrid);
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
      this.inventory.add(i);
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
      this.curRoom = newRoom;
   }

   public Room getRoom() {
      return this.curRoom;
   }
   
   public void setGrid(Grid newGrid){
	   this.curGrid = newGrid;
   }
   
   public Grid getGrid(){
	   return this.curGrid;
   }
   public ArrayList<Item> getInventory(){
           return this.inventory;
   }
}
