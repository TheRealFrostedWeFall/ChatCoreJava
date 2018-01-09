package FrostedWeFall.ChatCore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        for (String word : e.getMessage().split(" ")) {
            if (getConfig().getStringList("cursewords").contains(word)) {
                e.setCancelled(true);
                e.getPlayer().sendMessage(ChatColor.RED + "Don't curse or use swear words!");
            }
        }
    }

    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "ChatCore Version 0.1 Has been successfully loaded!");
    }
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "ChatCore Version 0.1 Has been successfully unloaded!");
        getServer().getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "Bye for now :)");
    }
}
