package net.GaelFe18.ExtraSmelteryThings;

import com.mojang.logging.LogUtils;
import net.GaelFe18.ExtraSmelteryThings.block.ModBlocks;
import net.GaelFe18.ExtraSmelteryThings.block.entity.ModBlockEntities;
import net.GaelFe18.ExtraSmelteryThings.item.ModCreativeTabs;
import net.GaelFe18.ExtraSmelteryThings.item.ModItems;
import net.GaelFe18.ExtraSmelteryThings.loot.ModLootModifiers;
import net.GaelFe18.ExtraSmelteryThings.recipe.ModRecipes;
import net.GaelFe18.ExtraSmelteryThings.screen.ModMenuTypes;
import net.GaelFe18.ExtraSmelteryThings.screen.custom.BasicAlloyerBlockScreen;
import net.GaelFe18.ExtraSmelteryThings.screen.custom.BasicFoundryBlockScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExtraSmelteryThings.MOD_ID)
public class ExtraSmelteryThings
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "extrasmelterythings";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    public ExtraSmelteryThings()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        ModCreativeTabs.register(modEventBus);

        ModItems.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModMenuTypes.register(modEventBus);

        ModRecipes.register(modEventBus);

        ModLootModifiers.register(modEventBus);


        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }
    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }
    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            MenuScreens.register(ModMenuTypes.BASIC_FOUNDRY_BLOCK_MENU.get(), BasicFoundryBlockScreen::new);
            MenuScreens.register(ModMenuTypes.BASIC_ALLOYER_BLOCK_MENU.get(), BasicAlloyerBlockScreen::new);
        }
    }
}
