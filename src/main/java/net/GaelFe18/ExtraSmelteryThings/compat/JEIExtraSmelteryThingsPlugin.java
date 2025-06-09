package net.GaelFe18.ExtraSmelteryThings.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.GaelFe18.ExtraSmelteryThings.ExtraSmelteryThings;
import net.GaelFe18.ExtraSmelteryThings.block.ModBlocks;
import net.GaelFe18.ExtraSmelteryThings.recipe.BasicFoundryBlockRecipe;
import net.GaelFe18.ExtraSmelteryThings.recipe.ModRecipes;
import net.GaelFe18.ExtraSmelteryThings.screen.custom.BasicFoundryBlockScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEIExtraSmelteryThingsPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(ExtraSmelteryThings.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new BasicFoundryBlockRecipeCategory
                (registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<BasicFoundryBlockRecipe> basicFoundryBlockRecipes = recipeManager
                .getAllRecipesFor(ModRecipes.BASIC_FOUNDRY_BLOCK_TYPE.get()).stream()
                .map(RecipeHolder::value).toList();

        registration.addRecipes(BasicFoundryBlockRecipeCategory.BASIC_FOUNDRY_BLOCK_RECIPE_RECIPE_TYPE, basicFoundryBlockRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(BasicFoundryBlockScreen.class, 72, 29, 30 , 19,
                BasicFoundryBlockRecipeCategory.BASIC_FOUNDRY_BLOCK_RECIPE_RECIPE_TYPE);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.BASIC_FOUNDRY_BLOCK.get().asItem()),
                BasicFoundryBlockRecipeCategory.BASIC_FOUNDRY_BLOCK_RECIPE_RECIPE_TYPE);
    }
}
