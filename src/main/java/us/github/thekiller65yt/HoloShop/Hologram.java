package us.github.thekiller65yt.HoloShop;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

public class Hologram {
	private String text;
	private Location loc;
	private ArmorStand stand;
	private ItemStack heldItem = null;
	private Economy econ = null;

	public Hologram (Location loc, String text, Economy eco) {
		this.loc = loc;
		this.text = text;
		stand = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
		econ = eco;
		stand.setVisible(false);
		stand.setCustomName(text);
		stand.setCustomNameVisible(true);
	}
	
	public Hologram (Location loc, String text, ItemStack item, Economy eco) {
		this.loc = loc;
		this.text = text;
		heldItem = item;
		econ = eco;
		stand = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
		stand.setVisible(false);
		stand.setCustomName(text);
		stand.setCustomNameVisible(true);
		stand.getEquipment().setChestplate(item);
	}
	
	public void updateName (String text) {
		stand.setCustomName(text);
		stand.setCustomNameVisible(true);
		this.text = text;
	}
	
	public Location getLocation () {
		return loc;
	}
	
	public String getText() {
		return text;
	}
	
	public ItemStack getHeldItem () {
		return heldItem;
	}
	
	public boolean sellItem (Player p) {
		PlayerInventory inv = p.getInventory();
		int amount = 0;
		for (ItemStack is : inv.getContents()) {
			if (is.getType() == heldItem.getType()) {
				amount = amount + is.getAmount();
			}
		}
		inv.remove(heldItem.getType());
		return depositMoney(p , amount);
	}
	
	public boolean destroy () {
		stand.setHealth(0);
		return stand.isDead();
	}
	
	public boolean depositMoney (Player p, double amount) {
		OfflinePlayer op = p;
		EconomyResponse r = econ.depositPlayer(op, amount);
        if(r.transactionSuccess()) {
            return true;
        }
        return false;
	}
}