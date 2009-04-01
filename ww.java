import core.Game;
 
public class ww {
  public static void main(String[] args) {
      final String VERSION = "0.3";
 
      Game g = new Game(VERSION);
 
      boolean gameOn = true;
      // Main game loop
      while (gameOn == true) {
         g.prompt();
      }
  }
}
 
