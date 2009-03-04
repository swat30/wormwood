package obj;

public class Exit {
   private char dir;
   private Room room;
   private boolean passable;
   private boolean locked;
   private String name;

   public Exit (char direction, Room roomToExitTo, boolean passable, boolean locked, String name) {
      dir = direction;
      room = roomToExitTo;
      this.locked = locked;
      this.passable = passable;
      this.name = name;
   }

   public char getDir() {
      return dir;
   }
      
   public Room getRoom() {
      return room;
   }

   public String getName() {
      return name;
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
}
