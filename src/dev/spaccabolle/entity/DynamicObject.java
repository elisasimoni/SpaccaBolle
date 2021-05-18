package dev.spaccabolle.entity;

public abstract class DynamicObject extends Entity{
    
    public static final int DEFAULT_SPEED = 10;
    
    protected float speed;
    protected double xMove,yMove;

    public DynamicObject(float x, float y, int width, int height) {
        super(x, y, width, height);
        speed=this.DEFAULT_SPEED;
        xMove=0;
        yMove=0;
    }
    
    public void move() {
        x += xMove;
        y += yMove;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public double getxMove() {
        return xMove;
    }

    public void setxMove(double xMove) {
        this.xMove = xMove;
    }

    public double getyMove() {
        return yMove;
    }

    public void setyMove(double yMove) {
        this.yMove = yMove;
    }

}
