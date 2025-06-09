package net.GaelFe18.ExtraSmelteryThings.datagen;

import net.GaelFe18.ExtraSmelteryThings.ExtraSmelteryThings;
import net.GaelFe18.ExtraSmelteryThings.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {


    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ExtraSmelteryThings.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.BURNING_COAL.get());
        basicItem(ModItems.COKE.get());
        basicItem(ModItems.CARBON_STEEL.get());
        basicItem(ModItems.MOLTEN_CARBON_STEEL.get());
        basicItem(ModItems.MOLTEN_IRON.get());
        basicItem(ModItems.DIRTY_RAW_IRON.get());
        basicItem(ModItems.ORES_POLISHER.get());
    }
}
