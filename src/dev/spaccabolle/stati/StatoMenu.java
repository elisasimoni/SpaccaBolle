package dev.spaccabolle.stati;

import java.awt.Graphics;
import java.io.File;

import javax.swing.JFileChooser;

import dev.spaccabolle.Handler;
import dev.spaccabolle.Launcher;
import dev.spaccabolle.display.Display;
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

		uiManager.addObject(new UIImageButton(50, 600, 220, 150, Assets.btn_start, new ClickListener() {
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				Stato.setState(handler.getGame().gameState);
			}
		}));
		uiManager.addObject(new UIImageButton(308, 600, 220, 150, Assets.btn_load, new ClickListener() {
                    public void onClick() {
                            File file;
                            file=Display.getFile();
                            System.out.println(file);
                    }
            }));
		uiManager.addObject(new UIImageButton(566, 600, 220, 150, Assets.btn_exit, new ClickListener() {
                    public void onClick() {
                            handler.getMouseManager().setUIManager(null);
                            Display.closeDisplay();
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
