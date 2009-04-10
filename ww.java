/*
 * 
 */
import core.Game;
 
public class ww {
  public static void main(String[] args) {
      final String VERSION = "0.4";
 
      Game g = new Game(VERSION);
 
      // Main game loop
      while (Game.isAlive()) {
         g.prompt();
      }
  }
}
 
