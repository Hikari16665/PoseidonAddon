package me.eventually.poseidonAddon.slimefun.machines.generator;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.eventually.hikarilib.itemstack.HikariItemStack;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class ACommonGenerator extends AContainer {
    protected ACommonGenerator(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }
    private static final int[] OUTPUT_SLOTS = { 10, 11, 12, 13, 14, 15, 16 };
    private static final int[] BACKGROUND_SLOTS = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26 };
    private static final ItemStack BORDER_ITEM = new HikariItemStack.Builder(
            Material.GRAY_STAINED_GLASS_PANE,
            1,
            " ",
            List.of()
    ).build().getItem();

    @Override
    public int[] getInputSlots() {
        return new int[0];
    }

    @Override
    public int[] getOutputSlots() {
        return OUTPUT_SLOTS;
    }

    @Override
    public int getSpeed() {
        return 1;
    }

    @Override
    public int getEnergyConsumption() {
        return 16;
    }

    @Override
    public EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CONSUMER;
    }

    @Override
    public int getCapacity() {
        return 512;
    }

    @Override
    public @NotNull String getInventoryTitle() {
        return super.getInventoryTitle();
    }

    @Override
    protected void constructMenu(BlockMenuPreset preset) {
        for( int slot : BACKGROUND_SLOTS) {
            preset.addItem(slot, BORDER_ITEM, ChestMenuUtils.getEmptyClickHandler());
        }
    }

    @Override
    protected void tick(Block b) {
        BlockMenu menu = BlockStorage.getInventory(b);
        Location loc = b.getLocation();
        if (!takeCharge(loc)) return;
        ItemStack output = getOutput();
        output.setAmount(getAmount());
        if (!menu.fits(getOutput(), OUTPUT_SLOTS)) return;
        menu.pushItem(getOutput(), OUTPUT_SLOTS);
    }

    @Override
    public ItemStack getProgressBar() {
        return null;
    }

    protected abstract ItemStack getOutput();
    protected abstract int getAmount();
}
