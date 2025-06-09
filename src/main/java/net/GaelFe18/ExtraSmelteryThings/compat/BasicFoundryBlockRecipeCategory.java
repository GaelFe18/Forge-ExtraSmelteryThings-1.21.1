package net.GaelFe18.ExtraSmelteryThings.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.GaelFe18.ExtraSmelteryThings.ExtraSmelteryThings;
import net.GaelFe18.ExtraSmelteryThings.block.ModBlocks;
import net.GaelFe18.ExtraSmelteryThings.recipe.BasicFoundryBlockRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class BasicFoundryBlockRecipeCategory implements IRecipeCategory<BasicFoundryBlockRecipe> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(ExtraSmelteryThings.MOD_ID, "basic_foundry_block");
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(ExtraSmelteryThings.MOD_ID,
            "textures/gui/basic_foundry_block/basic_foundry_block_gui.png");

    public static final RecipeType<BasicFoundryBlockRecipe> BASIC_FOUNDRY_BLOCK_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, BasicFoundryBlockRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public BasicFoundryBlockRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 80);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.BASIC_FOUNDRY_BLOCK.get()));
    }

    @Override
    public RecipeType<BasicFoundryBlockRecipe> getRecipeType() {
        return BASIC_FOUNDRY_BLOCK_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.extrasmelterythings.basic_foundry_block");
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, BasicFoundryBlockRecipe recipe, IFocusGroup iFocusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 44, 28).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 116, 32).addItemStack(recipe.getResultItem(null));
    }
}
