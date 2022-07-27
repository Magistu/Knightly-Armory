package com.magistuarmory.item;


import com.magistuarmory.KnightlyArmory;
import net.minecraft.loot.LootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.TableLootEntry;
import net.minecraft.util.ResourceLocation;

public class ModLoot {

    public static void loadLoot(ResourceLocation loc, LootTable lootTable) {
        String prefix = "minecraft:chests/";
        String name = loc.toString();

        if (name.startsWith(prefix)) {
            String file = name.substring(name.indexOf(prefix) + prefix.length());
            switch (file) {
                case "desert_pyramid":
                case "end_city_treasure":
                case "jungle_temple":
                case "nether_bridge":
                case "ruined_portal":
                case "simple_dungeon":
                case "stronghold_corridor":
                case "village/village_weaponsmith":
                    lootTable.addPool(getPool(file));
                default:
            }
        }
    }

    public static LootPool getPool(String entryName) {
        return LootPool.lootPool().add(getPoolEntry(entryName)).build();
    }

    @SuppressWarnings("rawtypes")
    private static LootEntry.Builder<?> getPoolEntry(String name) {
        ResourceLocation table = new ResourceLocation(KnightlyArmory.ID, "chests/" + name);
        return TableLootEntry.lootTableReference(table);
    }
}
