package br.com.capfood.client.screen;

import br.com.capfood.client.screen.component.CapBasePanel;
import br.com.capfood.client.screen.component.GlobalOptionEntry;
import br.com.capfood.client.screen.component.HoverOnlyButton;
import br.com.capfood.config.CapFoodConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public final class CapFoodGlobalOptionsScreen extends Screen {
	private static final int MAX_CONTENT_WIDTH = 540;
	private static final int SIDE_MARGIN = 16;
	private static final int OPTIONS_TOP = 137;
	private static final int OPTION_HEIGHT = 30;
	private static final int BUTTON_GAP = 8;

	private final Screen parent;
	private final CapBasePanel basePanel = new CapBasePanel();
	private boolean consumeContainer;
	private boolean showFoodProperties;
	private Component status = Component.empty();
	private int statusColor = 0xFF9CD67A;

	public CapFoodGlobalOptionsScreen(Screen parent) {
		super(Component.translatable("capfood.options.title"));
		this.parent = parent;
	}

	@Override
	protected void init() {
		int contentWidth = Math.min(MAX_CONTENT_WIDTH, this.width - SIDE_MARGIN * 2);
		int left = (this.width - contentWidth) / 2;
		this.consumeContainer = CapFoodConfig.consumeContainer();
		this.showFoodProperties = CapFoodConfig.showFoodProperties();

		this.addRenderableWidget(new GlobalOptionEntry(
			left,
			OPTIONS_TOP,
			contentWidth,
			OPTION_HEIGHT,
				Component.translatable("capfood.options.consume_container"),
			Component.translatable("capfood.options.consume_container.description"),
			this.consumeContainer,
			selected -> this.consumeContainer = selected
		));
		this.addRenderableWidget(new GlobalOptionEntry(
			left,
			OPTIONS_TOP + OPTION_HEIGHT,
			contentWidth,
			OPTION_HEIGHT,
			Component.translatable("capfood.options.show_food_properties"),
			Component.translatable("capfood.options.show_food_properties.description"),
			this.showFoodProperties,
			selected -> this.showFoodProperties = selected
		));

		int buttonY = this.height - 36;
		int buttonWidth = (contentWidth - BUTTON_GAP) / 2;
		this.addRenderableWidget(new HoverOnlyButton(
			left,
			buttonY,
			buttonWidth,
			20,
			Component.translatable("capfood.action.back"),
			button -> this.onClose()
		));
		this.addRenderableWidget(new HoverOnlyButton(
			left + buttonWidth + BUTTON_GAP,
			buttonY,
			contentWidth - buttonWidth - BUTTON_GAP,
			20,
			accentedApplyLabel(),
			button -> this.applyOptions()
		));
	}

	private void applyOptions() {
		boolean saved = CapFoodConfig.saveGlobalOptions(this.consumeContainer, this.showFoodProperties);
		this.status = Component.translatable(saved ? "capfood.options.status.applied" : "capfood.status.save_failed");
		this.statusColor = saved ? 0xFF9CD67A : 0xFFFF6B6B;
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float delta) {
		graphics.fill(0, 0, this.width, this.height, 0xD0101010);

		int contentWidth = Math.min(MAX_CONTENT_WIDTH, this.width - SIDE_MARGIN * 2);
		int left = (this.width - contentWidth) / 2;
		graphics.centeredText(this.font, Component.translatable("capfood.title"), this.width / 2, 14, 0xFFFFFFFF);
		graphics.centeredText(
			this.font,
			Component.translatable("capfood.options.subtitle"),
			this.width / 2,
			29,
			0xFFBDBDBD
		);

		this.basePanel.render(graphics, this.font, left, 47, contentWidth);
		graphics.text(this.font, this.title, left + 4, 123, 0xFFE0E0E0, true);
		super.extractRenderState(graphics, mouseX, mouseY, delta);

		if (!this.status.getString().isEmpty()) {
			graphics.centeredText(this.font, this.status, this.width / 2, this.height - 49, this.statusColor);
		}
	}

	private static Component accentedApplyLabel() {
		return Component.empty()
			.append(Component.literal("■ ").withStyle(ChatFormatting.GREEN))
			.append(Component.translatable("capfood.action.apply"));
	}

	@Override
	public void onClose() {
		this.status = Component.empty();
		this.minecraft.gui.setScreen(this.parent);
	}
}
