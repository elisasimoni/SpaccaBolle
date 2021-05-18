package dev.spaccabolle.stati;

import java.awt.Graphics;

import dev.spaccabolle.Handler;
import dev.spaccabolle.entity.Cannon;
import dev.spaccabolle.gfx.Assets;
import dev.spaccabolle.*;

public class StatoGioco extends Stato{
    
        private static final int CANNON_X=(Launcher.GAME_WIDTH/2)-(Assets.cannon.getWidth()/2);
        private static final int SCARTO=100;
        private static final int CANNON_Y=(Launcher.GAME_HEIGHT/2)+Assets.cannon.getHeight()+SCARTO;
    
        private Cannon cannon;
	
	public StatoGioco(Handler handler){
		super(handler);
		cannon = new Cannon(CANNON_X, CANNON_Y, Assets.cannon.getWidth(), Assets.cannon.getHeight());
	}
	
	public void tick() {
	    cannon.tick();
	}

	public void render(Graphics g) {
	    g.drawImage(Assets.dark_background, 0, 0, Launcher.GAME_WIDTH, Launcher.GAME_HEIGHT, null);
	    cannon.render(g);
	}
}
