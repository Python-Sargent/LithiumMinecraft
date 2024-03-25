package org.altiusgames.lithium.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.LITHIUM_SWORD.get())
                .pattern(" L ")
                .pattern(" L ")
                .pattern(" S ")
                .define('L', ModItems.LITHIUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.LITHIUM_INGOT.get()), has(ModItems.LITHIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.LITHIUM_PICKAXE.get())
                .pattern("LLL")
                .pattern(" S ")
                .pattern(" S ")
                .define('L', ModItems.LITHIUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.LITHIUM_INGOT.get()), has(ModItems.LITHIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.LITHIUM_AXE.get())
                .pattern("LL ")
                .pattern("LS ")
                .pattern(" S ")
                .define('L', ModItems.LITHIUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.LITHIUM_INGOT.get()), has(ModItems.LITHIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.LITHIUM_SHOVEL.get())
                .pattern(" L ")
                .pattern(" S ")
                .pattern(" S ")
                .define('L', ModItems.LITHIUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.LITHIUM_INGOT.get()), has(ModItems.LITHIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.LITHIUM_HOE.get())
                .pattern(" LL")
                .pattern(" S ")
                .pattern(" S ")
                .define('L', ModItems.LITHIUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.LITHIUM_INGOT.get()), has(ModItems.LITHIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.LITHIUM_HELMET.get())
                .pattern("LLL")
                .pattern("L L")
                .pattern("   ")
                .define('L', ModItems.LITHIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.LITHIUM_INGOT.get()), has(ModItems.LITHIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.LITHIUM_CHESTPLATE.get())
                .pattern("L L")
                .pattern("LLL")
                .pattern("LLL")
                .define('L', ModItems.LITHIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.LITHIUM_INGOT.get()), has(ModItems.LITHIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.LITHIUM_LEGGINGS.get())
                .pattern("LLL")
                .pattern("L L")
                .pattern("L L")
                .define('L', ModItems.LITHIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.LITHIUM_INGOT.get()), has(ModItems.LITHIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.LITHIUM_BOOTS.get())
                .pattern("   ")
                .pattern("L L")
                .pattern("L L")
                .define('L', ModItems.LITHIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.LITHIUM_INGOT.get()), has(ModItems.LITHIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.LITHIUM_POWER_ORB.get())
                .pattern(" L ")
                .pattern("LBL")
                .pattern(" L ")
                .define('L', ModItems.LITHIUM_INGOT.get())
                .define('B', Items.BLAZE_ROD)
                .unlockedBy(getHasName(ModItems.LITHIUM_INGOT.get()), has(ModItems.LITHIUM_INGOT.get()))
                .unlockedBy(getHasName(Items.BLAZE_ROD), has(Items.BLAZE_ROD))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.GILDED_LITHORIUM.get())
                .pattern("ggg")
                .pattern("gLg")
                .pattern("ggg")
                .define('L', ModItems.LITHORIUM.get())
                .define('g', Items.GOLD_NUGGET)
                .unlockedBy(getHasName(ModItems.LITHORIUM.get()), has(ModItems.LITHORIUM.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LITHIUM_RADIATOR.get())
                .pattern("LLL")
                .pattern("LML")
                .pattern("LLL")
                .define('L', ModItems.LITHIUM_INGOT.get())
                .define('M', Items.MAGMA_CREAM)
                .unlockedBy(getHasName(ModItems.LITHIUM_INGOT.get()), has(ModItems.LITHIUM_INGOT.get()))
                .save(consumer);

        blockRecipe(consumer, ModBlocks.LITHIUM_BLOCK.get(), ModItems.LITHIUM_INGOT.get());
        blockRecipe(consumer, ModBlocks.RAW_LITHIUM_BLOCK.get(), ModItems.LITHIUM.get());
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
