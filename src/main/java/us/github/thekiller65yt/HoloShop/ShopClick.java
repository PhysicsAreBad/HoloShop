package us.github.thekiller65yt.HoloShop;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class ShopClick implements Listener {

	public HashMap<Location, Hologram> activeHolo = new HashMap<Location, Hologram>();
	static HoloShop plugin;
	public ShopClick(HoloShop holoShop) {
		plugin = holoShop;
	}
	
	
	@EventHandler
	public void clickHologram (PlayerInteractEvent e) {
		if(activeHolo.containsKey(e.getPlayer().getEyeLocation())) {
			Hologram holo = activeHolo.get(e.getPlayer().getEyeLocation());
			holo.sellItem(e.getPlayer());
		}
	}
	
}
