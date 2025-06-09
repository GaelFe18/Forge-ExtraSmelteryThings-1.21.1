package net.GaelFe18.ExtraSmelteryThings.datagen;

import net.GaelFe18.ExtraSmelteryThings.ExtraSmelteryThings;
import net.GaelFe18.ExtraSmelteryThings.item.ModItems;
import net.GaelFe18.ExtraSmelteryThings.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> providerCompletableFuture,
                              CompletableFuture<TagLookup<Block>> tagLookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, providerCompletableFuture, tagLookupCompletableFuture, ExtraSmelteryThings.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Items.MOLTENORES)
                .add(ModItems.MOLTEN_IRON.get())
                .add(ModItems.MOLTEN_CARBON_STEEL.get());
        tag(ModTags.Items.HIGHFUELITEMS)
                .add(ModItems.BURNING_COAL.get())
                .add(Items.LAVA_BUCKET);
        tag(ModTags.Items.MIDFUELITEMS)
                .add(ModItems.COKE.get());
        tag(ModTags.Items.LOWFUELITEMS)
                .add(Items.COAL)
                .add(Items.CHARCOAL);
    }

}
