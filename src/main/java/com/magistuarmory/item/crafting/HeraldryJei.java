//package com.magistuarmory.item.crafting;
//
//import com.magistuarmory.KnightlyArmory;
//import mezz.jei.api.IModPlugin;
//import mezz.jei.api.JeiPlugin;
//import mezz.jei.api.registration.IRecipeCategoryRegistration;
//import mezz.jei.api.registration.IRecipeRegistration;
//import net.minecraft.client.Minecraft;
//import net.minecraft.item.crafting.IRecipeType;
//import net.minecraft.item.crafting.RecipeManager;
//import net.minecraft.util.ResourceLocation;
//import org.jetbrains.annotations.NotNull;
//
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//@JeiPlugin
//public class HeraldyJei implements IModPlugin
//{
//    @Override
//    public @NotNull ResourceLocation getPluginUid()
//    {
//        return new ResourceLocation(KnightlyArmory.ID, "jei_plugin");
//    }
//
//    @Override
//    public void registerCategories(IRecipeCategoryRegistration registration)
//    {
//        registration.addRecipeCategories(
//                new HeraldyJeiCategory(registration.getJeiHelpers().getGuiHelper()));
//    }
//
//    @Override
//    public void registerRecipes(IRecipeRegistration registration)
//    {
//        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
//        registration.addRecipes(rm.getRecipesFor(IRecipeType.CRAFTING).stream()
//                        .filter(r -> r instanceof LightningChannelerRecipe).collect(Collectors.toList()),
//                HeraldyJeiCategory.UID);
//    }
//}
