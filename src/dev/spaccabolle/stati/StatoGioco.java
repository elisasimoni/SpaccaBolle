package dev.spaccabolle.stati;

import java.awt.Graphics;

import dev.spaccabolle.Handler;
import dev.spaccabolle.entity.Cannon;
import dev.spaccabolle.gfx.Assets;

public class StatoGioco extends Stato{
    
        private Cannon cannon;
	
	public StatoGioco(Handler handler){
		super(handler);
		cannon = new Cannon(0, 0, Assets.cannon.getWidth(), Assets.cannon.getHeight());
	}
	
	public void tick() {
	    cannon.tick();
	}

	public void render(Graphics g) {
	    cannon.render(g);
	}
}
