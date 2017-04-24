package Nick3306.github.io.OptiProtect;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Utilities 
{
	private Main plugin;
	public Utilities(Main plugin)
	{
	   this.plugin = plugin;
	}
	public ProtectionField getPField(Location loc)
	{
		for(ProtectionField field : plugin.fields)
		{
			if(field.inPField(loc))
			{
				return field;
			}
		}

		return null;
	}
	public boolean definingField(Player player)
	{
		for(int i = 0; i < plugin.newFields.size(); i++)
		{
			if (plugin.newFields.get(i).getOwner().equals(player.getUniqueId()))
			{
				return true;
			}
		}
		return false;
	}
	public ProtectionField getNewField(Player player)
	{
		for(int i = 0; i < plugin.newFields.size(); i++)
		{
			if (plugin.newFields.get(i).getOwner().equals(player.getUniqueId()))
			{
				return plugin.newFields.get(i);
			}
		}
		return null;
	}
	public void removeNewField(ProtectionField field)
	{
		for (int i = 0; i < plugin.newFields.size(); i++)
		{
			if (field.getOwner().equals(plugin.newFields.get(i).getOwner()))
			{
				plugin.newFields.remove(i);
			}
		}
	}
	public void removeField(ProtectionField field)
	{
		for(int i = 0; i < plugin.fields.size(); i++)
		{
			if(field.getId() == plugin.fields.get(i).getId())
			{
				plugin.fields.remove(i);
			}
		}
	}
}
