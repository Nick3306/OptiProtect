package Nick3306.github.io.OptiProtect;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2lable, String[] args) 
	{
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("Protect") || cmd.getName().equalsIgnoreCase("P"))
		{
			if(args[0].equalsIgnoreCase("Create"))
			{
				if(args.length != 1)
				{
					player.sendMessage(ChatColor.RED + "Incorrect usage: /protect create");
					return false;
				}
				else
				{
					
				}
			}
		}
		return false;
	}
	
}
