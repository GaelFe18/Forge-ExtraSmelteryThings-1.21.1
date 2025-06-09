package net.GaelFe18.ExtraSmelteryThings.block.entity;

import net.GaelFe18.ExtraSmelteryThings.ExtraSmelteryThings;
import net.GaelFe18.ExtraSmelteryThings.block.ModBlocks;
import net.GaelFe18.ExtraSmelteryThings.block.entity.custom.BasicAlloyerBlockEntity;
import net.GaelFe18.ExtraSmelteryThings.block.entity.custom.BasicFoundryBlockEntity;
import net.GaelFe18.ExtraSmelteryThings.block.entity.custom.BasicTankBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ExtraSmelteryThings.MOD_ID);

    public static final RegistryObject<BlockEntityType<BasicTankBlockEntity>> BASIC_TANK_BLOCK_BE =
            BLOCK_ENTITIES.register("basic_tank_block_be", () -> BlockEntityType.Builder.of(
                    BasicTankBlockEntity::new, ModBlocks.BASIC_TANK_BLOCK.get()).build(null));

    public static final RegistryObject<BlockEntityType<BasicFoundryBlockEntity>> BASIC_FOUNDRY_BLOCK_BE =
            BLOCK_ENTITIES.register("basic_foundry_block_be", () -> BlockEntityType.Builder.of(
                    BasicFoundryBlockEntity::new, ModBlocks.BASIC_FOUNDRY_BLOCK.get()).build(null));

    public static final RegistryObject<BlockEntityType<BasicAlloyerBlockEntity>> BASIC_ALLOYER_BLOCK_BE =
            BLOCK_ENTITIES.register("basic_alloyer_block_be", () -> BlockEntityType.Builder.of(
                    BasicAlloyerBlockEntity::new, ModBlocks.BASIC_ALLOYER_BLOCK.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);

    }

}
