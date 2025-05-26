package me.eventually.poseidonAddon.slimefun.machines.attacking;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.eventually.poseidonAddon.registry.PoseidonSlimefunItemStacks;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class AttackingMachineTier2 extends AAttackingMachine {
    public AttackingMachineTier2(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public @NotNull String getMachineIdentifier() {
        return PoseidonSlimefunItemStacks.PSI_ATTACKING_MACHINE_II.getItemId();
    }

    @Override
    protected long getCountdown() {
        return 4;
    }

    @Override
    protected int getDamage() {
        return 10;
    }

    @Override
    public @NotNull String getInventoryTitle() {
        return PoseidonSlimefunItemStacks.PSI_ATTACKING_MACHINE_II.getItemMeta().getDisplayName();
    }
}