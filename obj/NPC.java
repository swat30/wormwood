package obj;

public class NPC extends Entity {
   /** Create an NPC using the full Entity constructor. */
   public NPC(String name, String[] identifiers, String description, String roomDescription) {
      super(name, identifiers, description, roomDescription);
   }

   /** Alternative full constructor with single identifier. */
   public NPC(String name, String identifier, String description, String roomDescription) {
      super(name, identifier, description, roomDescription);
   }

   /** Constructor, missing identifiers. */
   public NPC(String name, String description, String roomDescription) {
      super(name, description, roomDescription);
   }

   /** Constructor, missing identifiers and roomDesc. */
   public NPC(String name, String description) {
      super(name, description);
   }
}

