package br.com.capfood.mixin;

import br.com.capfood.gameplay.CapFoodAttributes;
import br.com.capfood.gameplay.PrimaryFoodPolicy;
import java.util.stream.Stream;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.ConsumableListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Consumable.class)
public abstract class ConsumableMixin {
	@Inject(method = "canConsume", at = @At("HEAD"), cancellable = true)
	private void capfood$preventPrimaryFoodConsumption(
		LivingEntity user,
		ItemStack stack,
		CallbackInfoReturnable<Boolean> callback
	) {
		if (PrimaryFoodPolicy.preventConsumption(user, stack)) {
			callback.setReturnValue(false);
		}
	}

	@Redirect(
		method = "onConsume",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/world/item/ItemStack;getAllOfType(Ljava/lang/Class;)Ljava/util/stream/Stream;"
		)
	)
	private Stream<ConsumableListener> capfood$replaceFoodListener(
		ItemStack stack,
		Class<? extends ConsumableListener> valueClass
	) {
		Stream<ConsumableListener> originalListeners = stack.getAllOfType(valueClass);
		return CapFoodAttributes.overrideConsumableListeners(stack, originalListeners);
	}
}
