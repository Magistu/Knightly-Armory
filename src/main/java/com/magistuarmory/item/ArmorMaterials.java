package com.magistuarmory.item;

import java.util.function.Supplier;


import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.init.ModItems;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyValue;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;

public enum ArmorMaterials implements IArmorMaterial
{
    KNIGHT("knight", 1.25f, 0.5f, new int[] { 230, 315, 335, 275 }, new int[] { 2, 5, 8, 3 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),
    ARMET("armet", 1.25f, 0.5f, new int[] { 230, 315, 335, 275 }, new int[] { 2, 5, 8, 3 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),

    STECHHELM("stechhelm", 2.0f, 1.5f, new int[] { 345, 500, 440, 385 }, new int[] { 3, 6, 9, 4 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),
    JOUSTING("jousting", 2.0f, 1.5f, new int[] { 345, 500, 440, 385 }, new int[] { 3, 6, 9, 4 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),

    SALLET("sallet", 1.25f, 0.5f, new int[] { 230, 315, 335, 275 }, new int[] { 2, 5, 8, 3 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),
    GOTHIC("gothic", 1.25f, 0.5f, new int[] { 230, 315, 335, 275 }, new int[] { 2, 5, 8, 3 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),

    MAXIMILIANHELMET("maximilian_helmet", 1.8f, 0.5f, new int[] { 345, 500, 440, 385 }, new int[] { 3, 6, 9, 4 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),
    MAXIMILIAN("maximilian", 1.8f, 0.5f, new int[] { 345, 500, 440, 385 }, new int[] { 3, 6, 9, 4 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),

    CHAINMAIL("chainmail", 0.0f, 0f, new int[] { 170, 235, 250, 205 }, new int[] { 1, 4, 5, 2 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_chain")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),

    KETTLEHAT("kettlehat", 0.3f, 0f, new int[] { 100, 270, 200, 240 }, new int[] { 2, 5, 6, 2 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_chain")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),
    PLATEMAIL("platemail", 0.3f, 0f, new int[] { 100, 270, 200, 240 }, new int[] { 2, 5, 6, 2 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_chain")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),

    BARBUTE("barbute", 0.5f, 0f, new int[] { 150, 290, 315, 170 }, new int[] { 2, 5, 6, 2 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),
    HALFARMOR("halfarmor", 0.5f, 0f, new int[] { 150, 290, 315, 170 }, new int[] { 2, 5, 6, 2 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),

    CRUSADER("crusader", 0.6f, 0f, new int[] { 150, 280, 295, 220 }, new int[] { 1, 5, 6, 3 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_chain")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),

    BRIGANDINE("brigandine", 0.25f, 0f, new int[] { 100, 200, 265, 170 }, new int[] { 2, 3, 5, 2 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_leather")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),

    GAMBESON("gambeson", 0f, 0f, new int[] { 100, 0, 128, 88 }, new int[] { 1, 0, 2, 1 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_leather")), () -> { return Ingredient.of(ModItems.WOOLEN_FABRIC.get()); }),

    CEREMONIALARMET("ceremonialarmet", 1.25f, 0f, new int[] { 230, 315, 335, 275 }, new int[] { 2, 5, 8, 3 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),
    CEREMONIAL("ceremonial", 1.25f, 0f, new int[] { 230, 315, 335, 275 }, new int[] { 2, 5, 8, 3 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),

    SHISHAK("shishak", 0.3f, 0f, new int[] { 200, 270, 200, 210 }, new int[] { 2, 5, 6, 2 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),

    NORMAN("norman", 0.2f, 0f, new int[] { 200, 270, 200, 190 }, new int[] { 2, 5, 6, 2 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),

    RUSTEDBARBUTE("rustedbarbute", 0.0f, 0f, new int[] { 100, 160, 170, 90 }, new int[] { 2, 5, 6, 2 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),
    RUSTEDHALFARMOR("rustedhalfarmor", 0.0f, 0f, new int[] { 100, 160, 170, 90 }, new int[] { 1, 5, 6, 2 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),

    RUSTEDCHAINMAIL("rustedchainmail", 0.0f, 0f, new int[] { 85, 115, 125, 100 }, new int[] { 1, 4, 5, 2 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_chain")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),

    RUSTEDKETTLEHAT("rustedkettlehat", 0.0f, 0f, new int[] { 50, 185, 100, 120 }, new int[] { 2, 5, 6, 2 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_chain")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),

    RUSTEDNORMAN("rustednorman", 0.0f, 0f, new int[] { 100, 185, 100, 85 }, new int[] { 1, 4, 5, 2 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_chain")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),

    RUSTEDCRUSADER("rustedcrusader", 0.0f, 0f, new int[] { 75, 140, 150, 110 }, new int[] { 1, 5, 6, 3 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_chain")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),

    BASCINET("bascinet", 1.25f, 0f, new int[] { 210, 300, 320, 250 }, new int[] { 2, 5, 7, 3 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),
    XIVCENTURYKNIGHT("xivcenturyknight", 1.25f, 0f, new int[] { 210, 300, 320, 250 }, new int[] { 2, 5, 7, 3 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),

    WINGEDHUSSARCHESTPLATE("wingedhussarchestplate", 1.0f, 0f, new int[] { 150, 0, 360, 170 }, new int[] { 1, 0, 7, 2 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),

    CUIRASSIER("cuirassier", 0.5f, 0f, new int[] { 150, 0, 315, 170 }, new int[] { 1, 0, 6, 2 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),
    
    KASTENBRUST("kastenbrust", 1.25f, 0.5f, new int[] { 230, 315, 335, 275 }, new int[] { 2, 5, 8, 3 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),
    GRAND_BASCINET("grand_bascinet", 1.25f, 0.5f, new int[] { 230, 315, 335, 275 }, new int[] { 2, 5, 8, 3 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); }),

    LAMELLAR("lamellar", 0.3f, 0f, new int[] { 200, 270, 200, 240 }, new int[] { 2, 5, 6, 3 }, 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_chain")), () -> { return Ingredient.of(ItemTags.getAllTags().getTag(new ResourceLocation("forge:ingots/steel"))); });


    private final String name;
    private final float toughness;
    private final float knockbackResistance;
    private final int[] durability;
    private final int[] defenseForSlot;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final LazyValue<Ingredient> repairIngredient;

    ArmorMaterials(String nameIn, float toughnessIn, float knockbackResistanceIn, int[] durabilityIn, int[] defenseForSlotIn, int enchantmentValueIn, SoundEvent equipSoundIn, Supplier<Ingredient> repairIngredientIn)
    {
        this.name = KnightlyArmory.ID + ":" + nameIn;
        this.toughness = toughnessIn;
        this.knockbackResistance = knockbackResistanceIn;
        this.durability = durabilityIn;
        this.defenseForSlot = defenseForSlotIn;
        this.enchantmentValue = enchantmentValueIn;
        this.equipSound = equipSoundIn;
        this.repairIngredient = new LazyValue<>(repairIngredientIn);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlotType var1) {
        return durability[var1.getIndex()];
    }

    @Override
    public int getDefenseForSlot(EquipmentSlotType var1) {
        return defenseForSlot[var1.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }
}
