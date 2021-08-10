package dev.spaccabolle.entity;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class CollectBall {
    
	/*lista bolle nel cannone*/
    private ArrayList<Ball> collectionBall;
    

    public CollectBall() {
        collectionBall = new ArrayList<>();
    }
    
    /*carica  l'array*/
    public void tick() {
        Iterator<Ball> ba = collectionBall.iterator();
        while(ba.hasNext()) {
            Ball b = ba.next(); 	
            b.tick();
        }
    }
    
  
    public int numBolle() {
        return collectionBall.size();
    }
    

	public float cordX(Ball b) {
		return b.x;
    	
    }
	public float cordY(Ball b) {
		return b.y;
    	
    }
	
	public boolean check(float coordinateX,float coordinateY,Ball b) {
            boolean check = false;
            for(Ball bobble:collectionBall) {
                if(coordinateY < (cordY(bobble)+Map.SCARTO_Y)){
                    if(coordinateX >= cordX(bobble) && coordinateX <= (cordX(bobble))+bobble.width ) {
                        check=true;
                    }
                }
            }
            return check;
	}
    
    public ArrayList<Ball> getBolle() {
        return collectionBall;
    }

    public void render(Graphics g) {
        for(Ball b : collectionBall) {
            b.render(g);
        }
    }
    
    public void addBall(Ball b) {
        collectionBall.add(b);
    }

}
