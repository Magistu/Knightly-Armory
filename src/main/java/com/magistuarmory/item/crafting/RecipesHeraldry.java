package com.magistuarmory.item.crafting;

import com.google.gson.JsonObject;
import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.config.ModConfigurations;
import com.magistuarmory.item.ISurcoat;
import com.magistuarmory.item.MedievalShieldItem;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipe;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class RecipesHeraldry extends SpecialRecipe
{
    public static Serializer HERALDRY_RECIPES = new Serializer(RecipesHeraldry::new);

    public RecipesHeraldry(ResourceLocation p_i48160_1_)
    {
        super(p_i48160_1_);
    }

    public boolean matches(CraftingInventory p_77569_1_, @NotNull World p_77569_2_)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        ItemStack itemstack1 = ItemStack.EMPTY;

        for(int i = 0; i < p_77569_1_.getContainerSize(); ++i)
        {
            ItemStack itemstack2 = p_77569_1_.getItem(i);
            if (!itemstack2.isEmpty())
            {
                if (itemstack2.getItem() instanceof BannerItem)
                {
                    if (!itemstack1.isEmpty())
                    {
                        return false;
                    }

                    itemstack1 = itemstack2;
                }
                else
                {
                    if (!isHeraldic(itemstack2.getItem()))
                    {
                        return false;
                    }

                    if (!itemstack.isEmpty())
                    {
                        return false;
                    }

                    if (itemstack2.getTagElement("BlockEntityTag") != null)
                    {
                        return false;
                    }

                    itemstack = itemstack2;
                }
            }
        }

        return !itemstack.isEmpty() && !itemstack1.isEmpty();
    }

    public @NotNull ItemStack assemble(CraftingInventory p_77572_1_)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        ItemStack itemstack1 = ItemStack.EMPTY;

        for(int i = 0; i < p_77572_1_.getContainerSize(); ++i)
        {
            ItemStack itemstack2 = p_77572_1_.getItem(i);
            if (!itemstack2.isEmpty())
            {
                if (itemstack2.getItem() instanceof BannerItem)
                {
                    itemstack = itemstack2;
                }
                else if (isHeraldic(itemstack2.getItem()))
                {
                    itemstack1 = itemstack2.copy();
                }
            }
        }

        if (!itemstack1.isEmpty())
        {
            CompoundNBT compoundnbt = itemstack.getTagElement("BlockEntityTag");
            CompoundNBT compoundnbt1 = compoundnbt == null ? new CompoundNBT() : compoundnbt.copy();
            DyeColor basecolor = ((BannerItem) itemstack.getItem()).getColor();
            compoundnbt1.putInt("Base", basecolor.getId());

            if (wornWithSurcoat(itemstack1.getItem()))
            {
                if (itemstack1.getHoverName() instanceof TranslationTextComponent)
                {
                    itemstack1.setHoverName(new TranslationTextComponent(((TranslationTextComponent) itemstack1.getHoverName()).getKey()).append(new TranslationTextComponent("magistuarmory.withsurcoat." + basecolor.getName())));
                }
                else
                {
                    itemstack1.setHoverName(new TranslationTextComponent(itemstack1.getHoverName().toString()).append(new TranslationTextComponent("magistuarmory.withsurcoat." + basecolor.getName())));
                }
            }
            else if (wornWithCaparison(itemstack1.getItem()))
            {
                if (itemstack1.getHoverName() instanceof TranslationTextComponent)
                {
                    itemstack1.setHoverName(new TranslationTextComponent(((TranslationTextComponent) itemstack1.getHoverName()).getKey()).append(new TranslationTextComponent("magistuarmory.withcaparison." + basecolor.getName())));
                }
                else
                {
                    itemstack1.setHoverName(new TranslationTextComponent(itemstack1.getHoverName().toString()).append(new TranslationTextComponent("magistuarmory.withcaparison." + basecolor.getName())));
                }
            }

            itemstack1.addTagElement("BlockEntityTag", compoundnbt1);
        }

        return itemstack1;
    }

    public boolean canCraftInDimensions(int p_194133_1_, int p_194133_2_)
    {
        return p_194133_1_ * p_194133_2_ >= 2;
    }

    public @NotNull IRecipeSerializer<?> getSerializer()
    {
        return HERALDRY_RECIPES;
    }

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<RecipesHeraldry>
    {
        private final Function<ResourceLocation, RecipesHeraldry> constructor;

        public Serializer(Function<ResourceLocation, RecipesHeraldry> p_44399_)
        {
            this.constructor = p_44399_;
            setRegistryName(new ResourceLocation(KnightlyArmory.ID, "shield_heraldy"));
        }

        public @NotNull RecipesHeraldry fromJson(@NotNull ResourceLocation p_44404_, @NotNull JsonObject p_44405_)
        {
            return this.constructor.apply(p_44404_);
        }

        public RecipesHeraldry fromNetwork(@NotNull ResourceLocation p_44407_, @NotNull PacketBuffer p_44408_)
        {
            return this.constructor.apply(p_44407_);
        }

        public void toNetwork(@NotNull PacketBuffer p_44401_, @NotNull RecipesHeraldry p_44402_) {}
    }

    boolean isPaintableShield(Item item)
    {
        return item instanceof MedievalShieldItem && ((MedievalShieldItem)item).isPaintable();
    }

    boolean wornWithCaparison(Item item)
    {
        return item instanceof HorseArmorItem;
    }

    boolean wornWithSurcoat(Item item)
    {
        return item instanceof ArmorItem && (ModConfigurations.decorations_for_all_armor.get() || item instanceof ISurcoat) && ((ArmorItem) item).getSlot().equals(EquipmentSlotType.CHEST);
    }

    boolean isHeraldic(Item item)
    {
        return isPaintableShield(item) || wornWithCaparison(item)  || wornWithSurcoat(item);
    }
}