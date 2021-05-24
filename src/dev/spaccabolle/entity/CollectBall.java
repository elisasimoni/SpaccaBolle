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
    
    public void compareBobble() {
    	
    	
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
	public boolean cordXMap(float coordinate) {
		boolean tmp = false;
		 for(Ball bobble: collectionBall) {
			 if(coordinate > cordX(bobble)) {
				 System.out.println(coordinate + " x");
				 tmp=true;
			 } 
		 }
		if(tmp == true) {
			return true;
		}
		else {
			return false;
		}
	
	}
	
	public boolean cordYMap(float coordinate) {
		boolean tmp = false;
		 for(Ball bobble: collectionBall) {
			 System.out.println(cordY(bobble) + "y all'inizio");
			 if(coordinate > cordY(bobble) && coordinate < ((5*Map.RADIUS)-Map.SCARTO_Y)) {
				 System.out.println(coordinate + " y");
				 System.out.println(cordY(bobble) + "y");
				 tmp=true;
			 } 
		 }
		if(tmp == true) {
			return tmp;
		}
		else {
			return tmp;
		}
	
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
