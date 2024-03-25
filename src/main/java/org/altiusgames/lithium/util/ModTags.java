package org.altiusgames.lithium.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.altiusgames.lithium.Lithium;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> LITHIUM_REACTIVE = tag("lithium_reactive");
        public static final TagKey<Block> NEEDS_LITHIUM_TOOL = tag("needs_lithium_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Lithium.MOD_ID, name));
        }
    }

    public static class Items {


        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Lithium.MOD_ID, name));
        }
    }
}
