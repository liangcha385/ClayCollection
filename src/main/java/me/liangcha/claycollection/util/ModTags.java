package me.liangcha.claycollection.util;

import me.liangcha.claycollection.ClayCollection;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class ModTags {
    public static class Blocks {
        public static final Tags.IOptionalNamedTag<Block> dowsingRadValuables = tag("dowsing_businesscard");

        private static Tags.IOptionalNamedTag<Block> tag(String name){
            return BlockTags.createOptional(new ResourceLocation(ClayCollection.MOD_ID, name));
        }
    }

    public static class items {
        public static final Tags.IOptionalNamedTag<Item> cards = forgeTags("clay/cards");

        private static Tags.IOptionalNamedTag<Item> forgeTags(String name){
            return ItemTags.createOptional(new ResourceLocation("forge", name));
        }
    }
}
