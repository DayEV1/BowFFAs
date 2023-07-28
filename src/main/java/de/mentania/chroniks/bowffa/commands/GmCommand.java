package de.mentania.chroniks.bowffa.commands;

import de.mentania.chroniks.bowffa.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GmCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        
        if (sender instanceof Player){
            Player p = (Player) sender;
            
            if (p.hasPermission("Mentania.bowrush.gm.all")){
                if (args.length == 0){
                    if (args[0].equalsIgnoreCase("1")){
                        if (p.hasPermission("Mentania.bowrush.gm.one")){
                            p.setGameMode(GameMode.CREATIVE);
                            p.sendMessage(Utils.getPrefix() + " §7Du bist nun im Kreativ Modus!");
                        } else {
                            p.sendMessage(Utils.keineRechte());
                        }
                    } else if (args[0].equalsIgnoreCase("0")) {
                        if (p.hasPermission("Mentania.bowrush.gm.zero")){
                            p.setGameMode(GameMode.SURVIVAL);
                            p.sendMessage(Utils.getPrefix() + " §7Du bist nun im Überlebens Modus!");
                        } else {
                            p.sendMessage(Utils.keineRechte());
                        }
                    } else if (args[0].equalsIgnoreCase("2")) {
                        if (p.hasPermission("Mentania.bowrush.gm.two")){
                            p.setGameMode(GameMode.ADVENTURE);
                            p.sendMessage(Utils.getPrefix() + " §7Du bist nun im Abenteuer Modus!");
                        } else {
                            p.sendMessage(Utils.keineRechte());
                        }
                    } else if (args[0].equalsIgnoreCase("3")) {
                        if (p.hasPermission("Mentania.bowrush.gm.drei")){
                            p.setGameMode(GameMode.SPECTATOR);
                            p.sendMessage(Utils.getPrefix() + " §7Du bist nun im Beobachter Modus!");
                        } else {
                            p.sendMessage(Utils.keineRechte());
                        }
                    }
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (args[0].equalsIgnoreCase("1")) {
                        if (p.hasPermission("Mentania.bowrush.gm.one.others")) {
                            target.setGameMode(GameMode.CREATIVE);
                            target.sendMessage(Utils.getPrefix() + " Du wurdest von " + p.getName() + " in Kreativ gesetzt!");
                            p.sendMessage(Utils.getPrefix() + " Du hast den Spieler " + target.getName() + " in Kreativ gesetzt!");
                        } else {
                            p.sendMessage(Utils.keineRechte());
                        }
                    } else if (args[0].equalsIgnoreCase("0")) {
                        if (p.hasPermission("Mentania.bowrush.gm.zero.others")) {
                            target.setGameMode(GameMode.SURVIVAL);
                            target.sendMessage(Utils.getPrefix() + " Du wurdest von " + p.getName() + " in Survial gesetzt!");
                            p.sendMessage(Utils.getPrefix() + " Du hast den Spieler " + target.getName() + " in Survial gesetzt!");
                        } else {
                            p.sendMessage(Utils.keineRechte());
                        }
                    } else if (args[0].equalsIgnoreCase("2")) {
                        if (p.hasPermission("Mentania.bowrush.gm.two.others")) {
                            target.setGameMode(GameMode.ADVENTURE);
                            target.sendMessage(Utils.getPrefix() + " Du wurdest von " + p.getName() + " in Adventure gesetzt!");
                            p.sendMessage(Utils.getPrefix() + " Du hast den Spieler " + target.getName() + " in Adventure gesetzt!");
                        } else {
                            p.sendMessage(Utils.keineRechte());
                        }
                    } else if (args[0].equalsIgnoreCase("3")) {
                        if (p.hasPermission("Mentania.bowrush.gm.one.others")) {
                            target.setGameMode(GameMode.SPECTATOR);
                            target.sendMessage(Utils.getPrefix() + " Du wurdest von " + p.getName() + " in Spectator gesetzt!");
                            p.sendMessage(Utils.getPrefix() + " Du hast den Spieler " + target.getName() + " in Spectator gesetzt!");
                        } else {
                            p.sendMessage(Utils.keineRechte());
                        }
                    }
                }
            } else {
                p.sendMessage(Utils.keineRechte());
            }
            
            
        }
        
        return false;
    }
}
