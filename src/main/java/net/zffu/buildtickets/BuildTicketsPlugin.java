package net.zffu.buildtickets;

import lombok.Getter;
import net.zffu.buildtickets.commands.BuildModeCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.UUID;

@Getter
public final class BuildTicketsPlugin extends JavaPlugin {
    private static BuildTicketsPlugin INSTANCE;

    private ArrayList<UUID> buildMode = new ArrayList<>();


    @Override
    public void onEnable() {
        INSTANCE = this;

        this.saveDefaultConfig();

        this.getLogger().info("Loading Features...");

        if(getConfig().getBoolean("build-mode.enabled")) {
            this.getCommand("buildmode").setExecutor(new BuildModeCommand(this.getConfig().getString("build-mode.permission")));
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static BuildTicketsPlugin getInstance() {
        return INSTANCE;
    }

}
