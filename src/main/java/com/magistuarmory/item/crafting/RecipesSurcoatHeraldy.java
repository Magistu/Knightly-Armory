package com.magistuarmory.item.crafting;

import com.google.gson.JsonObject;
import com.magistuarmory.KnightlyArmory;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.BannerItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipe;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class RecipesSurcoatHeraldy extends SpecialRecipe
{

   public static Serializer SURCOAT_HERALDY = new Serializer(RecipesSurcoatHeraldy::new);

   public RecipesSurcoatHeraldy(ResourceLocation p_i48160_1_)
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
               if (!(itemstack2.getItem() instanceof ArmorItem))
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
            else if (itemstack2.getItem() instanceof ArmorItem)
            {
               itemstack1 = itemstack2.copy();
            }
         }
      }

      if (!itemstack1.isEmpty())
      {
         CompoundNBT compoundnbt = itemstack.getTagElement("BlockEntityTag");
         CompoundNBT compoundnbt1 = compoundnbt == null ? new CompoundNBT() : compoundnbt.copy();
         compoundnbt1.putInt("Base", ((BannerItem) itemstack.getItem()).getColor().getId());
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
      return SURCOAT_HERALDY;
   }
   
   public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<RecipesSurcoatHeraldy>
	{
		private final Function<ResourceLocation, RecipesSurcoatHeraldy> constructor;
		
		public Serializer(Function<ResourceLocation, RecipesSurcoatHeraldy> p_44399_)
		{
			this.constructor = p_44399_;
			setRegistryName(new ResourceLocation(KnightlyArmory.ID, "surcoat_heraldy"));
		}
		
		public @NotNull RecipesSurcoatHeraldy fromJson(@NotNull ResourceLocation p_44404_, @NotNull JsonObject p_44405_)
		{
			return this.constructor.apply(p_44404_);
		}
		
		public RecipesSurcoatHeraldy fromNetwork(@NotNull ResourceLocation p_44407_, @NotNull PacketBuffer p_44408_)
		{
			return this.constructor.apply(p_44407_);
		}
		
		public void toNetwork(@NotNull PacketBuffer p_44401_, @NotNull RecipesSurcoatHeraldy p_44402_) {}
	}
}