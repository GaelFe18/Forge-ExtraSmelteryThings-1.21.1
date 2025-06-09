package net.GaelFe18.ExtraSmelteryThings.recipe;

import net.GaelFe18.ExtraSmelteryThings.ExtraSmelteryThings;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ExtraSmelteryThings.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, ExtraSmelteryThings.MOD_ID);

    public static final RegistryObject<RecipeSerializer<BasicFoundryBlockRecipe>> BASIC_FOUNDRY_BLOCK_SERIALIZER =
            SERIALIZERS.register("basic_foundry_block", BasicFoundryBlockRecipe.Serializer::new);

    public static final RegistryObject<RecipeType<BasicFoundryBlockRecipe>> BASIC_FOUNDRY_BLOCK_TYPE =
            TYPES.register("basic_foundry_block", () -> new RecipeType<BasicFoundryBlockRecipe>() {
                @Override
                public String toString() {
                    return "basic_foundry_block";
                }
            });

    public static final RegistryObject<RecipeSerializer<BasicAlloyerBlockRecipe>> BASIC_ALLOYER_BLOCK_SERIALIZER =
            SERIALIZERS.register("basic_alloyer_block", BasicAlloyerBlockRecipe.Serializer::new);

    public static final RegistryObject<RecipeType<BasicAlloyerBlockRecipe>> BASIC_ALLOYER_BLOCK_TYPE =
            TYPES.register("basic_alloyer_block", () -> new RecipeType<BasicAlloyerBlockRecipe>() {
                @Override
                public String toString() {
                    return "basic_alloyer_block";
                }
            });

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }

}
