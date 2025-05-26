package me.eventually.poseidonAddon.slimefun.machines.safearea;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.eventually.poseidonAddon.registry.PoseidonItems;
import me.eventually.poseidonAddon.registry.PoseidonSlimefunItems;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SafeAreaMachineTier1 extends AbstractSafeAreaMachine {
    protected SafeAreaMachineTier1(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public int getRadius() {
        return 8;
    }

    @Override
    public @NotNull String getInventoryTitle() {
        return PoseidonItems.PSI_GUARD_FORCE_MACHINE_I.getItemMeta().getDisplayName();
    }

    @Override
    public @NotNull String getMachineIdentifier() {
        return PoseidonSlimefunItems.PSI_GUARD_FORCE_MACHINE_I.getId();
    }

    @Override
    protected List<String> getDescription() {
        return List.of();
    }

    @Override
    protected long getSingletonCharge() {
        return 400;
    }
}
