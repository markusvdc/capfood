package br.com.capfood.gameplay;

import br.com.capfood.config.CapFoodConfig;
import java.util.Set;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public final class PrimaryFoodPolicy {
	private static final Set<Item> PRIMARY_FOODS = Set.of(
		Items.BEETROOT,
		Items.CARROT,
		Items.POTATO,
		Items.BEEF,
		Items.CHICKEN,
		Items.MUTTON,
		Items.PORKCHOP,
		Items.RABBIT,
		Items.PUFFERFISH,
		Items.COD,
		Items.SALMON,
		Items.TROPICAL_FISH
	);

	private PrimaryFoodPolicy() {
	}

	public static boolean preventConsumption(LivingEntity user, ItemStack stack) {
		return CapFoodConfig.preventPrimaryFoodConsumption()
			&& user instanceof Player
			&& PRIMARY_FOODS.contains(stack.getItem());
	}
}
