package me.eventually.poseidonAddon.slimefun.machines.special;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import me.eventually.poseidonAddon.registry.PoseidonSlimefunItemStacks;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProtectionForce extends AContainer {
    public ProtectionForce(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    public static final Set<Location> PROTECTION_LOCATIONS = new HashSet<>();

    @Override
    public ItemStack getProgressBar() {
        return null;
    }

    @Override
    public @NotNull String getMachineIdentifier() {
        return PoseidonSlimefunItemStacks.PSI_PROTECTION_FORCE.getItemId();
    }


    @Override
    public @NotNull String getInventoryTitle() {
        return PoseidonSlimefunItemStacks.PSI_PROTECTION_FORCE.getItemMeta().getDisplayName();
    }

    @Override
    public int getSpeed() {
        return 1;
    }

    @Override
    public int getCapacity() {
        return 1;
    }

    @Override
    public int getEnergyConsumption() {
        return 1;
    }

    @Override
    public @NotNull EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.NONE;
    }

    @Override
    protected void constructMenu(BlockMenuPreset preset) {
        return;
    }

    @Override
    public int[] getInputSlots() {
        return new int[0];
    }

    @Override
    public int[] getOutputSlots() {
        return new int[0];
    }

    @Override
    protected void tick(Block b) {
        if (!PROTECTION_LOCATIONS.stream().anyMatch(location -> location.equals(b.getLocation()))) {
            PROTECTION_LOCATIONS.add(b.getLocation());
        }
    }

    @Override
    public void preRegister() {
        super.preRegister();
        addItemHandler(
                new BlockBreakHandler(false, false) {
                    @Override
                    public void onPlayerBreak(@NotNull BlockBreakEvent e, @NotNull ItemStack item, @NotNull List<ItemStack> drops) {
                        PROTECTION_LOCATIONS.removeIf(location -> location.equals(e.getBlock().getLocation()));
                    }
                }
        );
    }
}
