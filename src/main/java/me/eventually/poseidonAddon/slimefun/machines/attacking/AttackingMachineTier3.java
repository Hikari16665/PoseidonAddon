package me.eventually.poseidonAddon.slimefun.machines.attacking;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.eventually.poseidonAddon.registry.PoseidonSlimefunItemStacks;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class AttackingMachineTier3 extends AAttackingMachine {
    public AttackingMachineTier3(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public @NotNull String getMachineIdentifier() {
        return PoseidonSlimefunItemStacks.PSI_ATTACKING_MACHINE_III.getItemId();
    }

    @Override
    protected long getCountdown() {
        return 1;
    }

    @Override
    protected int getDamage() {
        return 20;
    }

    @Override
    public @NotNull String getInventoryTitle() {
        return PoseidonSlimefunItemStacks.PSI_ATTACKING_MACHINE_III.getItemMeta().getDisplayName();
    }
}