package com.magistuarmory.item;


import com.magistuarmory.KnightlyArmory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;

import javax.naming.Name;

public class ModLoot
{
    public static void loadLoot(ResourceLocation loc, LootTable lootTable) 
    {
        String prefix = "minecraft:chests/";
        String name = loc.toString();

        if (name.startsWith(prefix)) 
        {
            String file = name.substring(name.indexOf(prefix) + prefix.length());
            switch (file) {
                case "desert_pyramid", "end_city_treasure", "jungle_temple", "nether_bridge", "ruined_portal", "simple_dungeon", "stronghold_corridor", "village/village_weaponsmith" -> 
                        lootTable.addPool(getPool(file));
                default -> {}
            }
        }
    }

    public static LootPool getPool(String entryName) 
    {
        return LootPool.lootPool().add(getPoolEntry(entryName)).build();
    }

    @SuppressWarnings("rawtypes")
    private static LootPoolEntryContainer.Builder getPoolEntry(String name) 
    {
        ResourceLocation table = new ResourceLocation(KnightlyArmory.ID, "chests/" + name);
        return LootTableReference.lootTableReference(table);
    }
}
