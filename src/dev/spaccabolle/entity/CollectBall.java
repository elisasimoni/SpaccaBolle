package dev.spaccabolle.entity;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import dev.spaccabolle.Handler;
import dev.spaccabolle.Launcher;
import dev.spaccabolle.gfx.Assets;
import dev.spaccabolle.stati.Stato;
import dev.spaccabolle.stati.StatoGioco;
import dev.spaccabolle.stati.StatoMenu;

@SuppressWarnings("unused")
public class CollectBall {
    
	/*lista bolle nel cannone*/
    private ArrayList<Ball> collectionBall;
    public static Ball[][] mapCollect = Map.getMapmatrix();
    public static boolean gameOver = false;
    public static boolean victory = false;
    public static score score =new score(0, 0, 0,0);
    public static int addPoint=0;
    public static int point=0;
    private static final int[] exclude = {0,0,0,0,0};
    private static Random rand = new Random();
    public static int randomColorCannon=1;
    
   
    

    public CollectBall() {
        collectionBall = new ArrayList<>();
       
       
    }
    public static Ball[][] getMapCollect() {
		return mapCollect;
	}
    
    
    /*carica  l'array*/
    public void tick() {
        Iterator<Ball> ba = collectionBall.iterator();
        while(ba.hasNext()) {
            Ball b = ba.next(); 	
            b.tick();
        }
    }
    
    
    public static int getColorInMap() {
    	int blue=0,yellow=0, green=0, red=0;
    	//bisogna vedere che colori sono rimasti sulla mappa
    	for(int r=0; r<9; r++) {
    		for(int c=0; c<13; c++) {
    	    int readColor=mapCollect[r][c].color;
    		switch(readColor) {
    				
    				case 1:
    					red++;
    				  break;
    				case 2:
    					blue++;	
    				  break;
    				case 3:
    					green++;                     //FUNZIONA
    				  break;
    				case 4:
    					yellow++;
    				  break;
    				default:
    					break;
    				
    			}
    		}
    	}

    	
    	int random = 0;
    	int right=0;
    	//algoritmo per sparare solo colori presenti sulla mappa
    	
    	while(right<1) {
    		random = rand.nextInt(5);
    		right=1;
    		if((blue==0 && random==2) || (red==0 && random==1) || (green==0 && random==3) || (yellow==0 && random==4) || (random==0)) {
    			right=0;
    			
    		}
     		
		}
    	
    	
    	
    	return random;
    
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
	
	public boolean check(float coordinateX,float coordinateY,Ball b) throws IOException {
		
           boolean check = false; //change to false
           
           boolean control=false;
           boolean control2=false;
           int saveCol=0;
           
           
          
           for(Ball bobble:collectionBall) {
        	   
        	  
        	   
        	   
        	   if(((coordinateY < (cordY(bobble)+Map.SCARTO_Y) && bobble.color !=0)) ){
        		   if(coordinateX >= cordX(bobble) && coordinateX <= (cordX(bobble))+bobble.width-15 ) {
        			   
        			   if(cordY(bobble)>169) {
      						b.x =cordX(bobble);
      						b.y=(float) (b.y-0.25);
      					}
   					b.x = cordX(bobble);
   					
   					for(int col = 0 ; col < 12; col++) {
    					 if(b.x==mapCollect[0][col].x ) {
    						 
    						  saveCol=col;
    					 }
    				}
   					
  					for(int row = 0; row < 7;row++) {
  						
  						if(control) {
  							if(b.y>=mapCollect[row][saveCol].y-140 && b.y<= mapCollect[row][saveCol].y+140){
  								
  								mapCollect[row][saveCol] = b;
  								
  							}
						 }
  						
  						
    					 if(b.y>=mapCollect[row][saveCol].y-15 && b.y<= mapCollect[row][saveCol].y+15) {
    						 
    					/*System.out.println("ASSEGNAMENTO " + b.x +" "+ b.y + " = " + mapCollect[row][saveCol].x + " " + mapCollect[row][saveCol].y);*/
    					 
    					 mapCollect[row][saveCol] = b;
    					 randomColorCannon= getColorInMap();
    					 
    					 System.out.println("mapCollect nuova bolla");
    					 
    					 
    					 
    					 for(int c=0; c<8; c++) {
    							for(int r=0; r<13; r++) {
    							 System.out.print(" " + mapCollect[c][r].color + " ");
    								
    							}
    							System.out.println();
    						}
    					 if(row>=6) {
    						 control=true;
    					 }
    					 
    					}
  					}
  					//controllo game OVer
   					if(coordinateY>450) {
   						System.out.println("GAME OVER");
   						saveGame(mapCollect);
   						gameOver=true;
   						
   						
   						
   					}
   					
   					
                       check=true;	
                   }
        		 
        		  }
        		  
        	   
        	   }
        	   
            	
           
           
          return check;
           
	}
	
	public boolean tris() {
		boolean checkTris=false;
		/*controllo orizzontale a 5*/
		for(int r=0; r<8; r++) {
			for(int c=0; c<13; c++) {
				int c2=c+1;
				int c3=c+2;
				int c4=c+3;
				int c5=c+5;
				if(mapCollect[r][c]!=null && mapCollect[r][c2]!=null && mapCollect[r][c3]!=null 
						&& mapCollect[r][c4]!=null &&mapCollect[r][c5]!=null) {
				
				if(mapCollect[r][c].color==mapCollect[r][c2].color && mapCollect[r][c2].color== mapCollect[r][c3].color && mapCollect[r][c3].color== mapCollect[r][c4].color && mapCollect[r][c4].color== mapCollect[r][c5].color ) {
				
							checkTris=true;
							mapCollect[r][c].color=0;
							mapCollect[r][c2].color=0;
							mapCollect[r][c3].color=0;
							mapCollect[r][c4].color=0;
							mapCollect[r][c5].color=0;
							mapCollect[r][c].eliminate();
							mapCollect[r][c2].eliminate();
							mapCollect[r][c3].eliminate();
							mapCollect[r][c4].eliminate();
							mapCollect[r][c5].eliminate();
							if(addPoint==0) {
							addPoint=1;
							point = point + 5;}
						}
				}   
					//controllo vittoria
   					int count=0;
   					for(int r1=0; r1<8; r1++) {
   			            for(int c1=0; c1<13; c1++) {
   			            	
   			                if(mapCollect[r1][c1].color!=0) {
   			                	count++;
   			                }
   			            }
   					}
   					if(count==0) {
   						victory=true;
   					}
					
					
					
				
				}
			}
			
		
			/*controllo orizzontale*/
			for(int r=0; r<8; r++) {
				for(int c=0; c<13; c++) {
					int c2=c+1;
					int c3=c+2;
					int c4=c+3;
					int c5=c+5;
					if(mapCollect[r][c]!=null && mapCollect[r][c2]!=null && mapCollect[r][c3]!=null && mapCollect[r][c4]!=null &&mapCollect[r][c5]!=null) {
					
					if(mapCollect[r][c].color==mapCollect[r][c2].color && mapCollect[r][c2].color== mapCollect[r][c3].color ) {
						if(mapCollect[r][c3].color== mapCollect[r][c4].color) {
						   if(mapCollect[r][c4].color== mapCollect[r][c5].color){
								checkTris=true;
								mapCollect[r][c].color=0;
								mapCollect[r][c2].color=0;
								mapCollect[r][c3].color=0;
								mapCollect[r][c4].color=0;
								mapCollect[r][c5].color=0;
								mapCollect[r][c].eliminate();
								mapCollect[r][c2].eliminate();
								mapCollect[r][c3].eliminate();
								mapCollect[r][c4].eliminate();
								mapCollect[r][c5].eliminate();
								if(addPoint==0) {
								addPoint=1;
								point = point + 5;}
							}
						   else {
							checkTris=true;
							mapCollect[r][c].color=0;
							mapCollect[r][c2].color=0;
							mapCollect[r][c3].color=0;
							mapCollect[r][c4].color=0;
							mapCollect[r][c].eliminate();
							mapCollect[r][c2].eliminate();
							mapCollect[r][c3].eliminate();
							mapCollect[r][c4].eliminate();
							if(addPoint==0) {
								addPoint=1;
							point = point + 4;}
						   }
						}
						else {
						
						
						checkTris=true;
						
						mapCollect[r][c].color=0;
						mapCollect[r][c2].color=0;
						mapCollect[r][c3].color=0;
						mapCollect[r][c].eliminate();
						mapCollect[r][c2].eliminate();
						mapCollect[r][c3].eliminate();
						if(addPoint==0) {
							addPoint=1;
						point = point + 3;
						}
						}
						//controllo vittoria
	   					int count=0;
	   					for(int r1=0; r1<8; r1++) {
	   			            for(int c1=0; c1<13; c1++) {
	   			            	
	   			                if(mapCollect[r1][c1].color!=0) {
	   			                	count++;
	   			                }
	   			            }
	   					}
	   					if(count==0) {
	   						victory=true;
	   					}
						
						
						
					
					}
					}
				}
			}
			/*controllo verticale*/
			for(int r=0; r<8; r++) {
				for(int c=0; c<13; c++) {
					int r2=r+1;
					int r3=r+2;
					if(mapCollect[r][c]!=null && mapCollect[r2][c]!=null && mapCollect[r3][c]!=null) {
					
					if(mapCollect[r][c].color==mapCollect[r2][c].color && mapCollect[r2][c].color== mapCollect[r3][c].color ) {
						
						checkTris=true;
						mapCollect[r][c].color=0;
						mapCollect[r2][c].color=0;
						mapCollect[r3][c].color=0;
						mapCollect[r][c].eliminate();
						mapCollect[r2][c].eliminate();
						mapCollect[r3][c].eliminate();
						if(addPoint==0) {
							addPoint=1;
						point = point + 3;}
						//controllo vittoria
	   					int count=0;
	   					for(int r1=0; r1<8; r1++) {
	   			            for(int c1=0; c1<13; c1++) {
	   			                if(mapCollect[r1][c1].color!=0) {
	   			                	count++;
	   			                }
	   			            }
	   					}
	   					if(count==0) {
	   						victory=true;
	   					}
						
					
					}
					}
				}
			}
			/*controllo 1 pallina attaccate al vuoto*/
			for(int r=0; r<8; r++) {
				for(int c=0; c<13; c++) {
					
					int r2=r-1; //pallina sopra
					
					if(r2==-1) {
						r2=0;
						
					}
					int r3=r+1; //pallina sotto
					int c2=c-1; //pallina a sx
					if(c2==-1) {
						c2=0;
						
					}
					int c3=c+2; //pallina a dx
					if(mapCollect[r][c]!=null && mapCollect[r2][c]!=null && mapCollect[r3][c]!=null && mapCollect[r][c]!=null && mapCollect[r][c2]!=null && mapCollect[r][c3]!=null ) {
					
					if( mapCollect[r2][c].color==0 ) {
						
						checkTris=true;
						mapCollect[r][c].color=0;
						mapCollect[r][c].eliminate();
						if(addPoint==0) {
							addPoint=1;
						point = point + 1;}
						//controllo vittoria
	   					int count=0;
	   					for(int r1=0; r1<8; r1++) {
	   			            for(int c1=0; c1<13; c1++) {
	   			                if(mapCollect[r1][c1].color!=0) {
	   			                	count++;
	   			                }
	   			            }
	   					}
	   					if(count==0) {
	   						victory=true;
	   					}
						
					
					}
					}
				}
			}
			/*controllo + palline attaccate al vuoto*/
			
			for(int r=0; r<8; r++) {
				for(int c=0; c<13; c++) {
					boolean stop=false;
					int i=0;
					int r2 = r-i;
					if(r2<0) {
						r2=0;
					}
					i++;
					if(mapCollect[r2][c]!=null) {
						if(mapCollect[r2][c].color==0)
						{
							checkTris=true;
							mapCollect[r][c].color=0;
							mapCollect[r][c].eliminate();
							
							if(addPoint==0) {
									addPoint=1;
									point = point + 1;
							}
							//controllo vittoria
		   					int count=0;
		   					for(int r1=0; r1<8; r1++) {
		   			            for(int c1=0; c1<13; c1++) {
		   			                if(mapCollect[r1][c1].color!=0) {
		   			                	count++;
		   			                }
		   			            }
		   					}
		   					if(count==0) {
		   						victory=true;
		   					}
							stop=true;
						}
					}
						
					
					
					
				
				}
			}
		
			for(int r=0; r<8; r++) {
                            for(int c=0; c<13; c++) {
                                if(mapCollect[r][c].color==0) {
                                    for(Ball b:collectionBall) {
                                        if(mapCollect[r][c].getX() == b.getX() && mapCollect[r][c].getY()==b.getY()) {
                                        	
                                            b.color=0;
                                            b.eliminate();
                                        }
                                        
                                    }
                                }
                            }
		        }
		//confronto mappa e collection Ball
			for(int r=0; r<8; r++) {
                for(int c=0; c<13; c++) {
                    if(mapCollect[r][c].color==0) {
                        for(Ball b:collectionBall) {
                            if(mapCollect[r][c].index==b.index) {
                                b.color=0;
                                b.eliminate();
                                /*System.out.println(b.index+" "+mapCollect[r][c].index);*/
                            }
                        }
                    }
                }
				}
			
			
			
			
		score.addPoint(point);
		addPoint=0;
		return checkTris;
		
	}
	
	
	public void saveGame(Ball[][] matrix) throws IOException {
		    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("save.txt")));
		    for(int r=0; r<8; r++) {
                for(int c=0; c<13; c++) {
		            out.print(matrix[r][c].color);
		       }
		       out.println();
		}
		out.close();
		    
		   
		  
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
        if(victory) {
        	
        	g.drawImage(Assets.victory, 170, 150, 500, Launcher.GAME_HEIGHT/2, null);
        	
        }
        score.render(g);
      
        
    }
    
    
    
    public void addBall(Ball b) {
        collectionBall.add(b);
    }
 
}
