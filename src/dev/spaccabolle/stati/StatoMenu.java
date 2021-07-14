package dev.spaccabolle.stati;

import java.awt.Graphics;
import dev.spaccabolle.Handler;
import dev.spaccabolle.Launcher;
import dev.spaccabolle.gfx.Assets;
import dev.spaccabolle.ui.ClickListener;
import dev.spaccabolle.ui.UIImageButton;
import dev.spaccabolle.ui.UIManager;

public class StatoMenu extends Stato{

	private UIManager uiManager;

	public StatoMenu(Handler handler) {
		
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);

		uiManager.addObject(new UIImageButton(308, 700, 220, 150, Assets.btn_start, new ClickListener() {
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				Stato.setState(handler.getGame().gameState);
			}
		}));
	}

	public void tick() {
		uiManager.tick();
	}

	public void render(Graphics g) {
		
		g.drawImage(Assets.dark_background, 0, 0, Launcher.GAME_WIDTH, Launcher.GAME_HEIGHT, null);
		g.drawImage(Assets.logo, 70, 70, 650, 650, null);
		uiManager.render(g);
		
	}
}
