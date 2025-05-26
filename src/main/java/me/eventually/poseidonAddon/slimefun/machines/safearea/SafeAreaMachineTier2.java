package me.eventually.poseidonAddon.slimefun.machines.safearea;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.eventually.poseidonAddon.registry.PoseidonItems;
import me.eventually.poseidonAddon.registry.PoseidonSlimefunItems;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class SafeAreaMachineTier2 extends ASafeAreaMachine {
    public SafeAreaMachineTier2(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public int getRadius() {
        return 32;
    }

    @Override
    public @NotNull String getInventoryTitle() {
        return PoseidonItems.PSI_GUARD_FORCE_MACHINE_II.getItemMeta().getDisplayName();
    }

    @Override
    public @NotNull String getMachineIdentifier() {
        return PoseidonSlimefunItems.PSI_GUARD_FORCE_MACHINE_II.getId();
    }

    @Override
    protected long getSingletonCharge() {
        return 400;
    }
}
