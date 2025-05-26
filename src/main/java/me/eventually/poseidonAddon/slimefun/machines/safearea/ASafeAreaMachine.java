package me.eventually.poseidonAddon.slimefun.machines.safearea;

import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.eventually.hikarilib.itemstack.HikariItemStack;
import me.eventually.poseidonAddon.PoseidonAddon;
import me.eventually.poseidonAddon.registry.PoseidonSlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.RespawnAnchor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import world.bentobox.poseidon.listeners.AirEffect;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class ASafeAreaMachine extends AContainer {
    protected ASafeAreaMachine(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }
    private static final int[] INPUT_SLOTS = {10, 11, 15, 16};
    private static final int[] INPUT_SLOTS_DEEPWATER = {10, 11};
    private static final int[] INPUT_SLOTS_HIGHSTEAM = {15, 16};
    private static final int[] OUTPUT_SLOTS = {};
    private static final int[] BORDER = {4, 13, 22, 27, 28, 27, 28, 29, 30, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44};
    private static final int[] BORDER_IN = {0, 1, 2, 3, 9, 12, 18, 19, 20, 21};
    private static final int[] BORDER_OUT = {5, 6, 7, 8, 14, 17, 23, 24, 25, 26};
    private static final int PROGRESS_BAR = 31;
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
            ChatColor.RED + "无能量!",
            List.of()
    ).build().getItem();
    public abstract int getRadius();

    @Override
    public int getCapacity() {
        return 1;
    }

    @Override
    public abstract @NotNull String getInventoryTitle();

    @Override
    public void preRegister() {
        super.preRegister();
    }

    @Override
    protected void constructMenu(BlockMenuPreset preset) {
        preset.setSize(9 * 5);
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

    protected List<String> getDescription() {
        return List.of(
                "蓝色区域为输入槽I, 红色区域为输入槽II",
                "以下机制无需电力连接, 每粘液刻自动执行一次: ",
                "当能量拥有至少1点时,每粘液刻给予附近" + ChatColor.AQUA + getRadius() + ChatColor.GRAY + "格内玩家补充氧气,并给予药水效果,消耗1点能量.",
                "当输入槽I含有至少1x深水, 输入槽II包含至少1x极汽时,消耗1x深水,1x极汽进行1次" + ChatColor.GOLD + "充能",
                "单次" + ChatColor.GOLD + "充能" + ChatColor.GRAY + "回复能量" + getSingletonCharge() + "点"
        );
    }

    @Override
    public int getSpeed() {
        return 1;
    }

    @Override
    public ItemStack getProgressBar() {
        return null;
    }

    @Override
    public int getEnergyConsumption() {
        return 1;
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
    protected void tick(Block b) {
        long energy = getEnergy(b);
        BlockMenu menu = BlockStorage.getInventory(b);
        ItemStack statusItemWorking = new HikariItemStack.Builder(
                Material.GREEN_STAINED_GLASS_PANE,
                1,
                ChatColor.WHITE + "状态",
                List.of(
                        ChatColor.GRAY + "状态：" + ChatColor.GREEN + "运行中",
                        ChatColor.GRAY + "半径：" + ChatColor.GREEN + getRadius() + "格",
                        ChatColor.GRAY + "能量：" + ChatColor.GREEN + energy
                )
        ).build().getItem();
        consume(b);
        if (energy <= 0) {
            menu.addItem(PROGRESS_BAR, PROGRESS_DEFAULT, (p, slot, item, action) -> false);
        } else {
            menu.addItem(PROGRESS_BAR, statusItemWorking, (p, slot, item, action) -> false);
            runTick(b);
            setEnergy(b, getEnergy(b) - 1);
        }
        new BukkitRunnable() {
            @Override
            public void run() {
                setCharged(b.getLocation(), (energy > 0));
            }
        }.runTask(PoseidonAddon.getInstance());
    }

    private long getEnergy(Block b) {
        long energy;
        try {
            energy = Long.parseLong(Objects.requireNonNull(StorageCacheUtils.getData(b.getLocation(), "energy")));
        } catch (NumberFormatException | NullPointerException ex) {
            StorageCacheUtils.setData(b.getLocation(), "energy", "0");
            energy = 0;
        }
        return energy;
    }

    private void setEnergy(Block b, long progress) {
        StorageCacheUtils.setData(b.getLocation(), "energy", String.valueOf(progress));
    }

    private void addEnergy(Block b, long energy) {
        setEnergy(b, getEnergy(b) + energy);
    }


    private void consume(Block b) {
        BlockMenu menu = BlockStorage.getInventory(b);
        boolean deepwater = false;
        boolean highsteam = false;
        int deepwater_slot = -1;
        int highsteam_slot = -1;

        for (int slot : INPUT_SLOTS_DEEPWATER) {
            ItemStack item = menu.getItemInSlot(slot);
            if (item != null && item.getType() != Material.AIR) {
                SlimefunItem sfItem = SlimefunItem.getByItem(item);
                if (sfItem != null && sfItem.getId().equals(PoseidonSlimefunItems.PSI_DEEP_WATER.getId())) {
                    deepwater = true;
                    deepwater_slot = slot;
                    break;
                }
            }
        }

        for (int slot : INPUT_SLOTS_HIGHSTEAM) {
            ItemStack item = menu.getItemInSlot(slot);
            if (item != null && item.getType() != Material.AIR) {
                SlimefunItem sfItem = SlimefunItem.getByItem(item);
                if (sfItem != null && sfItem.getId().equals(PoseidonSlimefunItems.PSI_HIGH_STEAM.getId())) {
                    highsteam = true;
                    highsteam_slot = slot;
                    break;
                }
            }
        }
        if (deepwater && highsteam && deepwater_slot != -1 && highsteam_slot != -1) {
            menu.consumeItem(deepwater_slot);
            menu.consumeItem(highsteam_slot);
            addEnergy(b, getSingletonCharge());
        }
    }

    protected abstract long getSingletonCharge();

    private void runTick(@NotNull Block b) {
        Location loc = b.getLocation();
        int radius  = getRadius();
        final List<Player> players = new ArrayList<>();
        Bukkit.getServer().getOnlinePlayers().forEach(player -> {
            if (player.getWorld() != loc.getWorld()) return;
            if (player.getLocation().distance(loc) < radius) {
                players.add(player);
            }
        });
        new BukkitRunnable() {
            @Override
            public void run() {
                AirEffect.protectPlayers(players.toArray(new Player[0]));
                players.forEach(player -> {
                    player.addPotionEffect(
                            new PotionEffect(
                                    PotionEffectType.NIGHT_VISION,
                                    300,
                                    3
                            )
                    );
                    player.addPotionEffect(
                            new PotionEffect(
                                    PotionEffectType.CONDUIT_POWER,
                                    300,
                                    2
                            )
                    );
                    player.addPotionEffect(
                            new PotionEffect(
                                    PotionEffectType.INSTANT_HEALTH,
                                    300,
                                    1
                            )
                    );
                    player.addPotionEffect(
                            new PotionEffect(
                                    PotionEffectType.SPEED,
                                    300,
                                    2
                            )
                    );
                    player.addPotionEffect(
                            new PotionEffect(
                                    PotionEffectType.HASTE,
                                    300,
                                    3
                            )
                    );
                    player.setRemainingAir(200);
                });
                b.getWorld().spawnParticle(
                        Particle.SONIC_BOOM,
                        loc.add(0.5,1.5, 0.5),
                        1
                );
            }
        }.runTask(PoseidonAddon.getInstance());

    }

    @Override
    public @NotNull EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.NONE;
    }

    private void setCharged(Location l, boolean charged) {
        Block b = l.getBlock();
        if (b.getType() != Material.RESPAWN_ANCHOR) return;
        RespawnAnchor anchor = (RespawnAnchor) b.getBlockData();
        if (charged) {
            anchor.setCharges(anchor.getMaximumCharges());
        } else {
            anchor.setCharges(0);
        }
        b.setBlockData(anchor);
        b.tick();
    }
}
