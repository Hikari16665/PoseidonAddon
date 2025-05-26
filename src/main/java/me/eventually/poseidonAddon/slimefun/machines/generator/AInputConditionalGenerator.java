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
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@SuppressWarnings("deprecation")
public abstract class AbstractInputConditionalGenerator extends AContainer {
    private static final int[] INPUT_SLOTS = {10};
    private static final int[] OUTPUT_SLOTS = {16};
    private static final int PROGRESS_BAR = 13;
    private static final int[] BORDER = {3, 4, 5, 12, 14, 21, 22, 23};
    private static final int[] BORDER_IN = {0, 1, 2, 9, 11, 18, 19, 20};
    private static final int[] BORDER_OUT = {6, 7, 8, 15, 17, 24, 25, 26};
    private static final int[] DESCRIPTION_SLOTS = {27, 28, 29, 30, 31, 32, 33, 34, 35};
    private static final ItemStack BORDER_ITEM = new HikariItemStack.Builder(
            Material.GRAY_STAINED_GLASS_PANE,
            1,
            " ",
            List.of()
    ).build().getItem();
    private static final ItemStack BORDER_IN_ITEM = new HikariItemStack.Builder(
            Material.BLUE_STAINED_GLASS_PANE,
            1,
            " ",
            List.of()
    ).build().getItem();
    private static final ItemStack BORDER_OUT_ITEM = new HikariItemStack.Builder(
            Material.RED_STAINED_GLASS_PANE,
            1,
            " ",
            List.of()
    ).build().getItem();
    private static final ItemStack PROGRESS_DEFAULT = new HikariItemStack.Builder(
            Material.RED_STAINED_GLASS_PANE,
            1,
            ChatColor.RED + "摸鱼中!",
            List.of()
    ).build().getItem();

    protected AbstractInputConditionalGenerator(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister() {
        super.preRegister();
    }


    @Override
    public abstract int getCapacity();

    @Override
    public abstract int getEnergyConsumption();

    @Override
    public abstract int getSpeed();

    @Override
    public int[] getInputSlots() {
        return INPUT_SLOTS;
    }

    @Override
    public int[] getOutputSlots() {
        return OUTPUT_SLOTS;
    }

    @Override
    public boolean isTicking() {
        return true;
    }

    @Override
    public abstract @NotNull String getInventoryTitle();

    @Override
    public ItemStack getProgressBar() {
        return null;
    }

    @Override
    public @NotNull EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CONSUMER;
    }

    @Override
    protected void tick(Block b) {
        BlockMenu menu = BlockStorage.getInventory(b);
        ItemStack progressBarWorking = new HikariItemStack.Builder(
            Material.GREEN_STAINED_GLASS_PANE,
            1,
            ChatColor.GREEN + "工作中!",
            List.of(
                    ChatColor.DARK_GRAY + "⇨ " + ChatColor.YELLOW + "⚡ " + ChatColor.GRAY + getEnergyConsumption()  + "J / Tick"
            )
        ).build().getItem();
        boolean result = runTick(b);
        menu.addItem(PROGRESS_BAR, result ? progressBarWorking : PROGRESS_DEFAULT, (p, slot, item, action) -> false);
    };

    @Override
    public abstract @NotNull String getMachineIdentifier();

    @Override
    protected void constructMenu(BlockMenuPreset preset) {
        preset.setSize(9 * 4);
        for (int i : BORDER) {
            preset.addItem(i, BORDER_ITEM, ChestMenuUtils.getEmptyClickHandler());
        }
        for (int i : BORDER_IN) {
            preset.addItem(i, BORDER_IN_ITEM, ChestMenuUtils.getEmptyClickHandler());
        }
        for (int i : BORDER_OUT) {
            preset.addItem(i, BORDER_OUT_ITEM, ChestMenuUtils.getEmptyClickHandler());
        }
        preset.addItem(PROGRESS_BAR, PROGRESS_DEFAULT);
        List<String> descriptions = getDescription();
        if (descriptions.size() > DESCRIPTION_SLOTS.length) {
            throw new UnsupportedOperationException("Descriptions too long for container");
        }
        for (int i = 0; i < DESCRIPTION_SLOTS.length; i++) {
            preset.addItem(DESCRIPTION_SLOTS[i], new HikariItemStack.Builder(
                    Material.BIRCH_HANGING_SIGN,
                    1,
                    ChatColor.WHITE + "介绍",
                    List.of(ChatColor.GRAY + (i < descriptions.size() ? descriptions.get(i) : ""))
            ).build().getItem(), (p, slot, item, action) -> false);
        }
    }

    protected abstract boolean runTick(Block b);

    public abstract @NotNull List<String> getDescription();
}
