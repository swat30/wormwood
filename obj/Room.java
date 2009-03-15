package obj;
import java.util.Hashtable;
import java.util.Vector;

public class Room {
	private String desc;
	private String name;	  
   private Hashtable<String, Exit> exits = new Hashtable<String, Exit>();
   private Vector<Item> items = new Vector<Item>(); 

   public Room (String name, String desc, Exit n, Exit e, Exit w, Exit s, Item[] items) {
      setDesc(desc);
      setName(name);
      setExits(n, e, w, s); 
      setItems(items);
   }

   public Room (String name, String desc, Item[] items) {
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

   public void setName (String n) {
      name = n;
   }

   public void setDesc (String d) {
      desc = d;
   }

   public String getName () {
      return name;
   }

   public String getDesc () {
      return desc;
   }

   public void setExits (Exit n, Exit e, Exit w, Exit s) {
      setExit(n);
      setExit(e);
      setExit(w);
      setExit(s);
   }

   /** Accepts a single direction and room for an exit */
   public void setExit (Exit r) {
      exits.put(r.getDir(), r);
   }

   public void setItems (Item[] items) {
      for (int i = 0; i < items.length; i++) 
         this.items.add(items[i]); 
   }

   public void addItem (Item i) {
      items.add(i);
   }

   public void removeItem (Item i) {
      items.remove(i);
   }

   public Vector<Item> getItems () {
      return items;
   }

   public Item getItem (String itemName) {
      Item item = null;

      for (int i = 0; i < items.size(); i++) 
         if (itemName.equals(items.get(i).getName()))
            item = items.get(i);

      return item;
   }

   public Exit getExit (String exitDir) {
      // If the direction desired is found in exits
      if (exits.containsKey(exitDir)) 
         return (Exit) exits.get(exitDir);

      // exit doesn't exist, must return dummy value
      else  
         return null;
   }

   /** overrides the generic java toString, so that the Room's description
    * can be printed by a simple System.out.println(room); */
   public String toString() {
      String s = "";

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

      return desc + s;
   }
}	
