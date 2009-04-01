/*
 * 
 */
package obj;
import core.Output;

public class Exit extends Entity {
   private boolean passable;
   private boolean locked;
   private Room[] rooms;

   public Exit (boolean passable, boolean locked, String name, String desc) {
      super(name, desc);
      setLocked(locked);
      setPassable(passable);
      this.rooms = new Room[2];
   }

   public boolean isPassable() {
      return passable;
   }

   public boolean isLocked() {
      return locked;
   }

   public void setPassable(boolean passable) {
      this.passable = passable;
   } 

   public void setLocked(boolean locked) {
      this.locked = locked;
   }
   
   public void link(Room r){
	   for(int i = 0; i < 2; i++){
		   if(this.rooms[i] == null){
			   this.rooms[i] = r;
			   return;
		   }
	   }
	   Output.error("Exit '"+getName()+"' already has two rooms linked.");
   }
   
   public Room[] getRooms(){
	   return this.rooms;
   }
   
   public Room getDestRoom(Room r){
	   if(rooms[0].equals(r))
		   return rooms[1];
	   else if(rooms[1].equals(r))
		   return rooms[0];
	   return null;
   }

   public String toString() {
      return getDesc();
   }
}
