package us.github.thekiller65yt.HoloShop;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

public class Hologram {
	private String text;
	private Location loc;
	private ArmorStand stand;
	private ItemStack heldItem = null;

	public Hologram (Location loc, String text) {
		this.loc = loc;
		this.text = text;
		stand = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
		stand.setVisible(false);
		stand.setCustomName(text);
		stand.setCustomNameVisible(true);
	}
	
	public Hologram (Location loc, String text, ItemStack item) {
		this.loc = loc;
		this.text = text;
		heldItem = item;
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
	
	public boolean destroy () {
		stand.setHealth(0);
		return stand.isDead();
	}
}