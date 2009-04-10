package cmd;
import core.Output;
import obj.Player;
import obj.Room;
import obj.NPC;
import iface.Command;

/**
 * Talk - 
 * Allows the player to talk to an NPC in the current room.
 */
public class Talk implements Command {
   private String npcName;

   public void exec(Player p) {
      Room r = p.getRoom();
      NPC npc = r.getNPC(npcName);

      if (npc != null) {
         Output.println(npc.talk());
      }
      else {
         Output.println("The person you asked for does not appear to be in this room.");
      }
   }

   public void construct(String[] params) {
      if (params.length > 0)
         if (params.length == 1)
            setName(params[0]);
         // Omits the "to" in something like "talk to man"
         if (params.length == 2)
            setName(params[1]);
   }

   public void setName(String n) {
      npcName = n;
   }

   public String toString() {
      return "Usage: Talk (to) <npc_name>\nTalks to an NPC in the current room.";
   }
}

