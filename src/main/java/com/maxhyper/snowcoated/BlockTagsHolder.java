package com.maxhyper.snowcoated;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.tags.ITag;

public class BlockTagsHolder {

    public static TagKey<Block> snowLayerBlacklist;
    public static TagKey<Block> snowLayerWhitelist;

    public static void fetchTags(){
        snowLayerBlacklist = BlockTags.create(SnowCoatedAPI.resloc("snow_layer_blacklist"));
        snowLayerWhitelist = BlockTags.create(SnowCoatedAPI.resloc("snow_layer_whitelist"));
    }

}
