package br.com.capfood.mixin;

import br.com.capfood.config.CapFoodConfig;
import net.minecraft.world.entity.animal.wolf.Wolf;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Wolf.class)
public abstract class WolfMixin {
	@Inject(method = "isFood", at = @At("HEAD"), cancellable = true)
	private void capfood$preventRottenFleshFeeding(
		ItemStack itemStack,
		CallbackInfoReturnable<Boolean> callback
	) {
		if (CapFoodConfig.preventRottenFleshWolfFeeding() && itemStack.is(Items.ROTTEN_FLESH)) {
			callback.setReturnValue(false);
		}
	}
}
