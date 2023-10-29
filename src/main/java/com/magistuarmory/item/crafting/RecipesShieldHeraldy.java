package com.magistuarmory.item.crafting;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.init.ModItems;
import com.magistuarmory.item.MedievalShieldItem;

import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class RecipesShieldHeraldy extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

  
  public RecipesShieldHeraldy() {
	setRegistryName(new ResourceLocation(KnightlyArmory.ID, "shield_banner"));
  }
  
  public boolean matches(InventoryCrafting inv, World worldIn) {
    ItemStack itemstack = ItemStack.EMPTY;
    ItemStack itemstack1 = ItemStack.EMPTY;
    for (int i = 0; i < inv.getSizeInventory(); i++) {
      ItemStack itemstack2 = inv.getStackInSlot(i);
      if (!itemstack2.isEmpty())
        if (itemstack2.getItem() == Items.BANNER) {
          if (!itemstack1.isEmpty())
            return false; 
          itemstack1 = itemstack2;
        } else {
          if (!(itemstack2.getItem() instanceof MedievalShieldItem) || (itemstack2.getItem() instanceof MedievalShieldItem && !((MedievalShieldItem)itemstack2.getItem()).isPaintable()))
            return false; 
          if (!itemstack.isEmpty())
            return false; 
          if (itemstack2.getSubCompound("BlockEntityTag") != null)
            return false; 
          itemstack = itemstack2;
        }  
    } 
    if (!itemstack.isEmpty() && !itemstack1.isEmpty())
      return true; 
    return false;
  }
  
  public ItemStack getCraftingResult(InventoryCrafting inv) 
  {
    ItemStack itemstack = ItemStack.EMPTY;
    ItemStack itemstack1 = ItemStack.EMPTY;
    for (int i = 0; i < inv.getSizeInventory(); i++) 
    {
      ItemStack itemstack2 = inv.getStackInSlot(i);
      if (!itemstack2.isEmpty())
      {
        if (itemstack2.getItem() == Items.BANNER) 
        {
          itemstack = itemstack2;
        } 
        else if (itemstack2.getItem() instanceof MedievalShieldItem && ((MedievalShieldItem)itemstack2.getItem()).isPaintable()) 
        {
          itemstack1 = itemstack2.copy();
        }  
      }
    } 
    if (itemstack1.isEmpty())
      return itemstack1; 
    NBTTagCompound nbttagcompound = itemstack.getSubCompound("BlockEntityTag");
    NBTTagCompound nbttagcompound1 = (nbttagcompound == null) ? new NBTTagCompound() : nbttagcompound.copy();
    nbttagcompound1.setInteger("Base", itemstack.getMetadata() & 0xF);
    itemstack1.setTagInfo("BlockEntityTag", (NBTBase)nbttagcompound1);
    return itemstack1;
  }
  
  public ItemStack getRecipeOutput() 
  {
    return ItemStack.EMPTY;
  }
  
  public NonNullList<ItemStack> getRemainingItems(InventoryCrafting inv) 
  {
    NonNullList<ItemStack> nonnulllist = NonNullList.withSize(inv.getSizeInventory(), ItemStack.EMPTY);
    for (int i = 0; i < nonnulllist.size(); i++) 
    {
      ItemStack itemstack = inv.getStackInSlot(i);
      if (itemstack.getItem().hasContainerItem())
        nonnulllist.set(i, new ItemStack(itemstack.getItem().getContainerItem())); 
    } 
    return nonnulllist;
  }
  
  public boolean isDynamic() 
  {
    return true;
  }
  
  public boolean canFit(int width, int height) {
    return (width * height >= 2);
  }
}
