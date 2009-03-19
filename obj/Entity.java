package obj;

public class Entity {
   private String name;
   private String desc;
   private String roomDesc;
   private boolean visible;

   /** Sets the object's name. */
   public void setName (String name) {
      this.name = name;
   }

   /** @return object's Name (in all lowercase). */
   public String getName () {
      // The Parser always makes the Strings entered lowercase
      // To ease matching the strings, all entities return their
      // names as lower case.
      return this.name.toLowerCase();
   }

   /** Sets object's description, which is printed when the object is examined. */
   public void setDesc (String description) {
      this.desc = description;
   }

   /** @return object's description. */
   public String getDesc () {
      return this.desc;
   }

   /** Sets the room description.
    * The room description is what is printed when the player uses the
    * Look command in the room. Instead of printing a list of items, or 
    * NPC'S (You see the following items: x, y, and z.) this will make things
    * read a little more like a story. The room description should be something
    * like "You see a sad man leaning against the wall in the corner of the room."
    * or "There's a matchbox on the table." */
   public void setRoomDesc (String roomDescription) {
      this.roomDesc = roomDescription;
   }

   /** @return object's room description. */
   public String getRoomDesc () {
      return this.roomDesc;
   }

   /** Makes the object visible to the player. 
    * If the object is already visible, nothing
    * changes. */
   public void makeVisible () {
      this.visible = true;
   }

  /** Makes the object invisible to the player. 
   * If the object is already invisible, nothing
   * changes. */
   public void makeInvisible () {
      this.visible = false;
   }

   /** @return object's description. */
   public String toString () {
      return this.desc;
   }
}
