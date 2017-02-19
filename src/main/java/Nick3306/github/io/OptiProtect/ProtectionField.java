package Nick3306.github.io.OptiProtect;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class ProtectionField
{
	int id;
	UUID owner;
	ArrayList<UUID> members = new ArrayList<UUID>();
	Location block1;
	Location block2;
	
	ProtectionField(Location block1, Location block2, Player owner, int id)
	{
		this.block1 = block1;
		this.block2 = block2;
		this.owner = owner.getUniqueId();
	}
	boolean chestFlag;
	public boolean getChestFlag()
	{
		return chestFlag;
	}
	public UUID getOwner()
	{
		return owner;
	}
	public Location getBlock1()
	{
		return block1;
	}
	public Location getBlock2()
	{
		return block2;
	}
	public void setBlock1(Location block1)
	{
		this.block1 = block1;
	}
	public void setBlock2(Location block2)
	{
		this.block2 = block2;
	}
	public boolean isMember(Player a)
	{
		if(members.contains(a.getUniqueId()))
		{
			return true;
		}
		return false;
	}
	public int getId()
	{
		return id;
	}
	public double getArea()
	{
		return (Math.abs(block2.getX())-Math.abs(block1.getBlockX())) * (Math.abs(block2.getY())-Math.abs(block1.getY())) * (Math.abs(block2.getZ())-Math.abs(block1.getZ()));
	}
}
