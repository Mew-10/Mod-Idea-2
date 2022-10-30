package net.benjamin.ideag.util;

import net.benjamin.ideag.IdeagMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.Tags;

import java.util.List;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> GODLEY_STAFF_OF_POWER_VALUABLES =
                tag("godley_staff_of_power_valuables");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(IdeagMod.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }


}
