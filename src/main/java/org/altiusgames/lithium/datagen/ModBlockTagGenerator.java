package org.altiusgames.lithium.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.altiusgames.lithium.Lithium;
import org.altiusgames.lithium.block.ModBlocks;
import org.altiusgames.lithium.util.ModTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator  extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Lithium.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(ModTags.Blocks.LITHIUM_REACTIVE)
                .add(ModBlocks.LITHIUM_RADIATOR.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.LITHIUM_BLOCK.get(), ModBlocks.LITHIUM_RADIATOR.get(),
                        ModBlocks.LITHIUM_ORE.get(), ModBlocks.DEEPSLATE_LITHIUM_ORE.get(),
                        ModBlocks.RAW_LITHIUM_BLOCK.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.LITHIUM_BLOCK.get(), ModBlocks.LITHIUM_RADIATOR.get(),
                        ModBlocks.LITHIUM_ORE.get(), ModBlocks.DEEPSLATE_LITHIUM_ORE.get(),
                        ModBlocks.RAW_LITHIUM_BLOCK.get());

        this.tag(ModTags.Blocks.NEEDS_LITHIUM_TOOL);

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.LITHIUM_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.LITHIUM_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.LITHIUM_WALL.get());
    }
}
