package obj;

public class Entity {
   private String name;
   private String desc;

   /** Sets the object's name. */
   public void setName (String name) {
      this.name = name;
   }

   /** @return object's Name. */
   public String getName () {
      return this.name;
   }

   /** Sets object's description, which is printed when the object is examined. */
   public void setDesc (String description) {
      this.desc = description;
   }

   /** @return object's description. */
   public String getDesc () {
      return this.desc;
   }
   
   /** @return object's description. */
   public String toString () {
      return this.desc;
   }
}
