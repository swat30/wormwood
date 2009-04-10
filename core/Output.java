package core;
import game.Config;

/*
 * Output
 * Adds a layer of abstraction to Wormwood by handling the Output instead
 * of having the programmer use System.out directly. Currently is just
 * a wrapper for System.out, but it may change in the future.
 */
public class Output {
   /** Clear the screen. */
   public static void clearScreen() {
      for (int i = 0; i < 100; i++) 
         System.out.println();
   }

   /** Print a string, with a newline at the end.*/
   public static void println(Object s) {
      System.out.println(s);
   }

   /** Print a string, without breaking the line at the end. */
   public static void print(Object s) {
      System.out.print(s);
   }
   
   /** Print a Wormwood error if debugging is turned on. */
   public static void error(Object s) {
	   if(Config.DEBUG)
		   Output.println("--ERROR-- : "+s);
   }
}
