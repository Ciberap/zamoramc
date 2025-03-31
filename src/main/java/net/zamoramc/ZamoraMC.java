package net.zamoramc;

import net.zamoramc.commands.MainCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class ZamoraMC extends JavaPlugin {

    public static String prefix = "&2&lZamora&4&lMC &8▶ &f";

    public void onEnable() {
        registerCommands();

        Bukkit.getConsoleSender().sendMessage(
                ChatColor.translateAlternateColorCodes('&', prefix + "&fEl plugin se ha &ainiciado &fcorrectamente"));
    }
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(
                ChatColor.translateAlternateColorCodes('&', prefix + "&fEl plugin se ha &cdesactivado&f."));
    }
    public void registerCommands(){
        this.getCommand("zamoramc").setExecutor(new MainCommand());
    }
}
