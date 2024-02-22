package org.altiusgames.lithium.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.altiusgames.lithium.Lithium;
import org.altiusgames.lithium.block.ModBlocks;
import org.altiusgames.lithium.item.ModItems;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> LITHIUM_SMELTABLES = List.of(ModItems.LITHIUM.get(),
            ModBlocks.LITHIUM_ORE.get(), ModBlocks.DEEPSLATE_LITHIUM_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
            oreBlasting(consumer, LITHIUM_SMELTABLES, RecipeCategory.MISC, ModItems.LITHIUM.get(), 0.25f, 150, "lithium");
            oreSmelting(consumer, LITHIUM_SMELTABLES, RecipeCategory.MISC, ModItems.LITHIUM.get(), 0.25f, 200, "lithium");

//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LITHIUM_BLOCK.get())
//                .pattern("LLL")
//                .pattern("LLL")
//                .pattern("LLL")
//                .define('L', ModItems.LITHIUM_INGOT.get())
//                .unlockedBy(getHasName(ModItems.LITHIUM_INGOT.get()), has(ModItems.LITHIUM_INGOT.get()))
//                .save(consumer);
//
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LITHIUM_INGOT.get(), 9)
//                .requires(ModBlocks.LITHIUM_BLOCK.get())
//                .unlockedBy(getHasName(ModBlocks.LITHIUM_BLOCK.get()), has(ModBlocks.LITHIUM_BLOCK.get()))
//                .save(consumer);

        blockRecipe(consumer, ModBlocks.LITHIUM_BLOCK.get(), ModItems.LITHIUM_INGOT.get());
    }

    private void blockRecipe(@NotNull Consumer<FinishedRecipe> consumer, Block block, Item base) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, block)
                .pattern("LLL")
                .pattern("LLL")
                .pattern("LLL")
                .define('L', base)
                .unlockedBy(getHasName(base), has(base))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, base, 9)
                .requires(block)
                .unlockedBy(getHasName(block), has(block))
                .save(consumer);
    }

    protected static void oreSmelting(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTIme, @NotNull String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTime, @NotNull String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer, @NotNull RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTime, @NotNull String pGroup, String pRecipeName) {

        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, Lithium.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
