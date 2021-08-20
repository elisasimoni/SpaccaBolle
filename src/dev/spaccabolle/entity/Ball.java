package dev.spaccabolle.entity;

import java.awt.Graphics;


import dev.spaccabolle.Launcher;
import dev.spaccabolle.gfx.Assets;



public class Ball extends DynamicObject{
    
    public static final int LEFT_BOUNCE = Launcher.GAME_WIDTH/2-200;
    public static final int RIGHT_BOUNCE = Launcher.GAME_WIDTH/2+200;
    public static final int BOBBLE_SIZE = 70;
   

    public float directMove;
    public int color,index;
   

    public boolean isMove;
    

    public Ball(float x, float y, int width, int height, int color,int index) {
        super(x, y, width, height);
        this.color=color;
        this.index=index;
        this.directMove=0;
        this.isMove=false;

    }
    public int getColor() {
	return this.color;
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
    public void eliminate() {
    	this.setHeight(0);
    	this.setWidth(0);
    }
    
    public void ballStatus() {
    	Ball b = new Ball(this.x, this.y, this.height, this.width, this.color,++Map.index);
    	this.index=Map.index;
    	Map.collectBallMap.addBall(b);/*aggiungo la bolla alla mappa*/
    	
    
    	
    }
    public void tick() {
    	
        if(isMove) {
            if(this.x < 0|| this.x > 840) {
            	  this.xMove*=-1;
            }
            
            
            if(Map.collectBallMap.check(this.x,this.y,getBall())) {
            	this.isMove=false;   
                ballStatus();
                eliminate();  
                if(Map.collectBallMap.tris()) {
                	eliminate();
                }
                
            }
            
            
            
            move();
        }
        
    }
    
    

    public void render(Graphics g) {
    	
		g.drawImage(Assets.ballGroup[color], (int)x, (int)y, width, height, null);
    }
    
    private Ball getBall() {
        return this;
    }

}
