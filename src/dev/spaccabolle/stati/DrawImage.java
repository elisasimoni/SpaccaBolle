package dev.spaccabolle.stati;

import java.awt.Graphics;

import dev.spaccabolle.Launcher;
import dev.spaccabolle.entity.CollectBall;
import dev.spaccabolle.gfx.Assets;

public class DrawImage {
	
	public void render(Graphics g) {
		if(StatoMenu.run) {
			 g.drawImage(Assets.dark_background, 0, 0, Launcher.GAME_WIDTH, Launcher.GAME_HEIGHT, null);
			 
			 g.drawImage(Assets.btn_save, 40, 800, 200, 90, null);
			 g.drawImage(Assets.btn_pause, 330, 800, 200, 90, null);
			 g.drawImage(Assets.btn_exit_statoGioco, 600, 800, 200, 90, null);
			 
			 StatoGioco.cannon.render(g);
			 StatoGioco.collectBallMap.render(g);
			 StatoGioco.collectBall.render(g);
			 
			 if(StatoGioco.pause) {
				StatoGioco.paused.render(g);	
			 }
			    
			 if(StatoGioco.exit) {
			    g.drawImage(Assets.quitGame, 200, 200, 400, 400, null);
			 }
			 if(CollectBall.victory) {
				 g.drawImage(Assets.dragon, 350, StatoGioco.yDragon, 150, 150, null);
			 }
		}else {
			g.drawImage(Assets.dark_background, 0, 0, Launcher.GAME_WIDTH, Launcher.GAME_HEIGHT, null);
			g.drawImage(Assets.logo, 70, StatoMenu.yMovelogo, 650, 650, null);
			g.drawImage(Assets.dragon, StatoMenu.xDragon, StatoMenu.yDragon, StatoMenu.dimDragon, StatoMenu.dimDragon, null);
			StatoMenu.uiManager.render(g);
		}
	}
}
