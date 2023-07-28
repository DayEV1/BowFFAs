package de.mentania.chroniks.bowffa.commands;

import de.mentania.chroniks.bowffa.utils.Utils;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
import java.util.HashMap;

public class BuildCommand implements CommandExecutor {

    private final HashMap<Player, ItemStack[]> inv = new HashMap<>();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {

        if (sender instanceof Player){
            Player p = (Player) sender;

            if (p.hasPermission("Mentania.bowbash.build")){
                switch (p.getGameMode()){
                    case ADVENTURE -> {
                        inv.put(p, p.getInventory().getContents());
                        p.getInventory().clear();
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(Utils.getPrefix() + " §7Baumodus §aaktviert!");
                    }
                    case CREATIVE -> {
                        p.getInventory().clear();
                        p.getInventory().setContents(inv.get(p));
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(Utils.getPrefix() + " §7Baumodus §cdeaktivert!");
                    }
                }


            }else {
                p.sendMessage(Utils.keineRechte());
            }


        }

        return false;
    }
}
