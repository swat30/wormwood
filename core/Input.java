package core;
import java.util.Scanner;

/**
 * Input
 * Encapsulates Wormwood's input of raw data, such as strings.
 * Programmers should use Input.nextLine() instead of the 
 * Scanner class directly. */
public class Input {
   /** Gets the next line of input from the keyboard. */
   public static String nextLine() {
      Scanner k = new Scanner(System.in);
      return k.nextLine();
   }

   /** Gets the next integer from the keyboard. */
   public static int nextInt() {
      Scanner k = new Scanner(System.in);
      return k.nextInt();
   }
}
      
