package com.magistuarmory.item.crafting;
import com.magistuarmory.config.ModConfigurations;
import com.magistuarmory.item.ISurcoat;
import com.magistuarmory.item.MedievalShieldItem;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class RecipesHeraldry extends CustomRecipe
{
	public static SimpleCraftingRecipeSerializer<RecipesHeraldry> HERALDRY_RECIPES = new SimpleCraftingRecipeSerializer<>(RecipesHeraldry::new);
	
	public RecipesHeraldry(ResourceLocation p_44296_, CraftingBookCategory category)
	{
		super(p_44296_, category);
	}
	
	@Override
	public boolean matches(CraftingContainer p_44308_, Level p_44309_) 
	{
		ItemStack itemstack = ItemStack.EMPTY;
		ItemStack itemstack1 = ItemStack.EMPTY;
		
		for(int i = 0; i < p_44308_.getContainerSize(); ++i) 
		{
			ItemStack itemstack2 = p_44308_.getItem(i);
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
					if (!hasHeraldy(itemstack2.getItem()))
					{
					   return false;
					}
					
					if (!itemstack.isEmpty()) 
					{
					   return false;
					}
					
					if (BlockItem.getBlockEntityData(itemstack2) != null) 
					{
					   return false;
					}
					
					itemstack = itemstack2;
				}
			}
		}
		
		return !itemstack.isEmpty() && !itemstack1.isEmpty();
	}

	@Override
	public ItemStack assemble(CraftingContainer p_44306_) 
	{
		ItemStack itemstack = ItemStack.EMPTY;
		ItemStack itemstack1 = ItemStack.EMPTY;
		
		for(int i = 0; i < p_44306_.getContainerSize(); ++i) 
		{
		   ItemStack itemstack2 = p_44306_.getItem(i);
		   if (!itemstack2.isEmpty()) 
		   {
		      if (itemstack2.getItem() instanceof BannerItem) 
		      {
				itemstack = itemstack2;
		      } 
		      else if (hasHeraldy(itemstack2.getItem()))
			  {
				itemstack1 = itemstack2.copy();
		      }
		   }
		}

		if (!itemstack1.isEmpty())
		{
			CompoundTag compoundtag = BlockItem.getBlockEntityData(itemstack);
			CompoundTag compoundtag1 = compoundtag == null ? new CompoundTag() : compoundtag.copy();
			DyeColor basecolor = ((BannerItem) itemstack.getItem()).getColor();
			compoundtag1.putInt("Base", ((BannerItem) itemstack.getItem()).getColor().getId());

			if (wornWithSurcoat(itemstack1.getItem()))
			{
				if (itemstack1.getHoverName() instanceof MutableComponent)
				{
					itemstack1.setHoverName(Component.translatable(itemstack1.getHoverName().getString()).append(Component.translatable("magistuarmory.withsurcoat." + basecolor.getName())));
				}
				else
				{
					itemstack1.setHoverName(Component.translatable(itemstack1.getHoverName().toString()).append(Component.translatable("magistuarmory.withsurcoat." + basecolor.getName())));
				}
			}
			else if (wornWithCaparison(itemstack1.getItem()))
			{
				if (itemstack1.getHoverName() instanceof MutableComponent)
				{
					itemstack1.setHoverName(Component.translatable(itemstack1.getHoverName().getString()).append(Component.translatable("magistuarmory.withcaparison." + basecolor.getName())));
				}
				else
				{
					itemstack1.setHoverName(Component.translatable(itemstack1.getHoverName().toString()).append(Component.translatable("magistuarmory.withcaparison." + basecolor.getName())));
				}
			}

			BlockItem.setBlockEntityData(itemstack1, BlockEntityType.BANNER, compoundtag1);
		}
		return itemstack1;
	}
	
	public boolean canCraftInDimensions(int p_44298_, int p_44299_) 
	{
	   return p_44298_ * p_44299_ >= 2;
	}
	
	public RecipeSerializer<?> getSerializer() 
	{
	   return HERALDRY_RECIPES;
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
        return item instanceof ArmorItem && (ModConfigurations.enable_surcoat_recipe_for_all_armor.get() || item instanceof ISurcoat) && ((ArmorItem) item).getSlot().equals(EquipmentSlot.CHEST);
    }

    boolean hasHeraldy(Item item)
    {
        return isPaintableShield(item) || wornWithCaparison(item) || wornWithSurcoat(item);
    }
}