package net.GaelFe18.ExtraSmelteryThings.item;

import net.GaelFe18.ExtraSmelteryThings.ExtraSmelteryThings;
import net.GaelFe18.ExtraSmelteryThings.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExtraSmelteryThings.MOD_ID);

    public static final RegistryObject<CreativeModeTab> EXTRASMELTERYTHINGS_ITEMS_TAB = CREATIVE_MOD_TABS.register("extrasmelterythings_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ORES_POLISHER.get()))
                    .title(Component.translatable("creativetab.extrasmelterythings.extrasmelterythings_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        //abajo el input del item
                        output.accept(ModItems.ORES_POLISHER.get());
                        output.accept(ModItems.CARBON_STEEL.get());
                        output.accept(ModItems.MOLTEN_CARBON_STEEL.get());
                        output.accept(ModItems.COKE.get());
                        output.accept(ModItems.MOLTEN_IRON.get());
                        output.accept(ModItems.DIRTY_RAW_IRON.get());
                        output.accept(ModItems.BURNING_COAL.get());

                    }).build());


    public static final RegistryObject<CreativeModeTab> EXTRASMELTERYTHINGS_BLOCKS_TAB = CREATIVE_MOD_TABS.register("extrasmelterythings_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.BASIC_FOUNDRY_BLOCK.get()))
                    .withTabsBefore(EXTRASMELTERYTHINGS_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.extrasmelterythings.extrasmelterythings_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        //abajo el input del bloque
                        output.accept(ModBlocks.BASIC_FOUNDRY_BLOCK.get());
                        output.accept(ModBlocks.BASIC_TANK_BLOCK.get());
                        output.accept(ModBlocks.BASIC_ALLOYER_BLOCK.get());
                        output.accept(ModBlocks.DIRTY_RAW_IRON_BLOCK.get());

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MOD_TABS.register(eventBus);

    }
}
