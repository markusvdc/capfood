package br.com.capfood.mixin;

import br.com.capfood.gameplay.CapFoodAttributes;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.level.block.CakeBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CakeBlock.class)
public abstract class CakeBlockMixin {
	@Redirect(
		method = "eat",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/world/food/FoodData;eat(IF)V"
		)
	)
	private static void capfood$applyCapToSlice(
		FoodData foodData,
		int vanillaNutrition,
		float vanillaSaturationModifier
	) {
		CapFoodAttributes.applyCakeSlice(foodData, vanillaNutrition, vanillaSaturationModifier);
	}
}
