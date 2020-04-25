package us.github.thekiller65yt.HoloShop;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class HoloShop extends JavaPlugin {
	HashMap<Hologram, Location> activeHolo = new HashMap<Hologram, Location>();
	
	@Override
	  public void onEnable() {
	  }
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("holoshop")) { // If the player typed /basic then do the following, note: If you only registered this executor for one command, you don't need this
			//if (args[0] == "create") {
				Player p = (Player) sender;
				Hologram newHolo = new Hologram(p.getLocation(), "test");
				activeHolo.put(newHolo, newHolo.getLocation());
			//}
			return true;
		} //If this has happened the function will return true. 
	        // If this hasn't happened the value of false will be returned.
		return false; 
	}
	
}
 