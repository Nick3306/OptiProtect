package Nick3306.github.io.OptiProtect;

import java.beans.PropertyVetoException;
import java.util.ArrayList;

import javax.naming.NamingException;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import Listeners.BlockEditListeners;
import Listeners.RegionDefineListener;



public class Main extends JavaPlugin
{
	public ArrayList<ProtectionField> fields = new ArrayList<ProtectionField>();
	public ArrayList<ProtectionField> newFields = new ArrayList<ProtectionField>();
	public Utilities util;
	public MySql sql;
	public void onEnable()
	{
		PluginManager pm = getServer().getPluginManager();
		this.getConfig().options().copyDefaults(true);
		saveDefaultConfig();
		
		pm.registerEvents(new BlockEditListeners(this), this);
		pm.registerEvents(new RegionDefineListener(this), this);
		
		getCommand("Protect").setExecutor(new CommandHandler(this));
		

			sql = new MySql(this);		 
			sql.getFields();
		
	}
	public void onDisable()
	{
		sql.closeConnections();
	}
}
