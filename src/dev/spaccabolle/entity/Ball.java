package dev.spaccabolle.entity;

import java.awt.Graphics;
import dev.spaccabolle.Launcher;
import dev.spaccabolle.gfx.Assets;


public class Ball extends DynamicObject{
    
    public static final int LEFT_BOUNCE = Launcher.GAME_WIDTH/2-200;
    private static final int RIGHT_BOUNCE = Launcher.GAME_WIDTH/2+200;
    public static final int BOBBLE_SIZE = 50;
   

    public float directMove;
    private int color;
    public boolean isMove;

    public Ball(float x, float y, int width, int height, int color) {
        super(x, y, width, height);
        this.color=color;
        this.directMove=0;
        this.isMove=false;

        System.out.println("ball creata");
        


    }
    
    public void direct() {
        this.setxMove(Math.cos(Math.toRadians(directMove))*this.speed);
        this.setyMove(Math.sin(Math.toRadians(directMove))*this.speed);
    }
    
    private void destroy() {
        if(this.y < 0) {
            this.isMove=false;
        }
    }

    public void tick() {
        if(isMove) {
            if(this.x < LEFT_BOUNCE|| this.x > RIGHT_BOUNCE)
                this.xMove*=-1;
            move();
            destroy();
        }
    }

    public void render(Graphics g) {
    	
		g.drawImage(Assets.ballGroup[color], (int)x, (int)y, width, height, null);
    }

}