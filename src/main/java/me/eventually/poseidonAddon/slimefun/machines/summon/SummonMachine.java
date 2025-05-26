package me.eventually.poseidonAddon.slimefun.machines.summon;

import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
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
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class SummonMachine extends AContainer {
    public SummonMachine(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }
    private static final int[] INPUT_SLOTS = {10};
    private static final int[] BORDER = {3, 4, 12, 13, 21, 22, 30, 31, 32, 33, 34, 35, 39, 40, 41, 42, 43, 44 };
    private static final int[] BORDER_IN = {0, 1, 2, 9, 11, 18, 19, 20, 27, 28, 29, 36, 38, 45, 46, 47};
    private static final int[] BORDER_OUT = {5, 6, 7, 8, 14, 17, 23, 24, 25, 26};
    private static final int[] DESCRIPTION_SLOTS = {48, 49, 50, 51, 52, 53};
    private static final int SLOT_SP = 37;
    private static final int CONTROL_I = 15;
    private static final int CONTROL_II = 16;
    private static final Set<EntityType> BLACKED_ENTITY_TYPES = Set.of(
            EntityType.UNKNOWN,
            EntityType.ITEM,
            EntityType.EXPERIENCE_ORB,
            EntityType.ARMOR_STAND,
            EntityType.PAINTING,
            EntityType.BOAT,
            EntityType.MINECART,
            EntityType.HOPPER_MINECART,
            EntityType.SPAWNER_MINECART,
            EntityType.TNT_MINECART,
            EntityType.COMMAND_BLOCK_MINECART,
            EntityType.CHEST_MINECART,
            EntityType.FURNACE_MINECART,
            EntityType.TNT,
            EntityType.FIREWORK_ROCKET,
            EntityType.LEASH_KNOT,
            EntityType.FISHING_BOBBER,
            EntityType.LIGHTNING_BOLT,
            EntityType.PLAYER,
            EntityType.MARKER,
            EntityType.POTION,
            EntityType.TEXT_DISPLAY,
            EntityType.ITEM_DISPLAY,
            EntityType.INTERACTION,
            EntityType.EGG,
            EntityType.SNOWBALL,
            EntityType.BREEZE_WIND_CHARGE,
            EntityType.BLOCK_DISPLAY,
            EntityType.FALLING_BLOCK,
            EntityType.WITHER,
            EntityType.ENDER_DRAGON,
            EntityType.END_CRYSTAL,
            EntityType.EYE_OF_ENDER
    );
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
    private static final Map<String, List<EntityType>> ENTITIES_ORIENT = Map.of(
            PoseidonSlimefunItemStacks.PSI_ENTITY_CARD_PIGLIN.getItemId(),
            List.of(EntityType.ZOMBIFIED_PIGLIN,
                    EntityType.PIGLIN,
                    EntityType.PIGLIN_BRUTE,
                    EntityType.HOGLIN,
                    EntityType.ZOGLIN
            ),
            PoseidonSlimefunItemStacks.PSI_ENTITY_CARD_OVERWORLD.getItemId(),
            List.of(EntityType.CREEPER,
                    EntityType.SKELETON,
                    EntityType.ZOMBIE,
                    EntityType.SPIDER
            ),
            PoseidonSlimefunItemStacks.PSI_ENTITY_CARD_SEA_COMMON.getItemId(),
            List.of(
                    EntityType.COD,
                    EntityType.SALMON,
                    EntityType.PUFFERFISH,
                    EntityType.TROPICAL_FISH,
                    EntityType.SQUID,
                    EntityType.GLOW_SQUID,
                    EntityType.TURTLE,
                    EntityType.DOLPHIN
            ),
            PoseidonSlimefunItemStacks.PSI_ENTITY_CARD_SEA_MONSTER.getItemId(),
            List.of(
                    EntityType.DROWNED,
                    EntityType.GUARDIAN,
                    EntityType.ELDER_GUARDIAN
            )
    );
    public static final List<EntityType> DEFAULT = Arrays.stream(getEntityTypes()).toList();

    @Override
    public void preRegister() {
        super.preRegister();
        addItemHandler(
                new BlockPlaceHandler(false) {
                    @Override
                    public void onPlayerPlace(@NotNull BlockPlaceEvent e) {
                        StorageCacheUtils.setData(e.getBlock().getLocation(), "auto", "false");
                    }
                }
        );
    }

    private void setAuto(Block b, boolean auto) {
        StorageCacheUtils.setData(b.getLocation(), "auto", auto ? "true" : "false");
    }

    private void toggleAuto(Block b) {
        setAuto(b, !getAuto(b));
    }

    private boolean getAuto(Block b) {
        boolean auto;
        try {
            auto = Boolean.parseBoolean(Objects.requireNonNull(StorageCacheUtils.getData(b.getLocation(), "auto")));
        } catch (NullPointerException ex) {
            StorageCacheUtils.setData(b.getLocation(), "auto", "false");
            auto = false;
        }
        return auto;
    }

    @Override
    protected void tick(Block b) {
        BlockMenu menu = BlockStorage.getInventory(b);
        List<EntityType> entityTypes = getCanMatch(menu.getItemInSlot(SLOT_SP));
        List<String> entities = new ArrayList<>();
        entities.add(ChatColor.GREEN + "可能召唤的生物: ");
        if (entityTypes.size() >= 6) {
            entities.add(String.join(", ", entityTypes.subList(0, 6).stream().map(EntityType::getName).toList()) + "等" + entityTypes.size() + "个.");
        }else{
            entities.add(String.join(", ", entityTypes.stream().map(EntityType::getName).toList()));
        }
        ItemStack control1 = new HikariItemStack.Builder(
                Material.GREEN_STAINED_GLASS_PANE,
                1,
                ChatColor.AQUA + "手动召唤",
                entities
        ).build().getItem();
        ItemStack control2 = new HikariItemStack.Builder(
                Material.PINK_STAINED_GLASS_PANE,
                1,
                ChatColor.AQUA + "自动召唤",
                List.of(ChatColor.GREEN + "自动召唤模式:" + (getAuto(b) ? "开" : "关"))
        ).build().getItem();
        menu.addItem(CONTROL_I, control1, (p, slot, item, action) -> {
            runTick(b);
            return false;
        });
        menu.addItem(CONTROL_II, control2, (p, slot, item, action) -> {
            toggleAuto(b);
            return false;
        });
        if (getAuto(b)) {
            runTick(b);
        }
    }

    private void runTick(Block b) {
        Location loc =  b.getLocation();
        BlockMenu menu = BlockStorage.getInventory(b);
        ItemStack consume = menu.getItemInSlot(INPUT_SLOTS[0]);
        if (consume == null || consume.getType() == Material.AIR) return;
        SlimefunItem sfItem = SlimefunItem.getByItem(consume);
        if (sfItem == null || !sfItem.getId().equals(PoseidonSlimefunItemStacks.PSI_ABYSS.getItemId())) return;
        if (!takeCharge(loc)) return;
        new BukkitRunnable() {
            @Override
            public void run() {
                EntityType entityType = matchEntityType(menu.getItemInSlot(SLOT_SP));
                if (entityType == null) return;
                if (entityType.getEntityClass() != null) {
                    loc.getWorld().spawn(loc.add(0.5, 1, 0.5), entityType.getEntityClass());
                }
            }
        }.runTask(PoseidonAddon.getInstance());
        menu.consumeItem(INPUT_SLOTS[0], 1);
    }

    @Override
    public ItemStack getProgressBar() {
        return null;
    }

    @Override
    public @NotNull String getMachineIdentifier() {
        return PoseidonSlimefunItemStacks.PSI_SUMMON_OF_THE_SEA.getItemId();
    }

    @Override
    public @NotNull String getInventoryTitle() {
        return PoseidonSlimefunItemStacks.PSI_SUMMON_OF_THE_SEA.getItemMeta().getDisplayName();
    }

    @Override
    public int getCapacity() {
        return 1024;
    }

    @Override
    public int getEnergyConsumption() {
        return 512;
    }

    @Override
    public int getSpeed() {
        return 1;
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
                "消耗渊(放置在上面的输入槽)进行一次召唤,生成随机生物",
                "可以使用生物定向卡(放置在下面的输入槽)缩小随机范围"
        );
    }

    @Override
    public int[] getInputSlots() {
        return INPUT_SLOTS;
    }

    @Override
    public int[] getOutputSlots() {
        return new int[0];
    }

    private EntityType matchEntityType(ItemStack item) {
        List<EntityType> canMatch = getCanMatch(item);
        Random random = new Random();
        return canMatch.get(random.nextInt(canMatch.size()));
    }

    private List<EntityType> getCanMatch(ItemStack item) {
        if (item == null || item.getType() == Material.AIR) {
            return DEFAULT;
        }
        SlimefunItem slimefunItem = SlimefunItem.getByItem(item);
        if (slimefunItem == null) {
            return DEFAULT;
        } else {
            return ENTITIES_ORIENT.getOrDefault(slimefunItem.getId(), DEFAULT);
        }
    }

    private static EntityType[] getEntityTypes() {
        return Arrays.stream(EntityType.values()).filter(entityType -> entityType.isSpawnable() && entityType.isAlive() && !BLACKED_ENTITY_TYPES.contains(entityType)).toArray(EntityType[]::new);
    }

    @Override
    public @NotNull EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CONSUMER;
    }
}
