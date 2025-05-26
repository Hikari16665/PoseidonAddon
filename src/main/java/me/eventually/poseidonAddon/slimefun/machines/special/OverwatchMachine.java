package me.eventually.poseidonAddon.slimefun.machines.special;

import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.eventually.hikarilib.itemstack.HikariItemStack;
import me.eventually.poseidonAddon.PoseidonAddon;
import me.eventually.poseidonAddon.registry.PoseidonSlimefunItemStacks;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class OverwatchMachine extends AContainer {
    public OverwatchMachine(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }
    public static final int[] INPUT_SLOTS = {10, 19, 28, 37};
    public static final int[] OUTPUT_SLOTS = {31, 32,33, 34};
    private static final int[] BORDER_IN = {0, 1, 2, 9, 11, 18, 20, 27, 29, 36, 38, 45, 46, 47};
    private static final int[] BORDER_OUT = {3, 4, 5, 6, 7 , 8, 12, 17, 21, 22, 23, 24, 25, 26, 30, 35, 39, 40, 41, 42, 43, 44};
    private static final int[] DESCRIPTION_SLOTS = {48, 49, 50, 51, 52, 53};
    public static final int STATUS_SLOT = 13;
    public static final int PROGRESS_SLOT_I = 14;
    public static final int PROGRESS_SLOT_II = 15;
    public static final int PROGRESS_SLOT_III = 16;
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

    public static final List<EntityType> SEA_ENTITIES = List.of(
            EntityType.COD,
            EntityType.SALMON,
            EntityType.TROPICAL_FISH,
            EntityType.PUFFERFISH
    );

    private static int getData(Location loc, String key) {
        return Integer.parseInt(Objects.requireNonNull(StorageCacheUtils.getData(loc, key)));
    }

    private static void addendum(Location loc, String key, int amount) {
        long data = getData(loc, key);
        StorageCacheUtils.setData(loc, key, String.valueOf(data + amount));
    }

    public static final Map<SlimefunItemStack, String> MATERIAL_MAPPING = Map.ofEntries(
            Map.entry(SlimefunItems.COPPER_INGOT, "progress-cu"),
            Map.entry(SlimefunItems.TIN_INGOT, "progress-sn"),
            Map.entry(SlimefunItems.ALUMINUM_INGOT, "progress-al"),
            Map.entry(SlimefunItems.ZINC_INGOT, "progress-zn"),
            Map.entry(SlimefunItems.GOLD_4K, "progress-au4"),
            Map.entry(SlimefunItems.LEAD_INGOT, "progress-pb"),
            Map.entry(SlimefunItems.SILVER_INGOT, "progress-ag"),
            Map.entry(SlimefunItems.MAGNESIUM_INGOT, "progress-mg")
    );
    public static final Map<SlimefunItemStack, String> RUNE_MAPPING = Map.ofEntries(
            Map.entry(SlimefunItems.AIR_RUNE, "rune-air"),
            Map.entry(SlimefunItems.EARTH_RUNE, "rune-earth"),
            Map.entry(SlimefunItems.FIRE_RUNE, "rune-fire"),
            Map.entry(SlimefunItems.WATER_RUNE, "rune-water"),
            Map.entry(SlimefunItems.ENDER_RUNE, "rune-ender"),
            Map.entry(SlimefunItems.LIGHTNING_RUNE, "rune-lightning")
    );
    public static final Map<Material, String> MINERAL_MAPPING = Map.ofEntries(
            Map.entry(Material.IRON_INGOT, "progress-iron"),
            Map.entry(Material.GOLD_INGOT, "progress-gold"),
            Map.entry(Material.DIAMOND, "progress-diamond"),
            Map.entry(Material.EMERALD, "progress-emerald"),
            Map.entry(Material.LAPIS_LAZULI, "progress-lapis"),
            Map.entry(Material.REDSTONE, "progress-redstone"),
            Map.entry(Material.QUARTZ, "progress-quartz"),
            Map.entry(Material.NETHERITE_INGOT, "progress-netherite")
    );

    @Override
    public void preRegister() {
        super.preRegister();
        addItemHandler(
                new BlockPlaceHandler(false) {
                    @Override
                    public void onPlayerPlace(@NotNull BlockPlaceEvent e) {
                        Location loc = e.getBlock().getLocation();
                        initVanilla(loc);
                        initSlimefun(loc);
                        initRune(loc);
                    }
                }
        );
    }

    private void initRune(Location loc) {
        // Slimefun Runes
        StorageCacheUtils.setData(loc, "rune-air", "0");
        StorageCacheUtils.setData(loc, "rune-earth", "0");
        StorageCacheUtils.setData(loc, "rune-fire", "0");
        StorageCacheUtils.setData(loc, "rune-water", "0");
        StorageCacheUtils.setData(loc, "rune-ender", "0");
        StorageCacheUtils.setData(loc, "rune-lightning", "0");
    }

    private void initSlimefun(Location loc) {
        // Slimefun Part
        StorageCacheUtils.setData(loc, "progress-cu", "0");
        StorageCacheUtils.setData(loc, "progress-sn", "0");
        StorageCacheUtils.setData(loc, "progress-ag", "0");
        StorageCacheUtils.setData(loc, "progress-pb", "0");
        StorageCacheUtils.setData(loc, "progress-al", "0");
        StorageCacheUtils.setData(loc, "progress-zn", "0");
        StorageCacheUtils.setData(loc, "progress-mg", "0");
        StorageCacheUtils.setData(loc, "progress-au4", "0");
    }

    private void initVanilla(Location loc) {
        // Vanilla Part
        StorageCacheUtils.setData(loc, "progress-emerald", "0");
        StorageCacheUtils.setData(loc, "progress-diamond", "0");
        StorageCacheUtils.setData(loc, "progress-lapis", "0");
        StorageCacheUtils.setData(loc, "progress-redstone", "0");
        StorageCacheUtils.setData(loc, "progress-quartz", "0");
        StorageCacheUtils.setData(loc, "progress-iron", "0");
        StorageCacheUtils.setData(loc, "progress-gold", "0");
        StorageCacheUtils.setData(loc, "progress-netherite", "0");
    }


    @Override
    protected void tick(Block b) {
        BlockMenu menu = BlockStorage.getInventory(b);

        if (!takeCharge(b.getLocation())) return;

        int progress_emerald = getData(b.getLocation(), "progress-emerald");
        int progress_diamond = getData(b.getLocation(), "progress-diamond");
        int progress_lapis = getData(b.getLocation(), "progress-lapis");
        int progress_redstone = getData(b.getLocation(), "progress-redstone");
        int progress_quartz = getData(b.getLocation(), "progress-quartz");
        int progress_iron = getData(b.getLocation(), "progress-iron");
        int progress_gold = getData(b.getLocation(), "progress-gold");
        int progress_netherite = getData(b.getLocation(), "progress-netherite");

        int progress_cu = getData(b.getLocation(), "progress-cu");
        int progress_sn = getData(b.getLocation(), "progress-sn");
        int progress_ag = getData(b.getLocation(), "progress-ag");
        int progress_pb = getData(b.getLocation(), "progress-pb");
        int progress_al = getData(b.getLocation(), "progress-al");
        int progress_zn = getData(b.getLocation(), "progress-zn");
        int progress_mg = getData(b.getLocation(), "progress-mg");
        int progress_au4 = getData(b.getLocation(), "progress-au4");

        int rune_air = getData(b.getLocation(), "rune-air");
        int rune_earth = getData(b.getLocation(), "rune-earth");
        int rune_fire = getData(b.getLocation(), "rune-fire");
        int rune_water = getData(b.getLocation(), "rune-water");
        int rune_ender = getData(b.getLocation(), "rune-ender");
        int rune_lightning = getData(b.getLocation(), "rune-lightning");
        boolean flag_wave = false;
        boolean flag_night_wave = false;
        boolean flag_surge = true;
        World world = b.getWorld();
        switch (world.getEnvironment()) {
            case NORMAL -> {
                flag_wave = world.getTime() <= 12000;
                flag_night_wave = world.getTime() > 12000;
            }
            case THE_END -> {
                flag_night_wave = true;
            }
        }

        Location loc = b.getLocation();

        new BukkitRunnable() {
            @Override
            public void run() {
                @NotNull Collection<LivingEntity> entities =loc.getNearbyLivingEntities(3, 3, 3);
                StorageCacheUtils.setData(loc, "anyfish-detected", String.valueOf(entities.stream().anyMatch(entity -> SEA_ENTITIES.contains(entity.getType()))));
                StorageCacheUtils.setData(loc, "drowned-detected", String.valueOf(entities.stream().anyMatch(entity -> entity.getType() == EntityType.DROWNED)));
                StorageCacheUtils.setData(loc, "dolphin-detected", String.valueOf(entities.stream().anyMatch(entity -> entity.getType() == EntityType.DOLPHIN)));
            }
        }.runTask(PoseidonAddon.getInstance());

        boolean anyfish_detected = isDataTrue(loc, "anyfish-detected");
        boolean drowned_detected = isDataTrue(loc, "drowned-detected");
        boolean dolphin_detected = isDataTrue(loc, "dolphin-detected");


        ItemStack status_slot = new HikariItemStack.Builder(
                Material.GREEN_STAINED_GLASS_PANE,
                1,
                ChatColor.WHITE + "状态",
                List.of(
                        ChatColor.GRAY + "矿物态：" + (flag_wave ? ChatColor.GREEN + "可用" : ChatColor.RED + "不可用"),
                        ChatColor.GRAY + "元素态：" + (flag_night_wave ? ChatColor.GREEN + "可用" : ChatColor.RED + "不可用"),
                        ChatColor.GRAY + "魔法态：" + (flag_surge ? ChatColor.GREEN + "可用" : ChatColor.RED + "不可用"),
                        ChatColor.GRAY + "鱼类共鸣：" + (anyfish_detected ? ChatColor.GREEN + "存在" : ChatColor.RED + "不存在"),
                        ChatColor.GRAY + "海豚共鸣：" + (dolphin_detected ? ChatColor.GREEN + "存在" : ChatColor.RED + "不存在"),
                        ChatColor.GRAY + "溺尸共鸣：" + (drowned_detected ? ChatColor.GREEN + "存在" : ChatColor.RED + "不存在")
                )
        ).build().getItem();

        ItemStack progress_i = new HikariItemStack.Builder(
                Material.PINK_STAINED_GLASS_PANE,
                1,
                ChatColor.WHITE + "矿物态进度",
                List.of(
                        ChatColor.GRAY + "绿宝石：" + ChatColor.GREEN + progress_emerald + ChatColor.GRAY + "/" + 1728,
                        ChatColor.GRAY + "钻石：" + ChatColor.GREEN + progress_diamond + ChatColor.GRAY + "/" + 1728,
                        ChatColor.GRAY + "青金石：" + ChatColor.GREEN + progress_lapis + ChatColor.GRAY + "/" + 1728,
                        ChatColor.GRAY + "红石：" + ChatColor.GREEN + progress_redstone + ChatColor.GRAY + "/" + 1728,
                        ChatColor.GRAY + "石英：" + ChatColor.GREEN + progress_quartz + ChatColor.GRAY + "/" + 1728,
                        ChatColor.GRAY + "铁：" + ChatColor.GREEN + progress_iron + ChatColor.GRAY + "/" + 1728,
                        ChatColor.GRAY + "金：" + ChatColor.GREEN + progress_gold + ChatColor.GRAY + "/" + 1728,
                        ChatColor.GRAY + "下界合金：" + ChatColor.GREEN + progress_netherite + ChatColor.GRAY + "/" + 1728
                )
        ).build().getItem();
        ItemStack progress_ii = new HikariItemStack.Builder(
                Material.PINK_STAINED_GLASS_PANE,
                1,
                ChatColor.WHITE + "元素态进度",
                List.of(
                        ChatColor.GRAY + "铜：" + ChatColor.GREEN + progress_cu + ChatColor.GRAY + "/" + 1728,
                        ChatColor.GRAY + "锡：" + ChatColor.GREEN + progress_sn + ChatColor.GRAY + "/" + 1728,
                        ChatColor.GRAY + "银：" + ChatColor.GREEN + progress_ag + ChatColor.GRAY + "/" + 1728,
                        ChatColor.GRAY + "铅：" + ChatColor.GREEN + progress_pb + ChatColor.GRAY + "/" + 1728,
                        ChatColor.GRAY + "铝：" + ChatColor.GREEN + progress_al + ChatColor.GRAY + "/" + 1728,
                        ChatColor.GRAY + "锌：" + ChatColor.GREEN + progress_zn + ChatColor.GRAY + "/" + 1728,
                        ChatColor.GRAY + "镁：" + ChatColor.GREEN + progress_mg + ChatColor.GRAY + "/" + 1728,
                        ChatColor.GRAY + "4k金：" + ChatColor.GREEN + progress_au4 + ChatColor.GRAY + "/" + 1728
                )
        ).build().getItem();
        ItemStack progress_iii = new HikariItemStack.Builder(
                Material.PINK_STAINED_GLASS_PANE,
                1,
                ChatColor.WHITE + "魔法态进度",
                List.of(
                        ChatColor.GRAY + "水元素：" + ChatColor.GREEN + rune_water + ChatColor.GRAY + "/" + 1728,
                        ChatColor.GRAY + "火元素：" + ChatColor.GREEN + rune_fire + ChatColor.GRAY + "/" + 1728,
                        ChatColor.GRAY + "气元素：" + ChatColor.GREEN + rune_air + ChatColor.GRAY + "/" + 1728,
                        ChatColor.GRAY + "土元素：" + ChatColor.GREEN + rune_earth + ChatColor.GRAY + "/" + 1728,
                        ChatColor.GRAY + "末影元素：" + ChatColor.GREEN + rune_ender + ChatColor.GRAY + "/" + 1728,
                        ChatColor.GRAY + "雷电元素：" + ChatColor.GREEN + rune_lightning + ChatColor.GRAY + "/" + 1728
                )
        ).build().getItem();

        menu.addItem(STATUS_SLOT, status_slot, (p, slot, item, action) -> false);
        menu.addItem(PROGRESS_SLOT_I, progress_i, (p, slot, item, action) -> false);
        menu.addItem(PROGRESS_SLOT_II, progress_ii, (p, slot, item, action) -> false);
        menu.addItem(PROGRESS_SLOT_III, progress_iii, (p, slot, item, action) -> false);

        if (flag_wave) {
            consumeMineral(b);
        }
        if (flag_night_wave) {
            consumeElement(b);
        }
        if (flag_surge) {
            consumeMagic(b);
        }
        
        if (allAbove(1728, progress_cu, progress_sn, progress_al, progress_zn, progress_pb, progress_mg, progress_au4) && drowned_detected) {
            if (menu.fits(PoseidonSlimefunItemStacks.PSI_NIGHT_WAVE, OUTPUT_SLOTS)) {
                menu.pushItem(PoseidonSlimefunItemStacks.PSI_NIGHT_WAVE, OUTPUT_SLOTS);
            }
            initSlimefun(loc);
        }
        if (allAbove(1728, progress_emerald, progress_diamond, progress_lapis, progress_redstone, progress_quartz, progress_iron, progress_gold, progress_netherite) && dolphin_detected) {
            if (menu.fits(PoseidonSlimefunItemStacks.PSI_WAVE, OUTPUT_SLOTS)) {
                menu.pushItem(PoseidonSlimefunItemStacks.PSI_WAVE, OUTPUT_SLOTS);
            }
            initVanilla(loc);
        }
        if (allAbove(1728, rune_water, rune_fire, rune_air, rune_earth, rune_ender, rune_lightning) && anyfish_detected) {
            if (menu.fits(PoseidonSlimefunItemStacks.PSI_SURGE, OUTPUT_SLOTS)) {
                menu.pushItem(PoseidonSlimefunItemStacks.PSI_SURGE, OUTPUT_SLOTS);
            }
            initRune(loc);
        }
    }

    private boolean isDataTrue(Location loc, String key) {
        boolean flag;
        try {
            flag = Boolean.parseBoolean(StorageCacheUtils.getData(loc, key));
        } catch (NumberFormatException | NullPointerException ex) {
            StorageCacheUtils.setData(loc, key, "false");
            flag = false;
        }
        return flag;
    }

    private boolean allAbove(int target, int... values) {
        for (int value : values) {
            if (value < target) {
                return false;
            }
        }
        return true;
    }

    private void consumeMagic(Block b) {
        BlockMenu menu = BlockStorage.getInventory(b);
        Location loc = b.getLocation();
        for (int slot : INPUT_SLOTS) {
            ItemStack item = menu.getItemInSlot(slot);
            if (item == null || item.getType() == Material.AIR) continue;
            SlimefunItem sfItem = SlimefunItem.getByItem(item);
            if (sfItem == null) continue;

            RUNE_MAPPING.entrySet().forEach(entry -> {
                if (sfItem.getId().equals(entry.getKey().getItemId())) {
                    int current = getData(loc, entry.getValue());
                    int amount = item.getAmount();
                    int max = 1728;
                    int toConsume = Math.min(max - current, amount);
                    menu.consumeItem(slot, toConsume);
                    addendum(loc, entry.getValue(), toConsume);
                }
            });
        }
    }

    private void consumeElement(Block b) {
        BlockMenu menu = BlockStorage.getInventory(b);
        Location loc = b.getLocation();
        for (int slot : INPUT_SLOTS) {
            ItemStack item = menu.getItemInSlot(slot);
            if (item == null || item.getType() == Material.AIR) continue;
            SlimefunItem sfItem = SlimefunItem.getByItem(item);
            if (sfItem == null) continue;
            MATERIAL_MAPPING.entrySet().forEach(entry -> {
                if (sfItem.getId().equals(entry.getKey().getItemId())) {
                    int current = getData(loc, entry.getValue());
                    int amount = item.getAmount();
                    int max = 1728;
                    int toConsume = Math.min(max - current, amount);
                    menu.consumeItem(slot, toConsume);
                    addendum(loc, entry.getValue(), toConsume);
                }
            });
        }
    }

    private void consumeMineral(Block b) {
        BlockMenu menu = BlockStorage.getInventory(b);
        Location loc = b.getLocation();
        for (int slot : INPUT_SLOTS) {
            ItemStack item = menu.getItemInSlot(slot);
            if (item == null || item.getType() == Material.AIR) continue;
            SlimefunItem sfItem = SlimefunItem.getByItem(item);
            if (sfItem != null) continue;
            MINERAL_MAPPING.entrySet().forEach(entry -> {
                if (item.getType() == entry.getKey()) {
                    int current = getData(loc, entry.getValue());
                    int amount = item.getAmount();
                    int max = 1728;
                    int toConsume = Math.min(max - current, amount);
                    menu.consumeItem(slot, toConsume);
                    addendum(loc, entry.getValue(), toConsume);
                }
            });
        }
    }


    @Override
    public ItemStack getProgressBar() {
        return null;
    }

    @Override
    public @NotNull String getMachineIdentifier() {
        return PoseidonSlimefunItemStacks.PSI_OVERWATCH_MACHINE.getItemId();
    }

    @Override
    public @NotNull String getInventoryTitle() {
        return PoseidonSlimefunItemStacks.PSI_OVERWATCH_MACHINE.getItemMeta().getDisplayName();
    }

    @Override
    public int getCapacity() {
        return 4096;
    }

    @Override
    public int getEnergyConsumption() {
        return 1024;
    }

    @Override
    public int getSpeed() {
        return 1;
    }

    @Override
    protected void constructMenu(BlockMenuPreset preset) {
        preset.setSize(9 * 6);
        for (int i : BORDER_IN) {
            preset.addItem(i, BORDER_IN_ITEM, ChestMenuUtils.getEmptyClickHandler());
        }
        for (int i : BORDER_OUT) {
            preset.addItem(i, BORDER_OUT_ITEM, ChestMenuUtils.getEmptyClickHandler());
        }
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

    private List<String> getDescription() {
        return List.of(
                "[主世界日间]消耗原版矿物,进度满后若机器附近半径三格空间内出现海豚,则输出潮",
                "[主世界夜间]/[末地]消耗粘液矿物,进度满后若机器附近半径三格空间内出现溺尸,则输出汐",
                "任何情况下都消耗魔法符文,进度满后若机器附近三格空间内出现任意鱼,则输出涌"
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
}
