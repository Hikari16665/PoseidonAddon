package me.eventually.poseidonAddon.registry;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.eventually.hikarilib.itemstack.HikariItemStack;
import me.eventually.poseidonAddon.PoseidonAddon;
import me.eventually.poseidonAddon.slimefun.item.PoseidonItem;
import me.eventually.poseidonAddon.slimefun.machines.attacking.AttackingMachineTier1;
import me.eventually.poseidonAddon.slimefun.machines.attacking.AttackingMachineTier2;
import me.eventually.poseidonAddon.slimefun.machines.attacking.AttackingMachineTier3;
import me.eventually.poseidonAddon.slimefun.machines.common.PoseidonUnstablePressureMachine;
import me.eventually.poseidonAddon.slimefun.machines.generator.ACommonGenerator;
import me.eventually.poseidonAddon.slimefun.machines.generator.PoseidonSteamGenerator;
import me.eventually.poseidonAddon.slimefun.machines.generator.PoseidonWaterGenerator;
import me.eventually.poseidonAddon.slimefun.machines.safearea.SafeAreaMachineTier1;
import me.eventually.poseidonAddon.slimefun.machines.safearea.SafeAreaMachineTier2;
import me.eventually.poseidonAddon.slimefun.machines.safearea.SafeAreaMachineTier3;
import me.eventually.poseidonAddon.slimefun.machines.special.OverwatchMachine;
import me.eventually.poseidonAddon.slimefun.machines.special.ProtectionForce;
import me.eventually.poseidonAddon.slimefun.machines.summon.SummonMachine;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PoseidonSlimefunItems {
    public static SlimefunItem PSI_WATER = new PoseidonItem(
            PoseidonGroups.PSI_STAGE_I,
            PoseidonSlimefunItemStacks.PSI_WATER,
            RecipeType.NULL,
            PoseidonRecipes.PSI_WATER_RECIPE
    );
    public static SlimefunItem PSI_STEAM = new PoseidonItem(
            PoseidonGroups.PSI_STAGE_I,
            PoseidonSlimefunItemStacks.PSI_STEAM,
            RecipeType.NULL,
            PoseidonRecipes.PSI_STEAM_RECIPE
    );
    public static SlimefunItem PSI_DSR = new PoseidonItem(
            PoseidonGroups.PSI_AUTHOR,
            PoseidonSlimefunItemStacks.PSI_DSR,
            RecipeType.NULL,
            new ItemStack[9]
    );
    public static SlimefunItem PSI_EVENTUALLY = new PoseidonItem(
            PoseidonGroups.PSI_AUTHOR,
            PoseidonSlimefunItemStacks.PSI_EVENTUALLY,
            RecipeType.NULL,
            new ItemStack[] {
                    null, null, null, null,
                    new HikariItemStack.Builder(
                            Material.BARRIER,
                            1,
                            ChatColor.LIGHT_PURPLE + "不是,哥们",
                            List.of(ChatColor.LIGHT_PURPLE + "想多了,这里不可以做作者头!")
                    ).build().getItem(),
                    null, null, null, null
            }
    );
    public static SlimefunItem PSI_SAPPHIRE_I = new PoseidonItem(
            PoseidonGroups.PSI_STAGE_I,
            PoseidonSlimefunItemStacks.PSI_SAPPHIRE_I,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_SAPPHIRE_I_RECIPE
    );
    public static SlimefunItem PSI_SAPPHIRE_II = new PoseidonItem(
            PoseidonGroups.PSI_STAGE_I,
            PoseidonSlimefunItemStacks.PSI_SAPPHIRE_II,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_SAPPHIRE_II_RECIPE
    );
    public static SlimefunItem PSI_SAPPHIRE_III = new PoseidonItem(
            PoseidonGroups.PSI_STAGE_I,
            PoseidonSlimefunItemStacks.PSI_SAPPHIRE_III,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_SAPPHIRE_III_RECIPE
    );
    public static SlimefunItem PSI_UNSTABLE_PRESSURE_MACHINE = new PoseidonUnstablePressureMachine(
            PoseidonGroups.PSI_STAGE_II,
            PoseidonSlimefunItemStacks.PSI_UNSTABLE_PRESSURE_MACHINE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_UNSTABLE_PRESSURE_MACHINE_RECIPE
    );
    public static SlimefunItem PSI_DEEP_WATER = new PoseidonItem(
            PoseidonGroups.PSI_STAGE_II,
            PoseidonSlimefunItemStacks.PSI_DEEP_WATER,
            RecipeType.NULL,
            PoseidonRecipes.PSI_DEEP_WATER_RECIPE
    );
    public static SlimefunItem PSI_HIGH_STEAM = new PoseidonItem(
            PoseidonGroups.PSI_STAGE_II,
            PoseidonSlimefunItemStacks.PSI_HIGH_STEAM,
            RecipeType.NULL,
            PoseidonRecipes.PSI_HIGH_STEAM_RECIPE
    );
    public static SlimefunItem PSI_ABYSS = new PoseidonItem(
            PoseidonGroups.PSI_STAGE_II,
            PoseidonSlimefunItemStacks.PSI_ABYSS,
            RecipeType.NULL,
            PoseidonRecipes.PSI_ABYSS_RECIPE
    );
    public static SlimefunItem PSI_PITY_OF_THE_SEA = new PoseidonItem(
            PoseidonGroups.PSI_STAGE_II,
            PoseidonSlimefunItemStacks.PSI_PITY_OF_THE_SEA,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_PITY_OF_THE_SEA_RECIPE
    );
    public static SlimefunItem PSI_FLUID = new PoseidonItem(
            PoseidonGroups.PSI_STAGE_II,
            PoseidonSlimefunItemStacks.PSI_FLUID,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_FLUID_RECIPE
    );
    public static SlimefunItem PSI_WATER_GENERATOR = new PoseidonWaterGenerator(
            PoseidonGroups.PSI_STAGE_II,
            PoseidonSlimefunItemStacks.PSI_WATER_GENERATOR,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_WATER_GENERATOR_RECIPE
    );
    public static SlimefunItem PSI_STEAM_GENERATOR = new PoseidonSteamGenerator(
            PoseidonGroups.PSI_STAGE_II,
            PoseidonSlimefunItemStacks.PSI_STEAM_GENERATOR,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_STEAM_GENERATOR_RECIPE
    );
    public static SlimefunItem PSI_GUARD_FORCE_MACHINE_I = new SafeAreaMachineTier1(
            PoseidonGroups.PSI_STAGE_III,
            PoseidonSlimefunItemStacks.PSI_GUARD_FORCE_MACHINE_I,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_GUARD_FORCE_MACHINE_I_RECIPE
    );
    public static SlimefunItem PSI_GUARD_FORCE_MACHINE_II = new SafeAreaMachineTier2(
            PoseidonGroups.PSI_STAGE_III,
            PoseidonSlimefunItemStacks.PSI_GUARD_FORCE_MACHINE_II,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_GUARD_FORCE_MACHINE_II_RECIPE
    );
    public static SlimefunItem PSI_GUARD_FORCE_MACHINE_III = new SafeAreaMachineTier3(
            PoseidonGroups.PSI_STAGE_III,
            PoseidonSlimefunItemStacks.PSI_GUARD_FORCE_MACHINE_III,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_GUARD_FORCE_MACHINE_III_RECIPE
    );
    public static SlimefunItem PSI_HEART_OF_THE_SEA_GENERATOR = new ACommonGenerator(
            PoseidonGroups.PSI_STAGE_III,
            PoseidonSlimefunItemStacks.PSI_HEART_OF_THE_SEA_GENERATOR,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_HEART_OF_THE_SEA_GENERATOR_RECIPE
    ){
        @Override
        public @NotNull String getMachineIdentifier() {
            return "PSI_HEART_OF_THE_SEA_GENERATOR";
        }
        @Override
        protected ItemStack getOutput() {
            return new ItemStack(Material.HEART_OF_THE_SEA);
        }
        @Override
        protected int getAmount() {
            return 1;
        }
    };
    public static SlimefunItem PSI_GLASS_GENERATOR = new ACommonGenerator(
            PoseidonGroups.PSI_STAGE_III,
            PoseidonSlimefunItemStacks.PSI_GLASS_GENERATOR,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_GLASS_GENERATOR_RECIPE
    ){
        @Override
        public @NotNull String getMachineIdentifier() {
            return "PSI_GLASS_GENERATOR";
        }
        @Override
        protected ItemStack getOutput() {
            return new ItemStack(Material.GLASS);
        }

        @Override
        protected int getAmount() {
            return 1;
        }
    };
    public static SlimefunItem PSI_ICE_GENERATOR = new ACommonGenerator(
            PoseidonGroups.PSI_STAGE_III,
            PoseidonSlimefunItemStacks.PSI_ICE_GENERATOR,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_ICE_GENERATOR_RECIPE
    ){
        @Override
        public @NotNull String getMachineIdentifier() {
            return "PSI_ICE_GENERATOR";
        }
        @Override
        protected ItemStack getOutput() {
            return new ItemStack(Material.ICE);
        }

        @Override
        protected int getAmount() {
            return 1;
        }
    };
    public static SlimefunItem PSI_WAVE = new PoseidonItem(
            PoseidonGroups.PSI_STAGE_II,
            PoseidonSlimefunItemStacks.PSI_WAVE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_WAVE_RECIPE
    );
    public static SlimefunItem PSI_NIGHT_WAVE = new PoseidonItem(
            PoseidonGroups.PSI_STAGE_II,
            PoseidonSlimefunItemStacks.PSI_NIGHT_WAVE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_NIGHT_WAVE_RECIPE
    );
    public static SlimefunItem PSI_PROTECTION_FORCE = new ProtectionForce(
            PoseidonGroups.PSI_STAGE_III,
            PoseidonSlimefunItemStacks.PSI_PROTECTION_FORCE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_PROTECTION_FORCE_RECIPE
    );
    public static SlimefunItem PSI_ENTITY_CARD_PIGLIN = new PoseidonItem(
            PoseidonGroups.PSI_STAGE_II,
            PoseidonSlimefunItemStacks.PSI_ENTITY_CARD_PIGLIN,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_ENTITY_CARD_PIGLIN_RECIPE
    );
    public static SlimefunItem PSI_ENTITY_CARD_OVERWORLD = new PoseidonItem(
            PoseidonGroups.PSI_STAGE_II,
            PoseidonSlimefunItemStacks.PSI_ENTITY_CARD_OVERWORLD,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_ENTITY_CARD_OVERWORLD_RECIPE
    );
    public static SlimefunItem PSI_ENTITY_CARD_SEA_COMMON = new PoseidonItem(
            PoseidonGroups.PSI_STAGE_II,
            PoseidonSlimefunItemStacks.PSI_ENTITY_CARD_SEA_COMMON,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_ENTITY_CARD_SEA_COMMON_RECIPE
    );
    public static SlimefunItem PSI_ENTITY_CARD_SEA_MONSTER = new PoseidonItem(
            PoseidonGroups.PSI_STAGE_II,
            PoseidonSlimefunItemStacks.PSI_ENTITY_CARD_SEA_MONSTER,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_ENTITY_CARD_SEA_MONSTER_RECIPE
    );
    public static SlimefunItem PSI_LUCK_OF_THE_SEA = new PoseidonItem(
            PoseidonGroups.PSI_STAGE_II,
            PoseidonSlimefunItemStacks.PSI_LUCK_OF_THE_SEA,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_LUCK_OF_THE_SEA_RECIPE
    );
    public static SlimefunItem PSI_CONVERGENT = new PoseidonItem(
            PoseidonGroups.PSI_STAGE_II,
            PoseidonSlimefunItemStacks.PSI_CONVERGENT,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_CONVERGENT_RECIPE
    );
    public static SlimefunItem PSI_FLOW = new PoseidonItem(
            PoseidonGroups.PSI_STAGE_II,
            PoseidonSlimefunItemStacks.PSI_FLOW,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_FLOW_RECIPE
    );
    public static SlimefunItem PSI_SURGE = new PoseidonItem(
            PoseidonGroups.PSI_STAGE_II,
            PoseidonSlimefunItemStacks.PSI_SURGE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_SURGE_RECIPE
    );
    public static SlimefunItem PSI_ATTACKING_MACHINE_I = new AttackingMachineTier1(
            PoseidonGroups.PSI_STAGE_III,
            PoseidonSlimefunItemStacks.PSI_ATTACKING_MACHINE_I,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_ATTACKING_MACHINE_I_RECIPE
    );
    public static SlimefunItem PSI_ATTACKING_MACHINE_II = new AttackingMachineTier2(
            PoseidonGroups.PSI_STAGE_III,
            PoseidonSlimefunItemStacks.PSI_ATTACKING_MACHINE_II,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_ATTACKING_MACHINE_II_RECIPE
    );
    public static SlimefunItem PSI_ATTACKING_MACHINE_III = new AttackingMachineTier3(
            PoseidonGroups.PSI_STAGE_III,
            PoseidonSlimefunItemStacks.PSI_ATTACKING_MACHINE_III,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_ATTACKING_MACHINE_III_RECIPE
    );
    public static SlimefunItem PSI_SUMMON_OF_THE_SEA = new SummonMachine(
            PoseidonGroups.PSI_STAGE_III,
            PoseidonSlimefunItemStacks.PSI_SUMMON_OF_THE_SEA,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_SUMMON_OF_THE_SEA_RECIPE
    );
    public static SlimefunItem PSI_OVERWATCH_MACHINE = new OverwatchMachine(
            PoseidonGroups.PSI_STAGE_III,
            PoseidonSlimefunItemStacks.PSI_OVERWATCH_MACHINE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            PoseidonRecipes.PSI_OVERWATCH_MACHINE_RECIPE
    );

    public static void register(PoseidonAddon addon) {
        PSI_WATER.register(addon);
        PSI_STEAM.register(addon);
        PSI_DSR.register(addon);
        PSI_EVENTUALLY.register(addon);
        PSI_SAPPHIRE_I.register(addon);
        PSI_SAPPHIRE_II.register(addon);
        PSI_SAPPHIRE_III.register(addon);
        PSI_UNSTABLE_PRESSURE_MACHINE.register(addon);
        PSI_OVERWATCH_MACHINE.register(addon);
        PSI_DEEP_WATER.register(addon);
        PSI_HIGH_STEAM.register(addon);
        PSI_ABYSS.register(addon);
        PSI_FLUID.register(addon);
        PSI_PITY_OF_THE_SEA.register(addon);
        PSI_WATER_GENERATOR.register(addon);
        PSI_STEAM_GENERATOR.register(addon);
//        PSI_GUARD_FORCE_MACHINE_I.register(addon);
//        PSI_GUARD_FORCE_MACHINE_II.register(addon);
//        PSI_GUARD_FORCE_MACHINE_III.register(addon);
        PSI_HEART_OF_THE_SEA_GENERATOR.register(addon);
        PSI_GLASS_GENERATOR.register(addon);
        PSI_ICE_GENERATOR.register(addon);
        PSI_WAVE.register(addon);
        PSI_NIGHT_WAVE.register(addon);
        PSI_CONVERGENT.register(addon);
        PSI_FLOW.register(addon);
        PSI_SURGE.register(addon);
        PSI_LUCK_OF_THE_SEA.register(addon);
        PSI_PROTECTION_FORCE.register(addon);
        PSI_ENTITY_CARD_PIGLIN.register(addon);
        PSI_ENTITY_CARD_OVERWORLD.register(addon);
        PSI_ENTITY_CARD_SEA_COMMON.register(addon);
        PSI_ENTITY_CARD_SEA_MONSTER.register(addon);
        PSI_ATTACKING_MACHINE_I.register(addon);
        PSI_ATTACKING_MACHINE_II.register(addon);
        PSI_ATTACKING_MACHINE_III.register(addon);
        PSI_SUMMON_OF_THE_SEA.register(addon);
    }
}
