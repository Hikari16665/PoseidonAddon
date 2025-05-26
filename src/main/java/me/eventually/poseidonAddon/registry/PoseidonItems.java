package me.eventually.poseidonAddon.registry;

import me.eventually.hikarilib.itemstack.HikariItemStack;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@SuppressWarnings("deprecation")
public class PoseidonItems {
    private static final String SUFFIX_ITEM = ChatColor.AQUA + "浪涌渊 " + ChatColor.GOLD + "物品";
    private static final String SUFFIX_MACHINE = ChatColor.AQUA + "浪涌渊 " + ChatColor.GOLD + "机制机器";
    private static final String SUFFIX_GENERATOR = ChatColor.AQUA + "浪涌渊 " + ChatColor.GOLD + "生成器";

    public static final ItemStack PSI_GROUP_GLOBAL = new HikariItemStack.Builder(
            Material.WRITTEN_BOOK,
            1,
            getObfuscatedString(ChatColor.BLUE + "海洋生存日记"),
            List.of()
    ).build().getItem();

    public static final ItemStack PSI_GROUP_AUTHOR = HikariItemStack.getSkull(
            "92ee350a494e5bd76649734da52c2ab9c5bab2451a5b09eed46b10b8de174080",
            ChatColor.GREEN + "作者名单",
            List.of()
    ).getItem();

    public static final ItemStack PSI_GROUP_I = new HikariItemStack.Builder(
            Material.SEA_LANTERN,
            1,
            getObfuscatedString(ChatColor.BLUE + "Vol.1 沉没的诠释"),
            List.of()
    ).build().getItem();

    public static final ItemStack PSI_GROUP_II = new HikariItemStack.Builder(
            Material.PRISMARINE,
            1,
            getObfuscatedString(ChatColor.AQUA + "Vol.2 失落的往昔"),
            List.of()
    ).build().getItem();

    public static final ItemStack PSI_GROUP_III = new HikariItemStack.Builder(
            Material.HEART_OF_THE_SEA,
            1,
            getObfuscatedString(ChatColor.WHITE + "Vol.3 深海之息至死不渝"),
            List.of()
    ).build().getItem();

    public static final ItemStack PSI_WATER = HikariItemStack.getSkull(
            "cddaf2e94453f530861e05a00d434ae4c01aafd0499ff2c24cbe1bf3499f2e40",
            getObfuscatedString(ChatColor.BLUE + "水"),
            List.of(ChatColor.BLUE + "大海啊，你全是水")
    ).getItem();

    public static final ItemStack PSI_STEAM = new HikariItemStack.Builder(
            Material.STRING,
            1,
            getObfuscatedString("汽"),
            List.of(ChatColor.WHITE + "简易蒸馏？！")
    ).build().getItem();

    public static final ItemStack PSI_FLUID = new HikariItemStack.Builder(
            Material.GLOW_INK_SAC,
            1,
            getObfuscatedString(ChatColor.AQUA + "流"),
            List.of(ChatColor.AQUA + "洋流的力量于你手中.")
    ).build().getItem();

    public static final ItemStack PSI_DSR = HikariItemStack.getSkull(
            "841b91c5205bcc64e7f848e5db386990fb1cd5173f330f5d1439618563e7c10b",
            ChatColor.GOLD + "梦之谷服务器独占",
            List.of(ChatColor.GOLD + "玩法独占附属,谨防抄袭!")
    ).getItem();

    public static final ItemStack PSI_EVENTUALLY = HikariItemStack.getSkull(
            "7864744a54d7717e661a3f438e6851ca5ca75adf67ee957f22aa483a5e79eb14",
            ChatColor.LIGHT_PURPLE + "Eventually!",
            List.of(ChatColor.GOLD + "本附属作者!")
    ).getItem();

    public static final ItemStack PSI_SAPPHIRE_I = HikariItemStack.getSkull(
            "36161daa3589ec9c8187459ac36fd4dd2646c040678d3bfacb72a2210c6c801c",
            getObfuscatedString(ChatColor.BLUE + "一重压缩蓝宝石"),
            List.of(ChatColor.BLUE + "经过压缩的蓝宝石,力量更纯粹了.")
    ).getItem();
    public static final ItemStack PSI_SAPPHIRE_II = HikariItemStack.getSkull(
            "957cfa9c75ba584645ee2af6d9867d767ddea4667cdfc72dc1061dd1975ca7d0",
            getObfuscatedString(ChatColor.BLUE + "二重压缩蓝宝石"),
            List.of(ChatColor.BLUE + "已然找不到任何瑕疵的材料...?")
    ).getItem();
    public static final ItemStack PSI_SAPPHIRE_III = HikariItemStack.getSkull(
            "150649626c4101352c5995c53b48bff60a938212b7ce902415feb76ea273b35f",
            getObfuscatedString(ChatColor.BLUE + "蓝晶"),
            List.of(ChatColor.BLUE + "对海洋使用精炼吧!")
    ).getItem();
    public static final ItemStack PSI_ABYSS = HikariItemStack.getSkull(
            "77d8ca152aab772d6019ffe8b029d6b4ffa5c61cbc53a52ec20d65120ac8345f",
            getObfuscatedString(ChatColor.RED + "渊"),
            List.of(ChatColor.RED + "深不见底!")
    ).getItem();
    public static final ItemStack PSI_DEEP_WATER = HikariItemStack.getSkull(
            "a2e5bf0ddf6c66b77eca23f8992f8e209b8b8ca42f023b62fd8fffe8043fcfbd",
            getObfuscatedString(ChatColor.DARK_PURPLE + "深水"),
            List.of(ChatColor.DARK_PURPLE + "冻洋三尺!")
    ).getItem();
    public static final ItemStack PSI_HIGH_STEAM = HikariItemStack.getSkull(
            "b93a20db9f1f00838c1de68aeb9605c02f71a56988809c5c01817cdbcde0b6b1",
            getObfuscatedString(ChatColor.WHITE + "极汽"),
            List.of(ChatColor.WHITE + "云之精华!")
    ).getItem();
    public static final ItemStack PSI_UNSTABLE_PRESSURE_MACHINE = new HikariItemStack.Builder(
            Material.BLAST_FURNACE,
            1,
            ChatColor.GOLD + "深海不稳定压力机",
            List.of(ChatColor.GOLD + "主打一个能跑就行?", SUFFIX_MACHINE)
    ).build().getItem();
    public static final ItemStack PSI_WATER_GENERATOR = new HikariItemStack.Builder(
            Material.LIGHT_BLUE_GLAZED_TERRACOTTA,
            1,
            getObfuscatedString(ChatColor.BLUE + "简易水生成器"),
            List.of(ChatColor.BLUE + "生命之源也能量产?", SUFFIX_GENERATOR)
    ).build().getItem();
    public static final ItemStack PSI_STEAM_GENERATOR = new HikariItemStack.Builder(
            Material.WHITE_GLAZED_TERRACOTTA,
            1,
            getObfuscatedString(ChatColor.WHITE + "简易蒸汽生成器"),
            List.of(ChatColor.WHITE + "小心烫伤!", SUFFIX_GENERATOR)
    ).build().getItem();
    public static final ItemStack PSI_GUARD_FORCE_MACHINE_I = new HikariItemStack.Builder(
            Material.RESPAWN_ANCHOR,
            1,
            ChatColor.LIGHT_PURPLE + "安全区力场·I",
            List.of(
                    ChatColor.AQUA + "结合了科技与魔法的力量，在水世界为人鱼们开拓一小片摇篮.",
                    ChatColor.AQUA + "范围内无视氧气与呼吸限制.",
                    ChatColor.GREEN + "范围: 8格",
                    SUFFIX_MACHINE
            )
    ).build().getItem();
    public static final ItemStack PSI_GUARD_FORCE_MACHINE_II = new HikariItemStack.Builder(
            Material.RESPAWN_ANCHOR,
            1,
            ChatColor.LIGHT_PURPLE + "安全区力场·II",
            List.of(
                    ChatColor.AQUA + "经过改良的机器可以生成更大更强的力场.",
                    ChatColor.AQUA + "范围内无视氧气与呼吸限制.",
                    ChatColor.GOLD + "范围: 32格",
                    SUFFIX_MACHINE
            )
    ).build().getItem();
    public static final ItemStack PSI_GUARD_FORCE_MACHINE_III = new HikariItemStack.Builder(
            Material.RESPAWN_ANCHOR,
            1,
            ChatColor.LIGHT_PURPLE + "安全区力场·III",
            List.of(
                    ChatColor.AQUA + "创造大片生存区的得力助手!",
                    ChatColor.AQUA + "范围内无视氧气与呼吸限制.",
                    ChatColor.RED + "范围: 96格",
                    SUFFIX_MACHINE
            )
    ).build().getItem();
    public static final ItemStack PSI_PITY_OF_THE_SEA = new HikariItemStack.Builder(
            Material.HEART_OF_THE_SEA,
            1,
            ChatColor.GOLD + "海之垂怜",
            List.of(
                    ChatColor.AQUA + "海，万物之母，垂怜生命的空洞"
            )
    ).build().getItem();
    public static final ItemStack PSI_HEART_OF_THE_SEA_GENERATOR = HikariItemStack.getSkull(
            "ab00b34fe8b3c68a2ed5c55ac84bf11c17ee0270168bb33012d15aa574326ab",
            ChatColor.GOLD + "海洋之心生成器",
            List.of(
                    ChatColor.AQUA + "生成,创造",
                    SUFFIX_GENERATOR
            )
    ).getItem();
    public static final ItemStack PSI_GLASS_GENERATOR = HikariItemStack.getSkull(
            "817c1f220b4465be794c228a1860f48ca7c481b92c2d268117950a4d989e35a9",
            ChatColor.GOLD + "玻璃生成器",
            List.of(
                    ChatColor.AQUA + "生成,创造",
                    SUFFIX_GENERATOR
            )
    ).getItem();
    public static final ItemStack PSI_ICE_GENERATOR = HikariItemStack.getSkull(
            "a97ceba2731dff9868dca4f73048c40b449255d26117f2d3855c3754c30cf0aa",
            ChatColor.AQUA + "冰生成器",
            List.of(
                    ChatColor.AQUA + "生成,创造",
                    SUFFIX_GENERATOR
            )
    ).getItem();
    public static final ItemStack PSI_WAVE = HikariItemStack.getSkull(
            "70f8cd37fecd172cd700bdd10ece1ac52320609d084afd2020a56be8ae9d7104",
            ChatColor.DARK_AQUA + "潮",
            List.of(ChatColor.DARK_AQUA + "窒息向你涌来...")
    ).getItem();
    public static final ItemStack PSI_NIGHT_WAVE = HikariItemStack.getSkull(
            "20db898bc94ed65a442928a3632cd3db6173812df1aa5c4a9f159a1c537ded",
            ChatColor.DARK_AQUA + "汐",
            List.of(ChatColor.DARK_AQUA + "黑暗向你涌来...")
    ).getItem();
    public static final ItemStack PSI_SURGE = HikariItemStack.getSkull(
            "e13f9156998b87b4eb022c229a8007b7b9012f8a5ca7b9180e8098b6a86fe850",
            ChatColor.YELLOW + "涌",
            List.of(ChatColor.YELLOW + "于是万物向上升腾.")
    ).getItem();
    public static final ItemStack PSI_LUCK_OF_THE_SEA = HikariItemStack.getSkull(
            "794507ffb3d877ff725479f3259d922a84bd4985b0f3e034c6d69b4aba41a044",
            ChatColor.LIGHT_PURPLE + "海之眷顾",
            List.of(ChatColor.LIGHT_PURPLE + "无限包容")
    ).getItem();
    public static final ItemStack PSI_CONVERGENT = HikariItemStack.getSkull(
            "34130ca6974914cbaabaec2dc4d1ed6c33a30b38d791c1d057a29a5d51b99ff9",
            ChatColor.WHITE + "汇",
            List.of(ChatColor.WHITE + "无量无数")
    ).getItem();
    public static final ItemStack PSI_FLOW = HikariItemStack.getSkull(
            "e06ce787ffc90ca85f594e6bf62ab7e2af017a0905d12c8b2877421353d57788",
            ChatColor.AQUA + "流",
            List.of(ChatColor.DARK_AQUA + "数不尽的")
    ).getItem();
    public static final ItemStack PSI_PROTECTION_FORCE = new HikariItemStack.Builder(
            Material.TINTED_GLASS,
            1,
            ChatColor.WHITE + "海之守护",
            List.of(ChatColor.WHITE + "阻止32格范围内的所有爆炸", SUFFIX_MACHINE)
    ).build().getItem();
    public static final ItemStack PSI_SUMMON_OF_THE_SEA = new HikariItemStack.Builder(
            Material.PRISMARINE,
            1,
            ChatColor.GOLD + "海之召唤",
            List.of(ChatColor.GOLD + "随机召唤一种生物...", SUFFIX_MACHINE)
    ).build().getItem();
    public static final ItemStack PSI_ATTACKING_MACHINE_I = new HikariItemStack.Builder(
            Material.PURPLE_WOOL,
            1,
            ChatColor.RED + "攻击机器·I",
            List.of(
                    ChatColor.RED + "自动攻击范围内实体",
                    ChatColor.RED + "时间: 6t",
                    ChatColor.RED + "伤害: 5❤",
                    SUFFIX_MACHINE
            )
    ).build().getItem();
    public static final ItemStack PSI_ATTACKING_MACHINE_II = new HikariItemStack.Builder(
            Material.PURPLE_CONCRETE,
            1,
            ChatColor.RED + "攻击机器·II",
            List.of(
                    ChatColor.RED + "自动攻击范围内实体",
                    ChatColor.RED + "时间: 4t",
                    ChatColor.RED + "伤害: 10❤",
                    SUFFIX_MACHINE
            )
   ).build().getItem();
    public static final ItemStack PSI_ATTACKING_MACHINE_III = new HikariItemStack.Builder(
            Material.PURPLE_GLAZED_TERRACOTTA,
            1,
            ChatColor.RED + "攻击机器·III",
            List.of(
                    ChatColor.RED + "自动攻击范围内实体",
                    ChatColor.RED + "时间: 2t",
                    ChatColor.RED + "伤害: 20❤",
                    SUFFIX_MACHINE
            )
    ).build().getItem();
    public static final ItemStack PSI_OVERWATCH_MACHINE = new HikariItemStack.Builder(
            Material.PURPLE_STAINED_GLASS,
            1,
            ChatColor.RED + "守望机",
            List.of(
                    ChatColor.RED + "???",
                    SUFFIX_MACHINE
            )
    ).build().getItem();
    public static final ItemStack PSI_ENTITY_CARD_PIGLIN = new HikariItemStack.Builder(
            Material.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE,
            1,
            ChatColor.GOLD + "生物卡片" + ChatColor.GRAY + " - " + ChatColor.RED + "地狱猪人族",
            List.of(
                    ChatColor.GRAY + "定向召唤!"
            )
     ).build().getItem();
    public static final ItemStack PSI_ENTITY_CARD_OVERWORLD = new HikariItemStack.Builder(
            Material.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE,
            1,
            ChatColor.GOLD + "生物卡片" + ChatColor.GRAY + " - " + ChatColor.RED + "主世界陆地生物族",
            List.of(
                    ChatColor.GRAY + "定向召唤!"
            )
    ).build().getItem();
    public static final ItemStack PSI_ENTITY_CARD_SEA_COMMON = new HikariItemStack.Builder(
            Material.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE,
            1,
            ChatColor.GOLD + "生物卡片" + ChatColor.GRAY + " - " + ChatColor.RED + "海洋生物族",
            List.of(
                    ChatColor.GRAY + "定向召唤!"
            )
    ).build().getItem();
    public static final ItemStack PSI_ENTITY_CARD_SEA_MONSTER = new HikariItemStack.Builder(
            Material.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE,
            1,
            ChatColor.GOLD + "生物卡片" + ChatColor.GRAY + " - " + ChatColor.RED + "海洋怪物族",
            List.of(
                    ChatColor.GRAY + "定向召唤!"
            )
    ).build().getItem();


    private static String getObfuscatedString(String s) {
        return ChatColor.GRAY + "" + ChatColor.MAGIC + "x" + ChatColor.WHITE + s + ChatColor.GRAY + "" + ChatColor.MAGIC + "x" + ChatColor.RESET + "" + ChatColor.WHITE;
    }
}
