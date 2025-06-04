package me.eventually.poseidonAddon.slimefun.machines.common;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.eventually.hikarilib.itemstack.HikariItemStack;
import me.eventually.poseidonAddon.PoseidonAddon;
import me.eventually.poseidonAddon.registry.PoseidonItems;
import me.eventually.poseidonAddon.registry.PoseidonSlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.List;

public class PoseidonUnstablePressureMachine extends AContainer {
    private static final int[] INPUT_SLOTS_I = {9, 10, 11, 12, 13, 14, 15, 16, 17};
    private static final int[] INPUT_SLOTS_II = {18, 19, 20, 21, 22, 23, 24, 25, 26};
    private static final int[] INPUT_SLOTS = {
            9, 10, 11, 12, 13, 14, 15, 16, 17,
            18, 19, 20, 21, 22, 23, 24, 25, 26
    };
    private static final int[] OUTPUT_SLOTS = {28, 29, 30, 31, 32, 33, 34};
    private static final int PROGRESS_BAR = 40;
    private static final int[] BORDER = {36, 44, 39, 41};
    private static final int[] BORDER_IN = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    private static final int[] BORDER_OUT = {27, 35, 37, 38, 42, 43};
    private static final int[] DESCRIPTION_SLOTS = {45, 46, 47, 48, 49, 50, 51, 52, 53};
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

    public PoseidonUnstablePressureMachine(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public ItemStack getProgressBar() {
        return null;
    }

    @Override
    public @NotNull String getMachineIdentifier() {
        return "PSI_UNSTABLE_PRESSURE_MACHINE";
    }

    @Override
    public int getCapacity() {
        return 10240;
    }

    @Override
    public int getSpeed() {
        return 1;
    }

    @Override
    public int getEnergyConsumption() {
        return 1024;
    }

    @Override
    public @NotNull String getInventoryTitle() {
        return PoseidonItems.PSI_UNSTABLE_PRESSURE_MACHINE.getItemMeta().getDisplayName();
    }

    @Override
    protected void constructMenu(BlockMenuPreset preset) {
        preset.setSize(9 * 6);
        for (int i : BORDER) {
            preset.addItem(i, BORDER_ITEM, ChestMenuUtils.getEmptyClickHandler());
        }
        for (int i : BORDER_IN) {
            preset.addItem(i, BORDER_IN_ITEM, ChestMenuUtils.getEmptyClickHandler());
        }
        for (int i : BORDER_OUT) {
            preset.addItem(i, BORDER_OUT_ITEM, ChestMenuUtils.getEmptyClickHandler());
        }
        preset.addItem(PROGRESS_BAR, getProgressBar());
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

    @Contract(value = " -> new", pure = true)
    private @NotNull @Unmodifiable List<String> getDescription() {
        return List.of(
                "需要在0格及以下工作.",
                "第二行均为输入槽I,第三行均为输入槽II,第四行中部7个槽位为输出槽.",
                "[1]输入槽I、II各自满足该行的物品类型需要一致.",
                "[2]当输入槽I水数量单调递增，输入槽II汽数量单调递减，则消耗输入槽I、II所有物品并输出1x 深水.",
                "[3]当输入槽I水数量单调递减，输入槽II汽数量单调递增，则消耗输入槽I、II所有物品并输出1x 极汽.",
                "[4]若所有输入槽均为1x流,则消耗输入槽所有物品并输出1x 渊",
                "匹配规则[2]和[3]时,输入槽I物品类型需要均为水，输入槽II物品类型需要均为汽",
                "带[]规则匹配由上至下,触发单个条件/不满足要求时立刻停止继续匹配."
        );
    }

    @Override
    public int[] getInputSlots() {
        return INPUT_SLOTS;
    }

    @Override
    public int[] getOutputSlots() {
        return OUTPUT_SLOTS;
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
    }

    private boolean runTick(Block b) {
        Location l = b.getLocation();
        // 0 需要在0格及以下工作
        if (l.getBlockY() > 0) return false;

        BlockMenu menu = BlockStorage.getInventory(b);
        SlimefunItem target_water = PoseidonSlimefunItems.PSI_WATER;
        SlimefunItem target_steam = PoseidonSlimefunItems.PSI_STEAM;
        SlimefunItem target_fluid = PoseidonSlimefunItems.PSI_FLUID;
        int target_fluid_amount = 1;

        ItemStack[] inputStacks_I = new ItemStack[INPUT_SLOTS_I.length];
        ItemStack[] inputStacks_II = new ItemStack[INPUT_SLOTS_II.length];

        for (int i = 0; i < INPUT_SLOTS_I.length; i++) {
            inputStacks_I[i] = menu.getItemInSlot(INPUT_SLOTS_I[i]);
        }
        for (int i = 0; i < INPUT_SLOTS_II.length; i++) {
            inputStacks_II[i] = menu.getItemInSlot(INPUT_SLOTS_II[i]);
        }

        boolean allFluids = true;
        for (ItemStack item : inputStacks_I) {
            if (!isSameSlimefunItem(item, target_fluid) || item.getAmount() != target_fluid_amount) {
                allFluids = false;
                break;
            }
        }
        for (ItemStack item : inputStacks_II) {
            if (!isSameSlimefunItem(item, target_fluid) || item.getAmount() != target_fluid_amount) {
                allFluids = false;
                break;
            }
        }
        // 4 所有输入槽均为16x流
        if (allFluids) {
            consumeAllInput(menu);
            SlimefunItem abyss = PoseidonSlimefunItems.PSI_ABYSS;
            if (!menu.fits(abyss.getItem(), OUTPUT_SLOTS)) return false;
            if (!takeCharge(l)) return false;
            menu.pushItem(abyss.getItem(), OUTPUT_SLOTS);
            playSound(l);
            return true;
        }

        // 23 检查类型一致性
        boolean allWater = true;
        for (ItemStack item : inputStacks_I) {
            if (!isSameSlimefunItem(item, target_water)) {
                allWater = false;
                break;
            }
        }
        boolean allSteam = true;
        for (ItemStack item : inputStacks_II) {
            if (!isSameSlimefunItem(item, target_steam)) {
                allSteam = false;
                break;
            }
        }
        if (!allWater || !allSteam) {
            return false;
        }
        // 单调性
        boolean isWaterIncreasing = isMonotonic(inputStacks_I, true);
        boolean isSteamDecreasing = isMonotonic(inputStacks_II, false);

        // 2 水递增 汽递减 = 输出深水
        if (isWaterIncreasing && isSteamDecreasing) {
            consumeAllInput(menu);
            SlimefunItem deepwater = PoseidonSlimefunItems.PSI_DEEP_WATER;
            if (!menu.fits(deepwater.getItem(),  OUTPUT_SLOTS)) return false;
            if (!takeCharge(l)) return false;
            menu.pushItem(deepwater.getItem(), OUTPUT_SLOTS);
            playSound(l);
            return true;
        }

        // 3 汽递增 水递减 输出极汽
        boolean isSteamIncreasing = isMonotonic(inputStacks_II, true);
        boolean isWaterDecreasing = isMonotonic(inputStacks_I, false);
        if (isSteamIncreasing && isWaterDecreasing) {
            consumeAllInput(menu);
            SlimefunItem highsteam = PoseidonSlimefunItems.PSI_HIGH_STEAM;
            if (!menu.fits(highsteam.getItem(), OUTPUT_SLOTS)) return false;
            if (!takeCharge(l)) return false;
            menu.pushItem(highsteam.getItem(), OUTPUT_SLOTS);
            playSound(l);
            return true;
        }



        // 不符合
        return false;
    }

    private boolean isSameSlimefunItem(ItemStack item, SlimefunItem target) {
        if (item == null || item.getType() == Material.AIR) {
            return false;
        }
        SlimefunItem slimefunItem = SlimefunItem.getByItem(item);
        return slimefunItem != null && slimefunItem.getId().equals(target.getId());
    }

    private boolean isMonotonic(ItemStack[] items, boolean increasing) {
        int lastAmount = -1;
        for (ItemStack item : items) {
            if (item == null || item.getType() == Material.AIR) return false;
            int amount = item.getAmount();
            if (lastAmount != -1) {
                if (increasing && amount <= lastAmount) return false;
                if (!increasing && amount >= lastAmount) return false;
            }
            lastAmount = amount;
        }
        return true;
    }
    private void consumeAllInput(BlockMenu menu) {
        for (int slot : getInputSlots()) {
            menu.consumeItem(slot, 64);
        }
    }
    private void playSound(Location loc) {
        new BukkitRunnable() {
            @Override
            public void run() {
                loc.getWorld().playSound(loc, Sound.AMBIENT_UNDERWATER_ENTER, 1, 1);
            }
        }.runTask(PoseidonAddon.getInstance());
    }
}
