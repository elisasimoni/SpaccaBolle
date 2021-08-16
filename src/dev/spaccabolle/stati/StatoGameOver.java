package dev.spaccabolle.stati;

import java.awt.Graphics;
import java.io.IOException;

import dev.spaccabolle.Handler;
import dev.spaccabolle.Launcher;
import dev.spaccabolle.entity.Ball;
import dev.spaccabolle.entity.Cannon;
import dev.spaccabolle.entity.CollectBall;
import dev.spaccabolle.gfx.Assets;
import dev.spaccabolle.entity.Map;

public class StatoGameOver extends Stato{
    
        
    
	public StatoGameOver(Handler handler) {
		super(handler);
		if(CollectBall.gameOver) {
		Stato.setState(handler.getGame().gameOverState);
		}
	}
	
	public void tick() {
	   
	}
	public boolean isGameOver() {
		return CollectBall.gameOver;
	}
	public void render(Graphics g) {
	    g.drawImage(Assets.dark_background, 0, 0, Launcher.GAME_WIDTH, Launcher.GAME_HEIGHT, null);
	    g.drawImage(Assets.game_over, 150,150, Launcher.GAME_WIDTH/2, Launcher.GAME_HEIGHT/2, null);
	}
}