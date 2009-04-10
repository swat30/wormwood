package obj;
 
import java.util.ArrayList;
 
/*
 * Entity 
 * Base class for most objects in Wormwood. 
 * Instance vars:
 *  - name: name of the entity
 *  - desc: a description of the entity, usually printed using "examine" command
 *  - roomDesc: a description of the entity that gets printed along with the description of the room
 *  - visible: if the entity is not visible, its description will not be printed to the player
 *  - identifiers: are used by commands to identify an object. For example, 
 *  examine man will examine an Entity with the identifier man.
 */
public class Entity {
   private String name;
   private String desc;
   private String roomDesc;
   private boolean visible;
   private ArrayList<String> identifiers = new ArrayList<String>();
 
   /** Default blank constructor. */
   public Entity () {}

   /** Full constructor. */
   public Entity(String name, String[] identifiers, String description, String roomDescription){
      setName(name);
      setDesc(description);
      setRoomDesc(roomDescription);
      addIdentifiers(identifiers);
   }

   /** Alternative full constructor, but instead of taking an array
    * of identifiers, takes a single identifier. */
   public Entity(String name, String identifier, String description, String roomDescription) {
      setName(name);
      setDesc(description);
      setRoomDesc(roomDescription);
      addIdentifier(identifier);
   }

   /** Constructor, missing identifiers. */
   public Entity(String name, String description, String roomDescription) {
      setName(name);
      setDesc(description);
      setRoomDesc(roomDescription);
   }

   /** Constructor, missing identifiers and roomDesc.*/
   public Entity(String name, String description) {
      setName(name);
      setDesc(description);
   }
   
   /** Sets the object's name. */
   public void setName(String name) {
      this.name = name;
      addIdentifier(name);
   }
 
   /** @return object's Name (in all lowercase). */
   public String getName() {
      return this.name;
   }
 
   /** Sets object's description, which is printed when the object is examined. */
   public void setDesc(String description) {
      this.desc = description;
   }
 
   /** @return object's description. */
   public String getDesc() {
      return this.desc;
   }
 
   /** Sets the room description.
* The room description is what is printed when the player uses the
* Look command in the room. Instead of printing a list of items, or
* NPC'S (You see the following items: x, y, and z.) this will make things
* read a little more like a story. The room description should be something
* like "You see a sad man leaning against the wall in the corner of the room."
* or "There's a matchbox on the table." */
   public void setRoomDesc(String roomDescription) {
      this.roomDesc = roomDescription;
   }
 
   /** @return object's room description. */
   public String getRoomDesc() {
      return this.roomDesc;
   }
 
   /** Makes the object visible to the player.
* If the object is already visible, nothing
* changes. */
   public void makeVisible() {
      this.visible = true;
   }
 
  /** Makes the object invisible to the player.
* If the object is already invisible, nothing
* changes. */
   public void makeInvisible() {
      this.visible = false;
   }
 
   /** Sets the identifiers for the entity.
* Identifiers are another way of getting access to an entity.
* For example, you might have an NPC with the identifiers
* John, and man. They both will give you access to the same
* object. If the game first introduces the player to the NPC
* only as man, they obviously won't know that the man's name is
* John. Therefore, they need a way to interact with the character
* without knowing the character's name. For example, examine man.
* Identifiers to the rescue! */
   public void setIdentifiers(String[] ident) {
      for (int i = 0; i < ident.length; i++)
         this.identifiers.set(i, ident[i]);
   }
 
   /** Adds an identifier to the entity. */
   public void addIdentifier(String ident) {
      this.identifiers.add(ident);
   }
 
   /** Adds a list of identifiers to the entity. */
   public void addIdentifiers(String[] ident) {
      for (int i = 0; i < ident.length; i++)
         this.identifiers.add(ident[i]);
   }
 
   /** @return Returns true if the Entity has the identifier specified,
* false if it doesn't. */
   public boolean hasIdentifier(String name) {
      // Look for the identifier desired in the list
      for (int i = 0; i < this.identifiers.size(); i++)
         if (name.equalsIgnoreCase(identifiers.get(i)))
               return true;
 
      // The search was not successful
      return false;
   }
 
   /** @return object's description. */
   public String toString() {
      return this.desc;
   }
}
