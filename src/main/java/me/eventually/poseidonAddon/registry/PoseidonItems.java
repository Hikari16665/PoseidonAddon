package me.eventually.poseidonAddon.registry;

import me.eventually.hikarilib.itemstack.HikariItemStack;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@SuppressWarnings("deprecation")
public class PoseidonItems {
    static ItemStack PSI_GROUP_GLOBAL = new HikariItemStack.Builder(
            Material.WRITTEN_BOOK,
            1,
            getObfuscatedString(ChatColor.BLUE + "海洋生存日记"),
            List.of()
    ).build().getItem();

    static ItemStack PSI_GROUP_I = new HikariItemStack.Builder(
            Material.SEA_LANTERN,
            1,
            getObfuscatedString(ChatColor.BLUE + "Vol.1 沉没的诠释"),
            List.of()
    ).build().getItem();

    static ItemStack PSI_GROUP_II = new HikariItemStack.Builder(
            Material.PRISMARINE,
            1,
            getObfuscatedString(ChatColor.AQUA + "Vol.2 失落的往昔"),
            List.of()
    ).build().getItem();

    static ItemStack PSI_GROUP_III = new HikariItemStack.Builder(
            Material.HEART_OF_THE_SEA,
            1,
            getObfuscatedString(ChatColor.WHITE + "Vol.3 深海之息至死不渝"),
            List.of()
    ).build().getItem();

    static ItemStack PSI_WATER = HikariItemStack.getSkull(
            "cddaf2e94453f530861e05a00d434ae4c01aafd0499ff2c24cbe1bf3499f2e40",
            getObfuscatedString(ChatColor.BLUE + "水"),
            List.of(ChatColor.BLUE + "大海啊，你全是水")
    ).getItem();

    static ItemStack PSI_STEAM = new HikariItemStack.Builder(
            Material.STRING,
            1,
            getObfuscatedString("汽"),
            List.of(ChatColor.WHITE + "简易蒸馏？！")
    ).build().getItem();

    static ItemStack PSI_FLUID = new HikariItemStack.Builder(
            Material.GLOW_INK_SAC,
            1,
            getObfuscatedString(ChatColor.AQUA + "流"),
            List.of(ChatColor.AQUA + "洋流的力量于你手中.")
    ).build().getItem();

    static ItemStack PSI_SAPPHIRE_I = HikariItemStack.getSkull(
            "36161daa3589ec9c8187459ac36fd4dd2646c040678d3bfacb72a2210c6c801c",
            getObfuscatedString(ChatColor.BLUE + "一重压缩蓝宝石"),
            List.of(ChatColor.BLUE + "经过压缩的蓝宝石,力量更纯粹了.")
    ).getItem();
    static ItemStack PSI_SAPPHIRE_II = HikariItemStack.getSkull(
            "957cfa9c75ba584645ee2af6d9867d767ddea4667cdfc72dc1061dd1975ca7d0",
            getObfuscatedString(ChatColor.BLUE + "二重压缩蓝宝石"),
            List.of(ChatColor.BLUE + "已然找不到任何瑕疵的材料...?")
    ).getItem();
    static ItemStack PSI_SAPPHIRE_III = HikariItemStack.getSkull(
            "150649626c4101352c5995c53b48bff60a938212b7ce902415feb76ea273b35f",
            getObfuscatedString(ChatColor.BLUE + "蓝晶"),
            List.of(ChatColor.BLUE + "对海洋使用精炼吧!")
    ).getItem();
    static ItemStack PSI_ABYSS = HikariItemStack.getSkull(
            "77d8ca152aab772d6019ffe8b029d6b4ffa5c61cbc53a52ec20d65120ac8345f",
            getObfuscatedString(ChatColor.RED + "渊"),
            List.of(ChatColor.RED + "深不见底!")
    ).getItem();
    static ItemStack PSI_DEEP_WATER = HikariItemStack.getSkull(
            "a2e5bf0ddf6c66b77eca23f8992f8e209b8b8ca42f023b62fd8fffe8043fcfbd",
            getObfuscatedString(ChatColor.DARK_PURPLE + "深水"),
            List.of(ChatColor.DARK_PURPLE + "冻洋三尺!")
    ).getItem();
    static ItemStack PSI_HIGH_STEAM = HikariItemStack.getSkull(
            "b93a20db9f1f00838c1de68aeb9605c02f71a56988809c5c01817cdbcde0b6b1",
            getObfuscatedString(ChatColor.WHITE + "极汽"),
            List.of(ChatColor.WHITE + "云之精华!")
    ).getItem();
    static ItemStack PSI_UNSTABLE_PRESSURE_MACHINE = new HikariItemStack.Builder(
            Material.BLAST_FURNACE,
            1,
            getObfuscatedString(ChatColor.GOLD + "深海不稳定压力机"),
            List.of(ChatColor.GOLD + "主打一个能跑就行?")
    ).build().getItem();
    static ItemStack PSI_WATER_GENERATOR = new HikariItemStack.Builder(
            Material.LIGHT_BLUE_GLAZED_TERRACOTTA,
            1,
            getObfuscatedString(ChatColor.BLUE + "简易水生成器"),
            List.of(ChatColor.BLUE + "生命之源也能量产?")
    ).build().getItem();
    static ItemStack PSI_STEAM_GENERATOR = new HikariItemStack.Builder(
            Material.WHITE_GLAZED_TERRACOTTA,
            1,
            getObfuscatedString(ChatColor.WHITE + "简易蒸汽生成器"),
            List.of(ChatColor.WHITE + "这能产生什么?")
    ).build().getItem();
    static ItemStack PSI_GUARD_FORCE_MACHINE_I = new HikariItemStack.Builder(
            Material.SMOKER,
            1,
            ChatColor.LIGHT_PURPLE + "安全机器·I",
            List.of(
                    ChatColor.BLUE + "结合了科技与魔法的力量，在水世界为人鱼们开拓一小片摇篮.",
                    ChatColor.BLUE + "范围: 8格"
            )
    ).build().getItem();
    static ItemStack PSI_GUARD_FORCE_MACHINE_II = new HikariItemStack.Builder(
            Material.SMOKER,
            1,
            ChatColor.LIGHT_PURPLE + "安全机器·II",
            List.of(
                    ChatColor.BLUE + "经过改良的安全机器可以生成更大的力场.",
                    ChatColor.BLUE + "范围: 32格"
            )
    ).build().getItem();
    static ItemStack PSI_GUARD_FORCE_MACHINE_III = new HikariItemStack.Builder(
            Material.SMOKER,
            1,
            ChatColor.LIGHT_PURPLE + "安全机器·III",
            List.of(
                    ChatColor.BLUE + "创造大片生存区的得力助手!",
                    ChatColor.BLUE + "范围: 96格"
            )
    ).build().getItem();

    private static String getObfuscatedString(String s) {
        return ChatColor.MAGIC + "x" + ChatColor.WHITE + s + ChatColor.MAGIC + "x";
    }
}
