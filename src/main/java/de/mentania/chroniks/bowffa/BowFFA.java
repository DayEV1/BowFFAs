package de.mentania.chroniks.bowffa;

import de.mentania.chroniks.bowffa.commands.BuildCommand;
import de.mentania.chroniks.bowffa.commands.FlyCommand;
import de.mentania.chroniks.bowffa.commands.GmCommand;
import de.mentania.chroniks.bowffa.commands.VanishCommand;
import de.mentania.chroniks.bowffa.listener.JoinListener;
import de.mentania.chroniks.bowffa.mysql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public final class BowFFA extends JavaPlugin {

    private static BowFFA INSTANCE;
    private MySQL sql;

    @Override
    public void onEnable() {

        INSTANCE = this;

        try {
            registerMySQL();
        }catch (SQLException e){
            e.printStackTrace();
        }

        registerCommands();
        registerListeners();



    }

    @Override
    public void onDisable() {

    }

    public void registerCommands(){
        getCommand("build").setExecutor(new BuildCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("gm").setExecutor(new GmCommand());
    }

    public void registerListeners(){

        Bukkit.getPluginManager().registerEvents(new JoinListener(this), this);

    }

    public void registerMySQL() throws SQLException {
        this.sql = new MySQL();
        sql.createplayerstats();
    }

    public MySQL getSql() {
        return sql;
    }

    public static BowFFA getINSTANCE() {
        return INSTANCE;
    }
}
