package dev.spaccabolle.entity;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import dev.spaccabolle.Handler;
import dev.spaccabolle.Launcher;
import dev.spaccabolle.display.Display;
import dev.spaccabolle.gfx.Assets;
import dev.spaccabolle.stati.Stato;
import dev.spaccabolle.stati.StatoGameOver;
import dev.spaccabolle.stati.StatoGioco;
import dev.spaccabolle.stati.StatoMenu;

public class CollectBall {
    
	/*lista bolle nel cannone*/
    private ArrayList<Ball> collectionBall;
    public static Ball[][] mapCollect = new Ball[Map.NROW][Map.NCOL];
    public static boolean gameOver = false;
    public static boolean popBall = false;
    
    public static CollectBall collectBallMap;
    

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
	public int color(Ball b) {
		return b.color;
	}
	
	
	
	public boolean check(float coordinateX,float coordinateY,Ball b) {
		
           boolean check = false; //change to false
  
           for(Ball bobble:collectionBall) {
        	   
            	if(coordinateY < (cordY(bobble)+Map.SCARTO_Y) && bobble.color !=0){
            		
            		if(coordinateX >= cordX(bobble) && coordinateX <= (cordX(bobble))+bobble.width ) {
    					
            			
    					b.x = cordX(bobble);
    					
    					if(coordinateY>600) {
    						System.out.print("ECCOMIIIII");
    						gameOver=true;
    						
    						
    					}
    					
                        check=true;	
                    }
			
            	}
              
            }
          return check;
           
	}
	
	public boolean tris(Ball b) {
		boolean checkTris = false;
		for(Ball bobble:collectionBall) {
			if(b.color == color(bobble)) {
				popBall = true;
				checkTris=true;
			
			}
			
			
		}
		
		return checkTris;
		
	}
    
    public ArrayList<Ball> getBolle() {
        return collectionBall;
    }

    public void render(Graphics g) {
        for(Ball b : collectionBall) {
            b.render(g);
        }
        if(gameOver) {
        	
        	g.drawImage(Assets.game_over, 170, 150, 500, Launcher.GAME_HEIGHT/2, null);
        }
        if(popBall) {
        	System.out.println("POP");
        	
        }
    }
    
    
    public void addBall(Ball b) {
        collectionBall.add(b);
    }


	

}
