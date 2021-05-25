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
	public boolean cordXMap(float coordinate) {
		boolean tmp = false;
		 for(Ball bobble: collectionBall) {
			 if(coordinate >= cordX(bobble)) {
				 
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
			 if(coordinate < (cordY(bobble)+Map.SCARTO_Y) ) {
				 
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
