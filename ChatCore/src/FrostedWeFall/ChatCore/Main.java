package FrostedWeFall.ChatCore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
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
                e.getPlayer().sendMessage(ChatColor.RED + "\nDon't curse or use swear words\n!");
                for (String adword : e.getMessage().split(" ")) {
                    if (getConfig().getStringList("adwords").contains(word)) {
                        e.setCancelled(true);
                        e.getPlayer().sendMessage(ChatColor.RED + "\nDo not attempt to advertise\n!");
                    }
                }
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

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("chatcore")) {
            sender.sendMessage(ChatColor.YELLOW + "ChatCore ( Java ) is a all in one chat control plugin developed entirely by FrostedWeFall!");
        }
        if (cmd.getName().equalsIgnoreCase("chatcore help")) {
            sender.sendMessage(ChatColor.AQUA + "ChatCore Help Menu:\n");
            sender.sendMessage(ChatColor.YELLOW + "/chatcore - Information about the plugin");
            sender.sendMessage(ChatColor.YELLOW + "/chatcore report - Report an error about the plugin");
            sender.sendMessage(ChatColor.YELLOW + "/chatcore version - Tells you the current version of the plugin.");
        }
        if (cmd.getName().equalsIgnoreCase("chatcore report")){
            sender.sendMessage(ChatColor.YELLOW + "Report issues here at https://github.com/TheRealFrostedWeFall/ChatCoreJava/issues");
}       if (cmd.getName().equalsIgnoreCase("chatcore version")) {
            sender.sendMessage(ChatColor.AQUA + "ChatCore Version 0.1 by FrostedWeFall");
        }
        return true;
    }
}
