package obj;
import java.util.ArrayList;

public class Room extends Entity {
   private ArrayList<Entity> entities = new ArrayList<Entity>();
   private ArrayList<Item> items = new ArrayList<Item>(); 
   private ArrayList<NPC> npcs = new ArrayList<NPC>();

   public Room (String name, String desc, Item[] items, NPC[] npcs) {
      setName(name);
      setDesc(desc);
      setItems(items);
      setNPCs(npcs);
   }
   
   public Room (String name, String desc, Item[] items)  {
      setName(name);
      setDesc(desc);
      setItems(items);
   }

   public Room (String name, String desc) {
      setName(name);
      setDesc(desc);
   }
   
   public Room (String name) {
      setName(name);
      setDesc("Generic Room.");
   }

   public Room () {
      setDesc("Generic Room.");
      setName("Room");
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
   
   public Item getItem (String itemName) {
      Item item = null;

      for (int i = 0; i < items.size(); i++) 
         if (itemName.equals(items.get(i).getName()))
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
   
   public NPC getNPC (String NPCName) {
      NPC n = null;

      for (int i = 0; i < npcs.size(); i++) 
         if (NPCName.equals(npcs.get(i).getName()))
            n = npcs.get(i);

      return n;
   }

   /** overrides the generic java toString, so that the Room's description
    * can be printed by a simple System.out.println(room); */
   public String toString() {
      String s = "";
      String npc = "";

      // If there are items in the room
      if (items.size() > 0) {
         s = " You see these items: "; 

         for (int i = 0; i < items.size(); i++) {
            // If it's the last time
            if (i == (items.size() - 1) )
               s = s + items.get(i).getName() + ".";
            else 
               s = s + items.get(i).getName() + ",";
         }
      }

      if (npcs.size() > 0) {
         npc = " The following people are in the room: ";

         for (int i = 0; i < npcs.size(); i++) {
            // If it's the last time
            if (i == (npcs.size() - 1) )
               npc = npc + npcs.get(i).getName() + ".";
            else 
               npc = npc + npcs.get(i).getName() + ",";
         }

      }
      return getDesc() + s + npc;
   }
}	
