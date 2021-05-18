package dev.spaccabolle.entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Random;


import dev.spaccabolle.Game;
import dev.spaccabolle.Launcher;
import dev.spaccabolle.gfx.Assets;
import dev.spaccabolle.input.KeyManager;

public class Cannon extends DynamicObject{
    
    private static final int SCARTO_X_FRECCIA=34;
    
    private Game game;
    
    private boolean ballPos;
    private Random rand = new Random();
    
    private int angle=0;
    private int i;

    public Cannon(float x, float y, int width, int height) {
        super(x, y, width, height);
        this.setSpeed(5);
        this.ballPos=true;
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
    
    public void tick() {
        getInput();
    }

    public void render(Graphics g) {
        AffineTransform at = AffineTransform.getTranslateInstance(Launcher.GAME_WIDTH/2-this.SCARTO_X_FRECCIA,674);
        at.rotate(Math.toRadians(angle),Assets.arrow.getWidth()/2,Assets.arrow.getHeight()/2);
        at.scale(1,1);
        Graphics2D g2 = (Graphics2D)g;
        g.drawImage(Assets.cannon,(int)this.getX(),(int)this.getY(), this.getWidth(), this.getHeight(), null);
        g2.drawImage(Assets.arrow, at, null);
    }

}
