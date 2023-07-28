package de.mentania.chroniks.bowffa.commands;

import de.mentania.chroniks.bowffa.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.BufferedCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
         Player player = (Player) sender;
         if (player.hasPermission("fly.bowbash")) {
             if (args.length == 0) {
                if (player.getAllowFlight()){
                    player.setAllowFlight(true);
                    player.setFlying(true);
                    player.sendMessage(Utils.getPrefix() + " §7Flugmodus §aaktivert!");

                } else {
                    player.setAllowFlight(false);
                    player.setFlying(false);
                    player.sendMessage(Utils.getPrefix() + " §7Flugmodus §cdeaktiviert!");
                }


             } else if (args.length == 1) {

                 Player target = Bukkit.getPlayer(args[0]);

                 if (target.getAllowFlight()){
                     target.setAllowFlight(true);
                     target.setFlying(true);
                     target.sendMessage(Utils.getPrefix() + " §7Flugmodus von " + player.getName() + " §aaktivert!");
                     player.sendMessage(Utils.getPrefix() + " §7Du hast den Flugmodus für " + target.getName() + " §aaktivert!");
                 } else {
                     target.setAllowFlight(false);
                     target.setFlying(false);
                     target.sendMessage(Utils.getPrefix() + " §7Flugmodus von " + player.getName() + " §cdeaktivert!");
                     player.sendMessage(Utils.getPrefix() + " §7Du hast den Flugmodus für " + target.getName() + " §cdeaktivert!");

                 }

             }

         }else
             player.sendMessage(Utils.keineRechte());
        }
        return false;
    }
}
