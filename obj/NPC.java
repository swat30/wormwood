package obj;

public class NPC extends Entity {
   /** Create an NPC with a specified name and description. */
   public NPC (String name, String[] identifiers, String description, String roomDescription) {
      setName(name);
      setDesc(description);
      setRoomDesc(roomDescription);
      addIdentifiers(identifiers);
   }
}

