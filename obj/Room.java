/*
 * 
 */
package obj;
import java.util.ArrayList;

public class Room extends Entity {
   private ArrayList<Item> items = new ArrayList<Item>(); 
   private ArrayList<NPC> npcs = new ArrayList<NPC>();

   /** Full constructor. */
   public Room (String name, String desc, Item[] items, NPC[] npcs) {
      super(name, desc);
      setItems(items);
      setNPCs(npcs);
   }

   /** Full constructor, but takes a single item instead of an array, and
    * a single NPC. */
   public Room (String name, String desc, Item item, NPC npc) {
      super(name, desc);
      addItem(item);
      addNPC(npc);
   }

   /** Constructor without items, and just one npc. */
   public Room (String name, String desc, NPC npc) {
      super(name, desc);
      addNPC(npc);
   }

   /** Constructor without NPC's, and just one item. */
   public Room (String name, String desc, Item item) {
      super(name, desc);
      addItem(item);
   }
   
   /** Constructor missing npcs. */
   public Room (String name, String desc, Item[] items)  {
      super(name, desc);
      setItems(items);
   }

   /** Constructor with just name and description. */
   public Room (String name, String desc) {
      super(name, desc);
   }
   
   /** Constructor with just a name. */
   public Room (String name) {
      super(name, "A Generic Room.");
   }

   /** Blank constructor. Defaults name to Room. */
   public Room () {
      super("Generic Room", "A Generic Room.");
   }

   /** Sets the items that can be found in the room. 
    * @param Array of items to set. */
   public void setItems (Item[] items) {
      for (int i = 0; i < items.length; i++) 
         this.items.add(items[i]); 
   }

   /** @return ArrayList of items that are in the room. */
   public ArrayList<Item> getItems () {
      return items;
   }

   /** Adds a single item to the room. 
    * @param item to be added. */
   public void addItem (Item i) {
      items.add(i);
   }

   /** Removes a single item from the room. */
   public void removeItem (Item i) {
      items.remove(i);
   }
   
   /** @return Item from the room, if it is contained in the room. 
    * Otherwise, returns null. */
   public Item getItem (String itemIdent) {
      Item item = null;

      for (int i = 0; i < items.size(); i++) 
         if (items.get(i).hasIdentifier(itemIdent))
            item = items.get(i);

      return item;
   }

   /** Sets the NPC's that can be found in the room. 
    * @param Array of NPC's to set. */
   public void setNPCs (NPC[] npcs) {
      for (int i = 0; i < npcs.length; i++)
         this.npcs.add(npcs[i]);
   }

   /** @return ArrayList of NPC's in the room. */
   public ArrayList<NPC> getNPCs () {
      return npcs;
   }

   /** Adds a single NPC to the room.
    * @param NPC to be added to room. */
   public void addNPC (NPC npc) {
      npcs.add(npc);
   }

   /** Removes a single NPC from the room. 
    * @param NPC to be removed. */
   public void removeNPC (NPC npc) {
      npcs.remove(npc);
   }
   
   /** 
    * @param Identifier for the NPC.
    * @return An NPC that exists in the room, based on the identifier given.
    * If the NPC can't be found, returns null. */
   public NPC getNPC (String NPCIdentifer) {
      NPC n = null;

      for (int i = 0; i < npcs.size(); i++) 
         if (npcs.get(i).hasIdentifier(NPCIdentifer))
            n = npcs.get(i);

      return n;
   }

   /** Overrides the generic java toString, so that the Room's description
    * can be printed by a simple Output.println(room); */
   public String toString() {
      String itemString = "";
      String npcString = "";

      // If there are items in the room
      if (items.size() > 0) 
         for (int i = 0; i < items.size(); i++) 
            itemString = itemString + " " + items.get(i).getRoomDesc(); 

      // If there are npc's in the room
      if (npcs.size() > 0) 
         for (int i = 0; i < npcs.size(); i++) 
            npcString = npcString + " " + npcs.get(i).getRoomDesc();

      return getDesc() + npcString + itemString;
   }
}	
