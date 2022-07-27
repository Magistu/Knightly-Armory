//package com.magistuarmory.item.crafting;
//
//import com.magistuarmory.KnightlyArmory;
//import com.mojang.blaze3d.matrix.MatrixStack;
//import mezz.jei.api.constants.VanillaTypes;
//import mezz.jei.api.gui.IRecipeLayout;
//import mezz.jei.api.gui.drawable.IDrawable;
//import mezz.jei.api.gui.drawable.IDrawableStatic;
//import mezz.jei.api.helpers.IGuiHelper;
//import mezz.jei.api.ingredients.IIngredients;
//import mezz.jei.api.recipe.category.IRecipeCategory;
//import net.minecraft.block.Blocks;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.ResourceLocation;
//
//public class HeraldyJeiCategory implements IRecipeCategory<HeraldyJeiCategory>
//{
//    public final static ResourceLocation UID = new ResourceLocation(KnightlyArmory.ID, "lightning");
//    public final static ResourceLocation TEXTURE = new ResourceLocation(KnightlyArmory.ID, "textures/gui/lightning_channeler_gui.png");
//
//    private final IDrawable background;
//    private final IDrawable icon;
//    private final IDrawableStatic lightningBolt;
//
//    public HeraldyJeiCategory(IGuiHelper helper)
//    {
//        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
//        this.icon = helper.createDrawableIngredient(new ItemStack(Blocks.CRAFTING_TABLE));
//        this.lightningBolt = helper.createDrawable(TEXTURE, 176, 0, 13, 17);
//    }
//
//    @Override
//    public ResourceLocation getUid()
//    {
//        return UID;
//    }
//
//    @Override
//    public Class<? extends HeraldyJeiCategory> getRecipeClass()
//    {
//        return HeraldyJeiCategory.class;
//    }
//
//    @Override
//    public String getTitle()
//    {
//        return Blocks.CRAFTING_TABLE.getName().getString();
//    }
//
//    @Override
//    public IDrawable getBackground()
//    {
//        return this.background;
//    }
//
//    @Override
//    public IDrawable getIcon()
//    {
//        return this.icon;
//    }
//
//    @Override
//    public void setIngredients(HeraldyJeiCategory recipe, IIngredients ingredients)
//    {
//        ingredients.setInputIngredients(recipe.);
//        ingredients.setOutput(VanillaTypes.ITEM, recipe.getRecipeOutput());
//    }
//
//    @Override
//    public void setRecipe(IRecipeLayout recipeLayout, HeraldyJeiCategory recipe, IIngredients ingredients)
//    {
//        recipeLayout.getItemStacks().init(0, true, 79, 30);
//        recipeLayout.getItemStacks().init(1, true, 79, 52);
//
//        recipeLayout.getItemStacks().init(2, false, 102, 42);
//        recipeLayout.getItemStacks().set(ingredients);
//    }
//
//    @Override
//    public void draw(HeraldyJeiCategory recipe, MatrixStack matrixStack, double mouseX, double mouseY)
//    {
//        if(recipe.getWeather() == HeraldyJeiCategory.Weather.THUNDERING)
//        {
//            this.lightningBolt.draw(matrixStack, 82, 9);
//        }
//    }
//}
