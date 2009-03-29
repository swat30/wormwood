package obj;
import java.util.ArrayList;

public class Room extends Entity {
   private ArrayList<Entity> entities = new ArrayList<Entity>();
   private ArrayList<Item> items = new ArrayList<Item>(); 
   private ArrayList<NPC> npcs = new ArrayList<NPC>();

   /** Full constructor. */
   public Room (String name, String desc, Item[] items, NPC[] npcs) {
      super(name, desc);
      setItems(items);
      setNPCs(npcs);
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

   public void setItems (Item[] items) {
      for (int i = 0; i < items.length; i++) 
         this.items.add(items[i]); 
   }

   public ArrayList<Item> getItems () {
      return items;
   }

   public void addItem (Item i) {
      items.add(i);
   }

   public void removeItem (Item i) {
      items.remove(i);
   }
   
   public Item getItem (String itemIdent) {
      Item item = null;

      for (int i = 0; i < items.size(); i++) 
         if (items.get(i).hasIdentifier(itemIdent))
            item = items.get(i);

      return item;
   }

   public void setNPCs (NPC[] npcs) {
      for (int i = 0; i < npcs.length; i++)
         this.npcs.add(npcs[i]);
   }

   public ArrayList<NPC> getNPCs () {
      return npcs;
   }

   public void addNPC (NPC npc) {
      npcs.add(npc);
   }

   public void removeNPC (NPC npc) {
      npcs.remove(npc);
   }
   
   public NPC getNPC (String NPCIdent) {
      NPC n = null;

      for (int i = 0; i < npcs.size(); i++) 
         if (npcs.get(i).hasIdentifier(NPCIdent))
            n = npcs.get(i);

      return n;
   }

   /** overrides the generic java toString, so that the Room's description
    * can be printed by a simple System.out.println(room); */
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
