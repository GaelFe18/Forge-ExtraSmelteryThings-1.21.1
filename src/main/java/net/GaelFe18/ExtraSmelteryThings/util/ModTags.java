package net.GaelFe18.ExtraSmelteryThings.util;

import net.GaelFe18.ExtraSmelteryThings.ExtraSmelteryThings;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{
        //poner tag aca!!

        private static TagKey<Block> createTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(ExtraSmelteryThings.MOD_ID, name));
        }
    }
    public static class Items{
        public static TagKey<Item> MOLTENORES = createTag("molten_ores");
        public static TagKey<Item> HIGHFUELITEMS = createTag("high_fuels");
        public static TagKey<Item> MIDFUELITEMS = createTag("mid_fuels");
        public static TagKey<Item> LOWFUELITEMS = createTag("low_fuels");
        //poner tag aca!!

        private static TagKey<Item> createTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(ExtraSmelteryThings.MOD_ID, name));

        }
    }
}
