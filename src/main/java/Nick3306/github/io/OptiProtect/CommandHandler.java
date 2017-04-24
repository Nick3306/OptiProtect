package Nick3306.github.io.OptiProtect;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor
{
	private Main plugin;
	private Utilities util;
	public CommandHandler(Main plugin)
	{
	   this.plugin = plugin;
	   this.util = this.plugin.util;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2lable, String[] args) 
	{
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("Protect") || cmd.getName().equalsIgnoreCase("P"))
		{
			if(args.length == 0)
			{
				player.sendMessage(ChatColor.RED + "Incorrect usage: /protect create or /protect info");
			}
			if(args[0].equalsIgnoreCase("Create"))
			{
				if(args.length != 1)
				{
					player.sendMessage(ChatColor.RED + "Incorrect usage: /protect create");
					return false;
				}
				else
				{
					ProtectionField newField = new ProtectionField(player.getWorld(),null, null, player.getUniqueId(), plugin.getConfig().getInt("FieldID"));
					plugin.newFields.add(newField);
					plugin.getConfig().set("FieldID", plugin.getConfig().getInt("FieldID")+ 1);
					player.sendMessage(ChatColor.GREEN + "Place the first block to define the field");
				}
			}
			if(args[0].equalsIgnoreCase("info"))
			{
				Location loc = player.getLocation();			
				ProtectionField field = util.getPField(loc);
				if(field != null)
				{
					player.sendMessage(ChatColor.GREEN + "ID: " + ChatColor.YELLOW + field.getId());
					player.sendMessage(ChatColor.GREEN + "Owner: " + ChatColor.YELLOW + Bukkit.getOfflinePlayer(field.getOwner()).getName());
					player.sendMessage(ChatColor.GREEN + "Area: " + ChatColor.YELLOW + field.getArea() + " blocks");
				}
				else
				{
					player.sendMessage(ChatColor.GREEN + "You are not in a field currently!");
					return false;
				}
				
			}
		}
		return false;
	}
	
}
