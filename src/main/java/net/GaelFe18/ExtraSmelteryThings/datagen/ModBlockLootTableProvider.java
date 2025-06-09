package net.GaelFe18.ExtraSmelteryThings.datagen;

import net.GaelFe18.ExtraSmelteryThings.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags() ,pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.BASIC_ALLOYER_BLOCK.get());
        dropSelf(ModBlocks.BASIC_FOUNDRY_BLOCK.get());
        dropSelf(ModBlocks.BASIC_TANK_BLOCK.get());
        dropSelf(ModBlocks.DIRTY_RAW_IRON_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
