package br.com.capfood.gameplay;

import br.com.capfood.config.CapFoodConfig;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;

public final class ContainerRemainderPolicy {
	private ContainerRemainderPolicy() {
	}

	public static boolean suppresses(ItemStack stack, DataComponentType<?> type) {
		if (type != DataComponents.USE_REMAINDER || !CapFoodConfig.consumeContainer()) {
			return false;
		}

		return CapFoodConfig.isAllowed(stack.getItem())
			&& stack.getComponents().has(DataComponents.FOOD)
			&& stack.getComponents().has(DataComponents.USE_REMAINDER);
	}
}
