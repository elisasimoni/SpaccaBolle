package dev.spaccabolle.entity;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import dev.spaccabolle.Handler;
import dev.spaccabolle.Launcher;
import dev.spaccabolle.gfx.Assets;
import dev.spaccabolle.stati.Stato;
import dev.spaccabolle.stati.StatoGameOver;
import dev.spaccabolle.stati.StatoGioco;
import dev.spaccabolle.stati.StatoMenu;

@SuppressWarnings("unused")
public class CollectBall {
    
	/*lista bolle nel cannone*/
    private ArrayList<Ball> collectionBall;
    public static Ball[][] mapCollect = Map.getMapmatrix();
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
           
           boolean control=false;
           int saveCol=0;
           
          /* for(; col<13;col++) {
        	 
			  if(coordinateX==mapCollect[1][col].x) {
				  System.out.println("SONO DENTRO X");
				  b.x=mapCollect[1][col].x;
				  control=true;  
				  saveCol=col;
			}
           }
           if(control) {
			for(; row<Map.NCOL; row++) {				
					  if(mapCollect[row][saveCol].color==0) {
						  System.out.println("SONO DENTRO Y");
						  b.y=mapCollect[row][saveCol].y;
						  mapCollect[row][saveCol]=b;
						  if(coordinateY>600) {			
	    						gameOver=true;
	    						
	    					}
	    					
	                        check=true;	
					  }
				  
				  
			  }
           }*/
           
           
           for(Ball bobble:collectionBall) {
        	   
        	   
        	   
        	   if(coordinateY < (cordY(bobble)+Map.SCARTO_Y) && bobble.color !=0){
        		   if(coordinateX >= cordX(bobble) && coordinateX <= (cordX(bobble))+bobble.width ) {
        			   
        			   if(cordY(bobble)>169) {
      						b.x =cordX(bobble);
      						b.y=(float) (b.y-0.25);
      					}
   					b.x = cordX(bobble);
   					
   					for(int col = 1 ; col < 13; col++) {
    					 if(b.x==mapCollect[1][col].x ) {
    						 
    						  saveCol=col;
    					 }
    				}
   					
  					for(int row = 1; row < 8;row++) {
  						 System.out.println("ASSEGNAMENTO " + b.x +" "+ b.y + " = " + mapCollect[row][saveCol].x + " " + mapCollect[row][saveCol].y);
    					 if(b.y>=mapCollect[row][saveCol].y-15 && b.y<= mapCollect[row][saveCol].y+15) {
    					 System.out.println("ASSEGNAMENTO " + b.x +" "+ b.y + " = " + mapCollect[row][saveCol].x + " " + mapCollect[row][saveCol].y);
    					 mapCollect[row][saveCol] = b;
    					 System.out.println("mapCollect nuova bolla");
    					}
  					}
   					
   					if(coordinateY>600) {
   						System.out.println("GAME OVER");
   						gameOver=true;
   						for(int c=1; c<8; c++) {
   							for(int r=1; r<13; r++) {
   							 System.out.print(" " + mapCollect[c][r].color + " ");
   								
   							}
   							System.out.println();
   						}
   						
   						
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
        	
        	
        }
    }
    
    
    public void addBall(Ball b) {
        collectionBall.add(b);
    }


	

}
