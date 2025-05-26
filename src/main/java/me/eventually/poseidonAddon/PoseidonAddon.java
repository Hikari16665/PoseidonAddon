package me.eventually.poseidonAddon;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.eventually.poseidonAddon.listener.BlockListener;
import me.eventually.poseidonAddon.registry.PoseidonGroups;
import me.eventually.poseidonAddon.registry.PoseidonSlimefunItems;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class PoseidonAddon extends JavaPlugin implements SlimefunAddon {
    private static PoseidonAddon instance;

    public static PoseidonAddon getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic
        // Item Register
        PoseidonGroups.setup(instance);
        PoseidonSlimefunItems.register(instance);

        Bukkit.getPluginManager().registerEvents(new BlockListener(), instance);
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public @NotNull JavaPlugin getJavaPlugin() {
        return this;
    }
    @Override
    public @NotNull String getBugTrackerURL() {
        return "";
    }
}
