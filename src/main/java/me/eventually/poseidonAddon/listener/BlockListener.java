package me.eventually.poseidonAddon.listener;

import me.eventually.poseidonAddon.registry.PoseidonSlimefunItems;
import me.eventually.poseidonAddon.slimefun.machines.special.ProtectionForce;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class BlockListener implements Listener {
    @EventHandler
    public static void onBlockBreak(@NotNull BlockBreakEvent event) {
        Player player = event.getPlayer();
        Material blockType = event.getBlock().getType();
        Location blockLocation = event.getBlock().getLocation();
        World world = blockLocation.getWorld();
        if (world.getEnvironment() != World.Environment.NORMAL) return;
        if (blockType == Material.ICE) {
            runIfChance(1 / 3f, () -> world.dropItemNaturally(blockLocation, PoseidonSlimefunItems.PSI_WATER.getItem()));
        }
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        if (itemInMainHand == null || itemInMainHand.getType() != Material.TORCH) return;
        if (blockType == Material.GLASS) {
            ItemStack targetSteam = PoseidonSlimefunItems.PSI_STEAM.getItem().clone();
            targetSteam.setAmount(3);
            runIfChance(1 / 3f, () -> world.dropItemNaturally(blockLocation, targetSteam));
        }
    }

    private static void runIfChance(float chance, Runnable runnable) {
        if (Math.random() < chance) {
            runnable.run();
        }
    }

    @EventHandler
    public static void onExplosionEntity(@NotNull EntityExplodeEvent event) {
        try{
            if (ProtectionForce.PROTECTION_LOCATIONS.stream().anyMatch(location -> location.distance(event.getLocation()) <= 32)) {
                event.setCancelled(true);
            }
        } catch (IllegalArgumentException ignored) {
        }
    }

    @EventHandler
    public static void onExplosionBlock(@NotNull BlockExplodeEvent event) {
        try{
            if (ProtectionForce.PROTECTION_LOCATIONS.stream().anyMatch(location -> location.distance(event.getBlock().getLocation()) <= 32)) {
                event.setCancelled(true);
            }
        } catch (IllegalArgumentException ignored) {
        }

    }
}
