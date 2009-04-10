/*
 * 
 */
package core;
import game.Config;

public class Output {
   public static void clearScreen() {
      for (int i = 0; i < 100; i++) 
         System.out.println();
   }

   public static void println(Object s) {
      System.out.println(s);
   }

   public static void print(Object s) {
      System.out.print(s);
   }
   
   public static void error(Object s) {
	   if(Config.DEBUG)
		   System.out.println("--ERROR-- : "+s);
   }
}
