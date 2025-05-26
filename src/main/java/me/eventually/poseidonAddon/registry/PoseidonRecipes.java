package me.eventually.poseidonAddon.registry;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.eventually.hikarilib.itemstack.HikariItemStack;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@SuppressWarnings("deprecation")
public class PoseidonRecipes {
    public static final ItemStack[] PSI_WATER_RECIPE = genTips(
            "在主世界破坏冰有33.33%概率获得"
    );
    public static final ItemStack[] PSI_STEAM_RECIPE = genTips(
            "在主世界手持火把破坏玻璃有33.33%概率获得"
    );
    public static final ItemStack[] PSI_SAPPHIRE_I_RECIPE = new ItemStack[] {
            SlimefunItems.SYNTHETIC_SAPPHIRE, SlimefunItems.SYNTHETIC_SAPPHIRE, SlimefunItems.SYNTHETIC_SAPPHIRE,
            SlimefunItems.SYNTHETIC_SAPPHIRE, SlimefunItems.SYNTHETIC_SAPPHIRE, SlimefunItems.SYNTHETIC_SAPPHIRE,
            SlimefunItems.SYNTHETIC_SAPPHIRE, SlimefunItems.SYNTHETIC_SAPPHIRE, SlimefunItems.SYNTHETIC_SAPPHIRE,
    };
    public static final ItemStack[] PSI_SAPPHIRE_II_RECIPE = new ItemStack[] {
            PoseidonSlimefunItemStacks.PSI_SAPPHIRE_I, PoseidonSlimefunItemStacks.PSI_SAPPHIRE_I, PoseidonSlimefunItemStacks.PSI_SAPPHIRE_I,
            PoseidonSlimefunItemStacks.PSI_SAPPHIRE_I, PoseidonSlimefunItemStacks.PSI_SAPPHIRE_I, PoseidonSlimefunItemStacks.PSI_SAPPHIRE_I,
            PoseidonSlimefunItemStacks.PSI_SAPPHIRE_I, PoseidonSlimefunItemStacks.PSI_SAPPHIRE_I, PoseidonSlimefunItemStacks.PSI_SAPPHIRE_I
    };
    public static final ItemStack[] PSI_SAPPHIRE_III_RECIPE = new ItemStack[] {
            PoseidonSlimefunItemStacks.PSI_WATER, PoseidonSlimefunItemStacks.PSI_WATER, PoseidonSlimefunItemStacks.PSI_WATER,
            PoseidonSlimefunItemStacks.PSI_WATER, PoseidonSlimefunItemStacks.PSI_SAPPHIRE_II, PoseidonSlimefunItemStacks.PSI_WATER,
            PoseidonSlimefunItemStacks.PSI_WATER, PoseidonSlimefunItemStacks.PSI_WATER, PoseidonSlimefunItemStacks.PSI_WATER,
    };
    public static final ItemStack[] PSI_FLUID_RECIPE = new ItemStack[] {
            PoseidonSlimefunItemStacks.PSI_DEEP_WATER, PoseidonSlimefunItemStacks.PSI_HIGH_STEAM, PoseidonSlimefunItemStacks.PSI_DEEP_WATER,
            PoseidonSlimefunItemStacks.PSI_HIGH_STEAM, PoseidonSlimefunItemStacks.PSI_SAPPHIRE_III, PoseidonSlimefunItemStacks.PSI_HIGH_STEAM,
            PoseidonSlimefunItemStacks.PSI_DEEP_WATER, PoseidonSlimefunItemStacks.PSI_HIGH_STEAM, PoseidonSlimefunItemStacks.PSI_DEEP_WATER
    };
    public static final ItemStack[] PSI_ABYSS_RECIPE = genTips(
            "在" + PoseidonSlimefunItemStacks.PSI_UNSTABLE_PRESSURE_MACHINE.getItemMeta().getDisplayName() + "中生成."
    );
    public static final ItemStack[] PSI_HIGH_STEAM_RECIPE = genTips(
            "在" + PoseidonSlimefunItemStacks.PSI_UNSTABLE_PRESSURE_MACHINE.getItemMeta().getDisplayName() + "中生成."
    );
    public static final ItemStack[] PSI_DEEP_WATER_RECIPE = genTips(
            "在" + PoseidonSlimefunItemStacks.PSI_UNSTABLE_PRESSURE_MACHINE.getItemMeta().getDisplayName() + "中生成."
    );
    public static final ItemStack[] PSI_WATER_GENERATOR_RECIPE = new ItemStack[] {
            SlimefunItems.FREEZER_3, PoseidonSlimefunItemStacks.PSI_DEEP_WATER, SlimefunItems.FREEZER_3,
            SlimefunItems.WATER_RUNE, PoseidonSlimefunItemStacks.PSI_PITY_OF_THE_SEA, SlimefunItems.WATER_RUNE,
            SlimefunItems.FREEZER_3, SlimefunItems.ADVANCED_CIRCUIT_BOARD, SlimefunItems.FREEZER_3
    };
    public static final ItemStack[] PSI_STEAM_GENERATOR_RECIPE = new ItemStack[] {
            SlimefunItems.ELECTRIC_FURNACE_3, PoseidonSlimefunItemStacks.PSI_HIGH_STEAM, SlimefunItems.ELECTRIC_FURNACE_3,
            SlimefunItems.AIR_RUNE, PoseidonSlimefunItemStacks.PSI_PITY_OF_THE_SEA, SlimefunItems.AIR_RUNE,
            SlimefunItems.ELECTRIC_FURNACE_3, SlimefunItems.ADVANCED_CIRCUIT_BOARD, SlimefunItems.ELECTRIC_FURNACE_3
    };
    public static final ItemStack[] PSI_GUARD_FORCE_MACHINE_I_RECIPE = new ItemStack[] {
            PoseidonSlimefunItemStacks.PSI_WATER, SlimefunItems.GPS_TRANSMITTER, PoseidonSlimefunItemStacks.PSI_STEAM,
            SlimefunItems.WATER_RUNE, SlimefunItems.PROGRAMMABLE_ANDROID, SlimefunItems.WATER_RUNE,
            PoseidonSlimefunItemStacks.PSI_STEAM, SlimefunItems.MEDIUM_CAPACITOR, PoseidonSlimefunItemStacks.PSI_WATER
    };
    public static final ItemStack[] PSI_GUARD_FORCE_MACHINE_II_RECIPE = new ItemStack[] {
            PoseidonSlimefunItemStacks.PSI_FLUID, SlimefunItems.GPS_TRANSMITTER_3,  PoseidonSlimefunItemStacks.PSI_FLUID,
            SlimefunItems.WATER_RUNE, SlimefunItems.PROGRAMMABLE_ANDROID_2, SlimefunItems.WATER_RUNE,
            PoseidonSlimefunItemStacks.PSI_FLUID, SlimefunItems.LARGE_CAPACITOR, PoseidonSlimefunItemStacks.PSI_FLUID
    };
    public static final ItemStack[] PSI_GUARD_FORCE_MACHINE_III_RECIPE = new ItemStack[] {
            PoseidonSlimefunItemStacks.PSI_ABYSS, SlimefunItems.GPS_TRANSMITTER_4,  PoseidonSlimefunItemStacks.PSI_ABYSS,
            SlimefunItems.WATER_RUNE, SlimefunItems.PROGRAMMABLE_ANDROID_3, SlimefunItems.WATER_RUNE,
            PoseidonSlimefunItemStacks.PSI_ABYSS, SlimefunItems.ENERGIZED_CAPACITOR, PoseidonSlimefunItemStacks.PSI_ABYSS
    };
    public static final ItemStack[] PSI_UNSTABLE_PRESSURE_MACHINE_RECIPE = new ItemStack[] {
            PoseidonSlimefunItemStacks.PSI_SAPPHIRE_III, SlimefunItems.POWER_CRYSTAL, PoseidonSlimefunItemStacks.PSI_SAPPHIRE_III,
            SlimefunItems.POWER_CRYSTAL, SlimefunItems.CARBON_PRESS_3, SlimefunItems.POWER_CRYSTAL,
            PoseidonSlimefunItemStacks.PSI_SAPPHIRE_III, SlimefunItems.POWER_CRYSTAL, PoseidonSlimefunItemStacks.PSI_SAPPHIRE_III
    };
    public static final ItemStack[] PSI_PITY_OF_THE_SEA_RECIPE = new ItemStack[] {
            PoseidonSlimefunItemStacks.PSI_DEEP_WATER, PoseidonSlimefunItemStacks.PSI_ABYSS, PoseidonSlimefunItemStacks.PSI_HIGH_STEAM,
            SlimefunItems.ESSENCE_OF_AFTERLIFE, new ItemStack(Material.HEART_OF_THE_SEA), SlimefunItems.ESSENCE_OF_AFTERLIFE,
            SlimefunItems.ENRICHED_NETHER_ICE, SlimefunItems.SOLAR_GENERATOR_4,  SlimefunItems.ENRICHED_NETHER_ICE
    };
    public static final ItemStack[] PSI_HEART_OF_THE_SEA_GENERATOR_RECIPE = genGenerator(
            new ItemStack(Material.HEART_OF_THE_SEA)
    );
    public static final ItemStack[] PSI_GLASS_GENERATOR_RECIPE = genGenerator(
            new ItemStack(Material.GLASS)
    );
    public static final ItemStack[] PSI_ICE_GENERATOR_RECIPE = genGenerator(
            new ItemStack(Material.ICE)
    );
    public static final ItemStack[] PSI_WAVE_RECIPE = genTips(
            "在" + PoseidonSlimefunItemStacks.PSI_OVERWATCH_MACHINE.getItemMeta().getDisplayName() + "中获取."
    );
    public static final ItemStack[] PSI_NIGHT_WAVE_RECIPE = genTips(
            "在" + PoseidonSlimefunItemStacks.PSI_OVERWATCH_MACHINE.getItemMeta().getDisplayName() + "中获取."
    );
    public static final ItemStack[] PSI_FLOW_RECIPE = genTips(
            "在" + PoseidonSlimefunItemStacks.PSI_OVERWATCH_MACHINE.getItemMeta().getDisplayName() + "中获取."
    );
    public static final ItemStack[] PSI_SURGE_RECIPE = genTips(
            "在" + PoseidonSlimefunItemStacks.PSI_OVERWATCH_MACHINE.getItemMeta().getDisplayName() + "中获取."
    );
    public static final ItemStack[] PSI_LUCK_OF_THE_SEA_RECIPE = new ItemStack[] {
            PoseidonSlimefunItemStacks.PSI_WAVE, PoseidonSlimefunItemStacks.PSI_FLOW, PoseidonSlimefunItemStacks.PSI_NIGHT_WAVE,
            SlimefunItems.PROGRAMMABLE_ANDROID, SlimefunItems.PROGRAMMABLE_ANDROID_2, SlimefunItems.PROGRAMMABLE_ANDROID_3,
            SlimefunItems.STRANGE_NETHER_GOO, SlimefunItems.RAINBOW_RUNE, SlimefunItems.NECROTIC_SKULL
    };

    public static final ItemStack[] PSI_SUMMON_OF_THE_SEA_RECIPE = new ItemStack[] {
            SlimefunItems.IRON_GOLEM_ASSEMBLER, SlimefunItems.NETHER_STAR_REACTOR, SlimefunItems.WITHER_ASSEMBLER,
            PoseidonSlimefunItemStacks.PSI_ABYSS, PoseidonSlimefunItemStacks.PSI_LUCK_OF_THE_SEA, PoseidonSlimefunItemStacks.PSI_ABYSS,
            PoseidonSlimefunItemStacks.PSI_ABYSS, PoseidonSlimefunItemStacks.PSI_CONVERGENT, PoseidonSlimefunItemStacks.PSI_ABYSS
    };
    public static final ItemStack[] PSI_OVERWATCH_MACHINE_RECIPE = new ItemStack[] {
            PoseidonSlimefunItemStacks.PSI_ABYSS, SlimefunItems.GPS_TRANSMITTER_4, PoseidonSlimefunItemStacks.PSI_ABYSS,
            PoseidonSlimefunItemStacks.PSI_PITY_OF_THE_SEA, SlimefunItems.NETHER_STAR_REACTOR, PoseidonSlimefunItemStacks.PSI_PITY_OF_THE_SEA,
            PoseidonSlimefunItemStacks.PSI_ABYSS, SlimefunItems.PROGRAMMABLE_ANDROID_3, PoseidonSlimefunItemStacks.PSI_ABYSS
    };
    public static final ItemStack[] PSI_ATTACKING_MACHINE_I_RECIPE = new ItemStack[] {
            PoseidonSlimefunItemStacks.PSI_WATER, new ItemStack(Material.TRIDENT),  PoseidonSlimefunItemStacks.PSI_STEAM,
            SlimefunItems.WATER_RUNE, SlimefunItems.PROGRAMMABLE_ANDROID, SlimefunItems.WATER_RUNE,
            PoseidonSlimefunItemStacks.PSI_STEAM, SlimefunItems.STEEL_MULTI_TOOL, PoseidonSlimefunItemStacks.PSI_WATER
    };
    public static final ItemStack[] PSI_ATTACKING_MACHINE_II_RECIPE = new ItemStack[] {
            PoseidonSlimefunItemStacks.PSI_FLUID, new ItemStack(Material.TOTEM_OF_UNDYING), PoseidonSlimefunItemStacks.PSI_FLUID,
            SlimefunItems.WATER_RUNE, SlimefunItems.PROGRAMMABLE_ANDROID_2, SlimefunItems.WATER_RUNE,
            PoseidonSlimefunItemStacks.PSI_FLUID, SlimefunItems.REINFORCED_ALLOY_MULTI_TOOL, PoseidonSlimefunItemStacks.PSI_FLUID
    };
    public static final ItemStack[] PSI_ATTACKING_MACHINE_III_RECIPE = new ItemStack[] {
            PoseidonSlimefunItemStacks.PSI_ABYSS, SlimefunItems.SOULBOUND_ELYTRA, PoseidonSlimefunItemStacks.PSI_ABYSS,
            SlimefunItems.WATER_RUNE, SlimefunItems.PROGRAMMABLE_ANDROID_3, SlimefunItems.WATER_RUNE,
            PoseidonSlimefunItemStacks.PSI_ABYSS,  SlimefunItems.CARBONADO_MULTI_TOOL, PoseidonSlimefunItemStacks.PSI_ABYSS
    };
    public static final ItemStack[] PSI_CONVERGENT_RECIPE = new ItemStack[] {
            SlimefunItems.TALISMAN_WIZARD, SlimefunItems.TALISMAN_WHIRLWIND, SlimefunItems.TALISMAN_WIZARD,
            SlimefunItems.TALISMAN_WARRIOR,SlimefunItems.TALISMAN_TRAVELLER, SlimefunItems.TALISMAN_CAVEMAN,
            SlimefunItems.TALISMAN_FIRE, SlimefunItems.TALISMAN_ANGEL, SlimefunItems.TALISMAN_WATER
    };
    public static final ItemStack[] PSI_PROTECTION_FORCE_RECIPE = new ItemStack[] {
            SlimefunItems.WITHER_PROOF_GLASS, PoseidonSlimefunItemStacks.PSI_CONVERGENT, SlimefunItems.WITHER_PROOF_GLASS,
            PoseidonSlimefunItemStacks.PSI_ABYSS, PoseidonSlimefunItemStacks.PSI_LUCK_OF_THE_SEA, PoseidonSlimefunItemStacks.PSI_ABYSS,
            SlimefunItems.WITHER_PROOF_GLASS, PoseidonSlimefunItemStacks.PSI_CONVERGENT, SlimefunItems.WITHER_PROOF_GLASS
    };
    public static final ItemStack[] PSI_ENTITY_CARD_PIGLIN_RECIPE = new ItemStack[] {
            PoseidonSlimefunItemStacks.PSI_ABYSS, SlimefunItems.LAVA_CRYSTAL, PoseidonSlimefunItemStacks.PSI_ABYSS,
            SlimefunItems.FIRE_RUNE, PoseidonSlimefunItemStacks.PSI_PITY_OF_THE_SEA, SlimefunItems.FIRE_RUNE,
            PoseidonSlimefunItemStacks.PSI_ABYSS, SlimefunItems.LAVA_CRYSTAL, PoseidonSlimefunItemStacks.PSI_ABYSS
    };
    public static final ItemStack[] PSI_ENTITY_CARD_OVERWORLD_RECIPE = new ItemStack[] {
            PoseidonSlimefunItemStacks.PSI_ABYSS, new ItemStack(Material.BONE), PoseidonSlimefunItemStacks.PSI_ABYSS,
            new ItemStack(Material.ROTTEN_FLESH), PoseidonSlimefunItemStacks.PSI_PITY_OF_THE_SEA, new ItemStack(Material.STRING),
            PoseidonSlimefunItemStacks.PSI_ABYSS, new ItemStack(Material.GUNPOWDER), PoseidonSlimefunItemStacks.PSI_ABYSS
    };
    public static final ItemStack[] PSI_ENTITY_CARD_SEA_COMMON_RECIPE = new ItemStack[] {
            PoseidonSlimefunItemStacks.PSI_ABYSS, new ItemStack(Material.HEART_OF_THE_SEA), PoseidonSlimefunItemStacks.PSI_ABYSS,
            SlimefunItems.WATER_RUNE, PoseidonSlimefunItemStacks.PSI_PITY_OF_THE_SEA, SlimefunItems.WATER_RUNE,
            PoseidonSlimefunItemStacks.PSI_ABYSS, new ItemStack(Material.HEART_OF_THE_SEA), PoseidonSlimefunItemStacks.PSI_ABYSS
    };
    public static final ItemStack[] PSI_ENTITY_CARD_SEA_MONSTER_RECIPE = new ItemStack[] {
            PoseidonSlimefunItemStacks.PSI_ABYSS, new ItemStack(Material.TRIDENT),  PoseidonSlimefunItemStacks.PSI_ABYSS,
            new ItemStack(Material.SEA_LANTERN), PoseidonSlimefunItemStacks.PSI_PITY_OF_THE_SEA, new ItemStack(Material.SEA_LANTERN),
            PoseidonSlimefunItemStacks.PSI_ABYSS, new ItemStack(Material.TRIDENT), PoseidonSlimefunItemStacks.PSI_ABYSS
    };


    private static ItemStack[] genTips(String... tips) {
        if (tips.length < 1 || tips.length > 9) {
            throw new UnsupportedOperationException("Incorrect tips length.");
        }
        ItemStack[] tipsItems = new ItemStack[tips.length];
        for (int i = 0; i < tips.length; i++) {
            ItemStack tip = new HikariItemStack.Builder(
                    Material.PAPER,
                    i + 1,
                    ChatColor.WHITE + "提示",
                    List.of(ChatColor.GRAY + tips[i])
            ).build().getItem();
            tipsItems[i] = tip;
        }
        return tipsItems;
    }
    @Contract(value = "_ -> new", pure = true)
    private static ItemStack @NotNull [] genGenerator(ItemStack item) {
        return new ItemStack[] {
                PoseidonSlimefunItemStacks.PSI_DEEP_WATER, PoseidonSlimefunItemStacks.PSI_PITY_OF_THE_SEA, PoseidonSlimefunItemStacks.PSI_DEEP_WATER,
                PoseidonSlimefunItemStacks.PSI_FLUID, item, PoseidonSlimefunItemStacks.PSI_FLUID,
                PoseidonSlimefunItemStacks.PSI_HIGH_STEAM, PoseidonSlimefunItemStacks.PSI_FLUID, PoseidonSlimefunItemStacks.PSI_HIGH_STEAM
        };
    }
}
