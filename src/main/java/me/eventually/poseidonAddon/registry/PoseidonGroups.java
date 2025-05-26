package me.eventually.poseidonAddon.registry;

import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import me.eventually.poseidonAddon.PoseidonAddon;
import org.apache.commons.lang3.Validate;
import org.bukkit.NamespacedKey;

public class PoseidonGroups {
    public static NestedItemGroup PSI_GROUP;
    public static SubItemGroup PSI_AUTHOR;
    public static SubItemGroup PSI_STAGE_I;
    public static SubItemGroup PSI_STAGE_II;
    public static SubItemGroup PSI_STAGE_III;
    public static void setup(PoseidonAddon addon) {
        Validate.notNull(addon, "PoseidonAddon 实例不能为空");

        PSI_GROUP = new NestedItemGroup(getKey("PSI_GLOBAL", addon), PoseidonItems.PSI_GROUP_GLOBAL, -1);
        PSI_AUTHOR = new SubItemGroup(getKey("PSI_AUTHOR", addon), PSI_GROUP, PoseidonItems.PSI_GROUP_AUTHOR, -1);
        PSI_STAGE_I = new SubItemGroup(getKey("PSI_STAGE_I", addon), PSI_GROUP, PoseidonItems.PSI_GROUP_I);
        PSI_STAGE_II = new SubItemGroup(getKey("PSI_STAGE_II", addon), PSI_GROUP, PoseidonItems.PSI_GROUP_II);
        PSI_STAGE_III = new SubItemGroup(getKey("PSI_STAGE_III", addon), PSI_GROUP, PoseidonItems.PSI_GROUP_III);
    }

    private static NamespacedKey getKey(String name, PoseidonAddon addon) {
        Validate.notNull(name, "名称不能为空");
        Validate.notNull(addon, "PoseidonAddon 实例不能为空");
        return new NamespacedKey(addon, name);
    }
}
