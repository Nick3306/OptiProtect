package Nick3306.github.io.OptiProtect;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class ProtectionField
{
	UUID owner;
	ArrayList<UUID> members = new ArrayList<UUID>();
	ProtectionField(Location a, Location b)
	{
		this.x1 = a.getX();
		this.y1 = a.getY();
		this.z1 = a.getZ();
		this.x2 = b.getX();
		this.y2 = b.getY();
		this.z2 = b.getZ();
	}
	double x1;
	double y1;
	double z1;
	double x2;
	double y2;
	double z2;
	public UUID getOwner()
	{
		return owner;
	}
	public void setOwner(UUID owner)
	{
		this.owner = owner;
	}
	public double getX1()
	{
		return x1;
	}
	public void setX1(double x1)
	{
		this.x1 = x1;
	}
	public double getY1()
	{
		return y1;
	}
	public void setY1(double y1)
	{
		this.y1 = y1;
	}
	public double getZ1()
	{
		return z1;
	}
	public void setZ1(double z1)
	{
		this.z1 = z1;
	}
	public double getX2()
	{
		return x2;
	}
	public void setX2(double x2)
	{
		this.x2 = x2;
	}
	public double getY2()
	{
		return y2;
	}
	public void setY2(double y2)
	{
		this.y2 = y2;
	}
	public double getZ2()
	{
		return z2;
	}
	public void setZ2(double z2)
	{
		this.z2 = z2;
	}
	public boolean isMember(Player a)
	{
		if(members.contains(a.getUniqueId()))
		{
			return true;
		}
		return false;
	}
	public double getArea()
	{
		return (Math.abs(x2)-Math.abs(x1)) * (Math.abs(y2)-Math.abs(y1)) * (Math.abs(z2)-Math.abs(z1));
	}
}
