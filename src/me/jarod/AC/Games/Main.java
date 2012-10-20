package me.jarod.AC.Games;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	FileConfiguration config = this.plugin.getConfig();
	private Main plugin;
	
	public Main(){
	}
	
	public void onDisable()
    {
    }

    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(new PL(), this);
        
        getConfig().options().copyDefaults(true);
		saveConfig();
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String args[]){
    	
    	String pln = ChatColor.GREEN + "[Games]";
		Player p = (Player)sender;
		String playern = p.getName();
		
		if(cmdLabel.equalsIgnoreCase("team") ){
			if(args[0].equalsIgnoreCase(config.getString("Team.Team1Name"))){
			sender.sendMessage(pln + "You have chosen team " + config.getString("Team.Team1Name") + "!");
			p.setDisplayName(ChatColor.RED + config.getString("Team.Team1Name") + ChatColor.WHITE + playern);
			return true;
			}
		}		
    	
    	return false;
    }
    
    public String ColorChat(String string) {
		string = string.replaceAll("&0", ChatColor.BLACK + "");
		string = string.replaceAll("&1", ChatColor.DARK_BLUE + "");
		string = string.replaceAll("&2", ChatColor.DARK_GREEN + "");
		string = string.replaceAll("&3", ChatColor.DARK_AQUA + "");
		string = string.replaceAll("&4", ChatColor.DARK_RED + "");
		string = string.replaceAll("&5", ChatColor.DARK_PURPLE + "");
		string = string.replaceAll("&6", ChatColor.GOLD + "");
		string = string.replaceAll("&7", ChatColor.GRAY + "");
		string = string.replaceAll("&8", ChatColor.DARK_GRAY + "");
		string = string.replaceAll("&9", ChatColor.BLUE + "");
		string = string.replaceAll("&a", ChatColor.GREEN + "");
		string = string.replaceAll("&b", ChatColor.AQUA + "");
		string = string.replaceAll("&c", ChatColor.RED + "");
		string = string.replaceAll("&d", ChatColor.LIGHT_PURPLE + "");
		string = string.replaceAll("&e", ChatColor.YELLOW + "");
		string = string.replaceAll("&f", ChatColor.WHITE + "");

		return string;
	}
	
}

