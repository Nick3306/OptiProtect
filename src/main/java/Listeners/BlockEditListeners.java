package Listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import Nick3306.github.io.OptiProtect.Main;
import Nick3306.github.io.OptiProtect.ProtectionField;
import Nick3306.github.io.OptiProtect.Utilities;



public class BlockEditListeners implements Listener
{
	private Main plugin;
	private Utilities util;
	public BlockEditListeners(Main plugin)
	{
	   this.plugin = plugin;
	   this.util = this.plugin.util;
	}
	public void onPlayerInteract(PlayerInteractEvent event) 
	{
		Player player = event.getPlayer();
		Location loc = player.getLocation();
		Action action = event.getAction();
		String world = player.getWorld().getName();
		if (action == Action.LEFT_CLICK_BLOCK || action == Action.RIGHT_CLICK_BLOCK || action == Action.LEFT_CLICK_AIR || action == Action.RIGHT_CLICK_AIR)
		{
			if(util.getPField(loc) != null)
			{
				ProtectionField pField = util.getPField(loc);
				if(!pField.isMember(player) || player.getUniqueId() != pField.getOwner())
				{
					// Player is not allowed to build in field, check flags
					
					//Chest Access flag
					if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
					{
						if(event.getClickedBlock().getType().equals(Material.CHEST))
						{
							if(pField.getChestFlag() == true)
							{
								event.setCancelled(false);
							}
						}
					}
					else
					{
						player.sendMessage("You are not allowed to build here!");
						event.setCancelled(true);
					}
				}
				else
				{
					//Do nothing
				}
			}
		}
	}
}
