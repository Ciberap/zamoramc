package net.zamoramc.commands;

import net.zamoramc.ZamoraMC;
import net.zamoramc.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if(!(sender instanceof Player)) {
            //Consola
            sender.sendMessage(MessageUtils.getColoredMessage(ZamoraMC.prefix + "Hola consola, si quieres ejecutar un comando funcional del plugin ZamoraMC de Ciberap, debes ejecutarlo desde un jugador en el servidor."));
            return true;
        }
        //Jugador
        Player player = (Player) sender;

        // /zamoramc args[0]
        if (args.length >= 1){
            if (args[0].equalsIgnoreCase("info")) {
                sender.sendMessage(MessageUtils.getColoredMessage(ZamoraMC.prefix + "Puedes consultar las redes en &a/redes"));
            } else if (args[0].equalsIgnoreCase("s4vi")) {
                s4vitar(sender);
            } else if (args[0].equalsIgnoreCase("personal")){
                // /zamoramc personal <gestion/otro>
                subCommandPersonal(sender, args);
            } else {
                help(sender);
            }
        } else {
            help(sender);
        }

        return false;
    }

    public void help(CommandSender sender) {
        sender.sendMessage(MessageUtils.getColoredMessage("&f-------- &2&lZamora&4&lMC &f--------"));
        sender.sendMessage(MessageUtils.getColoredMessage("&7- &a/zamoramc info &fTe muestra la info."));
        sender.sendMessage(MessageUtils.getColoredMessage("&7- &a/zamoramc s4vi  &fNo te atreves a probarlo."));
        sender.sendMessage(MessageUtils.getColoredMessage("&7- &a/zamoramc personal <gestion/otro>"));
        sender.sendMessage(MessageUtils.getColoredMessage("&f--------------------------"));
    }

    public void subCommandPersonal(CommandSender sender, String[] args){
        if(!sender.hasPermission("zamoramc.commands.personal")){
            sender.sendMessage(MessageUtils.getColoredMessage(ZamoraMC.prefix + "&cNo tienes permiso."));
            return;
        }

        if (args.length == 1){
            // /zamoramc personal
            sender.sendMessage(MessageUtils.getColoredMessage(ZamoraMC.prefix + "&cDebes usar &7/zamoramc personal <gestion/otro>"));
            return;
        }

        if (args[1].equalsIgnoreCase("gestion")){
            // /zamoramc personal gestion
            sender.sendMessage(MessageUtils.getColoredMessage(ZamoraMC.prefix + "&fEn este servidor hay personas que se dedican a gestionar ZamoraMC."));

        } else if (args[1].equalsIgnoreCase("otro")){
            // /zamoramc personal otro
            sender.sendMessage(MessageUtils.getColoredMessage(ZamoraMC.prefix + "&fTodavia no hay otro.."));
        } else {
            sender.sendMessage(MessageUtils.getColoredMessage(ZamoraMC.prefix + "&cDebes usar &7/zamoramc personal <gestion/otro>"));
        }
    }

    public void s4vitar(CommandSender sender) {
        Player player = (Player) sender;
        if(!sender.hasPermission("zamoramc.commands.s4vi")) {
            sender.sendMessage(MessageUtils.getColoredMessage(ZamoraMC.prefix + "&cNo tienes permiso para tensar la cosa"));
            return;
        }
        sender.sendMessage(MessageUtils.getColoredMessage(ZamoraMC.prefix + player.getName()));
        sender.sendMessage(MessageUtils.getColoredMessage(ZamoraMC.prefix + "Se tensó que no veas."));
    }
}