package us.github.thekiller65yt.HoloShop;

import java.util.HashMap;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class ShopClick implements Listener {

	static HoloShop plugin;
	public ShopClick(HoloShop holoShop) {
		plugin = holoShop;
	}
	
	
	
	public void clickHologram (PlayerInteractEvent e) {
		
		HashMap<Location, Hologram> holo = HoloShop.this.activeHolo;
		
		if ( == null) {
			
		}
	}
	
}
