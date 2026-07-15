package br.com.capfood.client;

import br.com.capfood.client.screen.CapFoodScreen;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

public final class CapFoodModMenuIntegration implements ModMenuApi {
	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return CapFoodScreen::new;
	}
}
