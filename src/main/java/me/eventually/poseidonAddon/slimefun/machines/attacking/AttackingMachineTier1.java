package me.eventually.poseidonAddon.slimefun.machines.attacking;

import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.damage.DamageSource;
import org.bukkit.damage.DamageType;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public abstract class AAttackingMachine extends AContainer {
    protected AAttackingMachine(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

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
            EntityType.FALLING_BLOCK
    );


    @Override
    public ItemStack getProgressBar() {
        return null;
    }

    @Override
    public abstract @NotNull String getMachineIdentifier();

    @Override
    protected void constructMenu(BlockMenuPreset preset) {
        return;
    }

    @Override
    public int getCapacity() {
        return 4096;
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
    public int[] getInputSlots() {
        return new int[0];
    }

    @Override
    public int[] getOutputSlots() {
        return new int[0];
    }

    @Override
    public List<ItemStack> getDisplayRecipes() {
        return List.of();
    }

    @Override
    protected void tick(Block b) {
        long progress = getProgress(b);
        if (progress == 0) {
            runAttack(b);
            setProgress(b, progress + getCountdown());
        }
        else {
            setProgress(b, progress - 1);
        }
    }

    protected abstract long getCountdown();

    private void runAttack(Block b) {
        Location loc = b.getLocation();
        loc.getNearbyLivingEntities(3, 3,3).forEach(entity -> {
            if (BLACKED_ENTITY_TYPES.contains(entity.getType())) return;
            EntityDamageByBlockEvent event = new EntityDamageByBlockEvent(
                    b,
                    b.getState(),
                    entity,
                    EntityDamageEvent.DamageCause.CUSTOM,
                    DamageSource.builder(DamageType.GENERIC).build(),
                    getDamage()
            );
            if (event.callEvent()){
                entity.setHealth(Math.max(entity.getHealth() - getDamage(), 0));
            }
        });
    }

    protected abstract int getDamage();

    private long getProgress(Block b) {
        long progress;
        try {
            progress = Long.parseLong(Objects.requireNonNull(StorageCacheUtils.getData(b.getLocation(), "progress")));
        } catch (NumberFormatException | NullPointerException ex) {
            StorageCacheUtils.setData(b.getLocation(), "progress", "0");
            progress = 0;
        }
        return progress;
    }
    private void setProgress(Block b, long progress) {
        StorageCacheUtils.setData(b.getLocation(), "progress", String.valueOf(progress));
    }

    @Override
    public abstract @NotNull String getInventoryTitle();

    @Override
    public @NotNull EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CONSUMER;
    }
}