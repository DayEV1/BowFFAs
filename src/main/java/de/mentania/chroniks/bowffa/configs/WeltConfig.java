package de.mentania.chroniks.bowffa.configs;

import de.mentania.chroniks.bowffa.BowFFA;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class WeltConfig {

    private final BowFFA plugin;

    public WeltConfig(BowFFA plugin) {
        this.plugin = plugin;
    }

    private File file;
    private Configuration configuration;

        public void createWorldConfig() throws IOException {

            file = new File(plugin.getDataFolder() + "WeltConfig.yml");

            if (!plugin.getDataFolder().exists()){
                plugin.getDataFolder().mkdir();
            }

            if (!file.exists()){
                file.createNewFile();
            }


        }

        public void WorldConfiguration() throws IOException{

            configuration = YamlConfiguration.loadConfiguration(file);



        }


}

