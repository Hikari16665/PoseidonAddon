package me.eventually.poseidonAddon.slimefun.machines.generator;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.eventually.poseidonAddon.registry.PoseidonItems;
import me.eventually.poseidonAddon.registry.PoseidonSlimefunItems;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PoseidonSteamGenerator extends AInputConditionalGenerator {
    public PoseidonSteamGenerator(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public int getCapacity() {
        return 3200;
    }

    @Override
    public int getEnergyConsumption() {
        return 160;
    }

    @Override
    public int getSpeed() {
        return 1;
    }

    @Override
    public @NotNull String getMachineIdentifier() {
        return "PSI_STEAM_GENERATOR";
    }

    @Override
    public @NotNull String getInventoryTitle() {
        return PoseidonItems.PSI_STEAM_GENERATOR.getItemMeta().getDisplayName();
    }


    @Override
    protected boolean runTick(Block b) {
        BlockMenu menu = BlockStorage.getInventory(b);
        int inputSlot = super.getInputSlots()[0];
        int outputSlot = super.getOutputSlots()[0];
        ItemStack input = menu.getItemInSlot(inputSlot);
        SlimefunItem sfItem =  SlimefunItem.getByItem(input);
        SlimefunItem targetSfItem = PoseidonSlimefunItems.PSI_STEAM;
        if (sfItem == null || !sfItem.getId().equals(targetSfItem.getId())) {
            return false;
        }
        int amount = 1;
        ItemStack targetItem = targetSfItem.getItem().clone();
        targetItem.setAmount(amount * 2);
        if (!menu.fits(targetItem, outputSlot)) return false;
        if (!this.takeCharge(b.getLocation())) return false;
        menu.consumeItem(super.getInputSlots()[0], amount);
        menu.pushItem(targetItem, outputSlot);
        return true;
    }

    @Override
    public @NotNull List<String> getDescription() {
        return List.of(
                "放入1个汽,生成2个汽."
        );
    }
}
