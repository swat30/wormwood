public class Parser {
   /** Takes a raw command and turns it into something the game can understand*/
   public static Command parse (String rawCmd) { 
      String firstWord;
      String secondWord;
      String thirdWord;

      // Remove leading/trailing whitespace
      rawCmd = rawCmd.trim();         
      rawCmd = rawCmd.toLowerCase();

      int spaceIndex = rawCmd.indexOf(" ");

      // If there are multiple words entered 
      if (spaceIndex != -1) {
         firstWord = rawCmd.substring(0, spaceIndex);
         secondWord = rawCmd.substring(spaceIndex, rawCmd.length());
         secondWord = secondWord.trim();
      }
      else {
         firstWord = rawCmd;
         secondWord = "null";
      }

      // Default null cmd, unless proven otherwise
      Command c = null;

      if (rawCmd.matches("look")) 
         c = new Look();
      else if (rawCmd.matches("quit") || rawCmd.matches("exit")) 
         c = new Quit();
      else if (rawCmd.matches("kate"))
         c = new Kate();
      else if (rawCmd.matches("n") || rawCmd.matches("north")) {
         c = new Move();
         c.setDir('n');
      }
      else if (rawCmd.matches("e") || rawCmd.matches("east")) {
         c = new Move();
         c.setDir('e');
      }
      else if (rawCmd.matches("w") || rawCmd.matches("west")) {
         c = new Move();
         c.setDir('w');
      }
      else if (rawCmd.matches("s") || rawCmd.matches("south")) {
         c = new Move();
         c.setDir('s');
      }
      else if (firstWord.matches("drop")) {
         c = new Drop();
         c.setName(secondWord);
      }
      else if (firstWord.matches("examine")) {
         c = new Examine();
         c.setName(secondWord);
      }
      else if (firstWord.matches("use")) {
         c = new Use();
         c.setName(secondWord);
      }
      else if (firstWord.matches("take")) {
         c = new Take();
         c.setName(secondWord);
      }

      return c;
   }
}
