package us.github.thekiller65yt.HoloShop;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShopClick implements Listener {

	public HashMap<Location, Hologram> activeHolo = new HashMap<Location, Hologram>();
	static HoloShop plugin;
	public ShopClick(HoloShop holoShop) {
		plugin = holoShop;
	}
	
	
	@EventHandler
	public void clickHologram (PlayerInteractEvent e) {
		if(activeHolo.containsKey(e.getPlayer().getEyeLocation())) {

			if(e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR) {
				Hologram holo = activeHolo.get(e.getPlayer().getEyeLocation());
				openBuyGUI(e.getPlayer(), holo);
			} else if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				Hologram holo = activeHolo.get(e.getPlayer().getEyeLocation());
				holo.openSellGUI(e.getPlayer());
			}

		}
	
	}
	
	public void openBuyGUI (Player p, Hologram holo) {
		
		Inventory BuyGUI = Bukkit.createInventory(null, 27);
		ItemStack buyone = holo.getHeldItem();
		ItemStack buystack = new ItemStack(buyone.getType(), 64);
		ItemStack buyinv = new ItemStack(buyone.getType(), 64);
		ItemStack itemtype = holo.getHeldItem();
		ItemMeta buyonemeta = buyone.getItemMeta();
		ItemMeta buystackmeta = buystack.getItemMeta();
		ItemMeta buyinvmeta = buyinv.getItemMeta();
		ItemMeta itemtypemeta = itemtype.getItemMeta();
		String item = buyone.toString();
		
		buyonemeta.setDisplayName(ChatColor.GREEN + "Buy one");
		buystackmeta.setDisplayName(ChatColor.GREEN + "Buy one stack " + "(" + buyone.getMaxStackSize() +")");
		buyinvmeta.setDisplayName(ChatColor.GREEN + "Fill up the rest of your inventory!");
		itemtypemeta.setDisplayName(ChatColor.GREEN + item);
		
		buyone.setItemMeta(buyonemeta);
		buystack.setItemMeta(buystackmeta);
		buyinv.setItemMeta(buyinvmeta);
		itemtype.setItemMeta(itemtypemeta);
		
		BuyGUI.setItem(19, buyinv);
		BuyGUI.setItem(14, buystack);
		BuyGUI.setItem(11, buyone);
		BuyGUI.setItem(5, itemtype);
		
		p.openInventory(BuyGUI);
	}
	
	@EventHandler
	public void clickBuyGUI (InventoryClickEvent e) {
		e.setCancelled(true);
		if (e.getClickedInventory() == BuyGUI) {
			
		}
	}
	
}
