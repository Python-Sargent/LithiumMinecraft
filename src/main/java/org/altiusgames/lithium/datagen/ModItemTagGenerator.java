package org.altiusgames.lithium.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.altiusgames.lithium.Lithium;
import org.altiusgames.lithium.item.ModItems;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture, CompletableFuture<TagLookup<Block>> completableFuture1, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, completableFuture1, Lithium.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.LITHIUM_HELMET.get(),
                        ModItems.LITHIUM_CHESTPLATE.get(),
                        ModItems.LITHIUM_LEGGINGS.get(),
                        ModItems.LITHIUM_BOOTS.get());

        this.tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.LITHIUM_INGOT.get());
        this.tag(ItemTags.MUSIC_DISCS)
                .add(ModItems.DISC_84.get());
    }
}
