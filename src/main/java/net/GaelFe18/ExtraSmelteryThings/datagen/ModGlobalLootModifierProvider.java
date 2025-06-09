package net.GaelFe18.ExtraSmelteryThings.datagen;

import net.GaelFe18.ExtraSmelteryThings.ExtraSmelteryThings;
import net.GaelFe18.ExtraSmelteryThings.block.ModBlocks;
import net.GaelFe18.ExtraSmelteryThings.item.ModItems;
import net.GaelFe18.ExtraSmelteryThings.loot.SetItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, ExtraSmelteryThings.MOD_ID, registries);
    }

    @Override
    protected void start(HolderLookup.Provider registries) {
        this.add("dirty_raw_iron_from_iron_ore",
                new SetItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.IRON_ORE).build(),
                        LootItemRandomChanceCondition.randomChance(1).build()}, ModItems.DIRTY_RAW_IRON.get()));
        this.add("dirty_raw_iron_from_deepslate_iron_ore",
                new SetItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_IRON_ORE).build(),
                        LootItemRandomChanceCondition.randomChance(1).build()}, ModItems.DIRTY_RAW_IRON.get()));
        this.add("dirty_raw_iron_from_raw_iron_block",
                new SetItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.RAW_IRON_BLOCK).build(),
                        LootItemRandomChanceCondition.randomChance(1).build()}, ModBlocks.DIRTY_RAW_IRON_BLOCK.get().asItem()));
    }
}
