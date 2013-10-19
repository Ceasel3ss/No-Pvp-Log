package me.nextinline.AntiLogger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin{
	AntiLogEvent ale = new AntiLogEvent(this);
	public void onEnable(){

		getServer().getPluginManager().registerEvents(new AntiLogEvent(this), this);
		this.saveDefaultConfig();
		this.getConfig().options().copyDefaults(true);
	}
	public void onDisable(){

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

		if(sender instanceof Player){
			Player player = (Player) sender;
			if(cmd.getName().equalsIgnoreCase("combat")){ 
				if(ale.getInCombat().contains(player)){
					player.sendMessage(ChatColor.RED+"You are currently in combat!");

				}else{
					player.sendMessage(ChatColor.RED+"You are currently NOT in combat.");
				}
				return true;
			}
		}
		return false;
	}
}
