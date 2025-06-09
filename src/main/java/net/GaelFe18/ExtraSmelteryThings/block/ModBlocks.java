package net.GaelFe18.ExtraSmelteryThings.block;

import net.GaelFe18.ExtraSmelteryThings.ExtraSmelteryThings;
import net.GaelFe18.ExtraSmelteryThings.block.custom.BasicAlloyerBlock;
import net.GaelFe18.ExtraSmelteryThings.block.custom.BasicFoundryBlock;
import net.GaelFe18.ExtraSmelteryThings.block.custom.BasicTankBlock;
import net.GaelFe18.ExtraSmelteryThings.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExtraSmelteryThings.MOD_ID);

    public static final RegistryObject<Block> DIRTY_RAW_IRON_BLOCK = registerBlock("dirty_raw_iron_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> BASIC_FOUNDRY_BLOCK = registerBlock("basic_foundry_block",
            () -> new BasicFoundryBlock(BlockBehaviour.Properties.of().noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> BASIC_ALLOYER_BLOCK = registerBlock("basic_alloyer_block",
            () -> new BasicAlloyerBlock(BlockBehaviour.Properties.of().noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> BASIC_TANK_BLOCK = registerBlock("basic_tank_block",
            () -> new BasicTankBlock(BlockBehaviour.Properties.of().noOcclusion()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItems(name, toReturn);
        return toReturn;
    }


    private static <T extends Block> void registerBlockItems(String name, RegistryObject<T> block) {
            ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);

    }

}
