package br.com.capfood;

import br.com.capfood.config.CapFoodConfig;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CapFood implements ModInitializer {
	public static final String MOD_ID = "capfood";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		CapFoodConfig.load();
	}
}
