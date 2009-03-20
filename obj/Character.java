package obj;

public class Character extends Entity {
   private String gender;
   private int age;

   /** Sets the character's gender. This can be a string
    * of any length (wormwood doesn't discriminate).*/
   public void setGender(String g) {
      this.gender = g;
   }

   /** @return the character's gender. */
   public String getGender() {
      return this.gender;
   }

   /** Sets the character's age. This can be any
    * integer. */
   public void setAge (int age) {
      this.age = age;
   }

   /** @return the character's age. */
   public int getAge () {
      return this.age;
   }
}
