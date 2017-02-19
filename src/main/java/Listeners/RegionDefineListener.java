package Listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import Nick3306.github.io.OptiProtect.Main;
import Nick3306.github.io.OptiProtect.ProtectionField;
import Nick3306.github.io.OptiProtect.Utilities;

public class RegionDefineListener implements Listener
{
	private Main plugin;
	private Utilities util;
	public RegionDefineListener(Main plugin)
	{
	   this.plugin = plugin;
	   this.util = this.plugin.util;
	}
	public void onBlockPlaced(BlockPlaceEvent event)
	{
		Player player = event.getPlayer();
		if(util.definingField(player))
		{
			Location block = event.getBlockPlaced().getLocation();		
			ProtectionField field = util.getNewField(player);
			if (field.getBlock1() == null)
			{
				field.setBlock1(block);
				event.setCancelled(true);
			}
			else if (field.getBlock2() == null)
			{
				field.setBlock2(block);
				double area = field.getArea();
				// Check if they have enough to buy the protection or if its free
				//if it's free
				if(plugin.getConfig().getInt("PricePerBlock") == 0)
				{
					plugin.fields.add(field);
					util.removeNewField(field);
				}
				else
				{
					
				}
			}

		}
	}
}
