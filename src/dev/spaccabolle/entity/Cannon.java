package dev.spaccabolle.entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Random;

import dev.spaccabolle.Launcher;
import dev.spaccabolle.gfx.Assets;
import dev.spaccabolle.input.KeyManager;

public class Cannon extends DynamicObject{
    
    private static final int SCARTO_X_FRECCIA=34;
    private static final int SCARTO_X_BOLLA=23;
    private static final int SCARTO_Y_BOLLA=15;

    
    private boolean ballPos;
    private Random rand = new Random();
    
    private Ball ball;
    private CollectBall collectBall;
    
    private int angle=0;

    public Cannon(float x, float y, int width, int height, CollectBall collectBall) {
        super(x, y, width, height);
        this.collectBall=collectBall;
        this.setSpeed(5);
        this.ballPos=true;
        
        ball=new Ball(this.x+width/2-SCARTO_X_BOLLA,this.y+SCARTO_Y_BOLLA,50,50,getColor());
        while(ball.color==0) {
        
        	ball=new Ball(this.x+width/2-SCARTO_X_BOLLA,this.y+SCARTO_Y_BOLLA,50,50,getColor());
        	
        }
        collectBall.addBall(ball);
    }

    private int getColor() {
        return rand.nextInt(4);
    }
    
    private void getInput() {
        if(KeyManager.right && this.angle<60)
            angle += (int) speed;
        if(KeyManager.left && this.angle>-60)
            angle += (int)-speed;
    }
    
    private void newBall() {
        if(!ball.isMove && !ballPos ) {
            ball=new Ball(this.x+width/2-SCARTO_X_BOLLA,this.y+SCARTO_Y_BOLLA,50,50,getColor());
            while(ball.color==0) {
                
            	ball=new Ball(this.x+width/2-SCARTO_X_BOLLA,this.y+SCARTO_Y_BOLLA,50,50,getColor());
            	
            }
            collectBall.addBall(ball);
            ballPos=true;
            System.out.println("ball creata");
        }
     }
    
    private void shot() {
        if(ballPos && KeyManager.enter) {
            System.out.println("ball shot");
            ball.directMove=(float) Math.toDegrees(Math.toRadians(angle-90));
            ball.direct();
            ball.isMove=true;
            ballPos=false;
        }
    }
    
    public void tick() {
        getInput();
        shot();
        newBall();
    }

    public void render(Graphics g) {
        AffineTransform at = AffineTransform.getTranslateInstance(Launcher.GAME_WIDTH/2-Cannon.SCARTO_X_FRECCIA,674);
        at.rotate(Math.toRadians(angle),Assets.arrow.getWidth()/2,Assets.arrow.getHeight()/2);
        at.scale(1,1);
        Graphics2D g2 = (Graphics2D)g;
        g.drawImage(Assets.cannon,(int)this.getX(),(int)this.getY(), this.getWidth(), this.getHeight(), null);
        g2.drawImage(Assets.arrow, at, null);
    }

}
