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
import java.util.List;
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
    		System.out.println("mapCollect   "+ r + c);
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
	
	public boolean roof(float coordinateX,float coordinateY,Ball b) throws IOException {
		
		  int saveCol=0;
		  boolean check = false; //change to false return false;
			  
		  for(Ball bobble:collectionBall) {	  
			  if(coordinateX >= bobble.getX() && coordinateX <= bobble.getX()+bobble.getWidth()) {
					  if(coordinateY < 40 && bobble.getY()<40 && bobble.color==0) {
					      System.out.println("So qua");

					  for(int r=0; r<9; r++) {
			                        for(int c=0; c<13; c++) {
			                            if(mapCollect[r][c].index==bobble.index) {
			                                System.out.println(mapCollect[r][c].x+" "+mapCollect[r][c].y);
			                                System.out.println(mapCollect[r][c-1].x+" "+mapCollect[r][c-1].y);
			                                System.out.println(mapCollect[r+1][c].x+" "+mapCollect[r+1][c].y);
			                                b.x=mapCollect[r][c].x;
			                                b.y=mapCollect[r][c].y;
			                                mapCollect[r][c].color=b.color;
			                                System.out.println(mapCollect[r][c].x);
			                            }
			                        }
					  }
                      
				
				
				 randomColorCannon= getColorInMap();
				 
				 System.out.println("  indice   " + b.index);
					 
			     for(int c1=0; c1<9; c1++) {
							for(int r1=0; r1<13; r1++) {
							 System.out.print(" " + mapCollect[c1][r1].color + " ");
								
							}
							System.out.println();
						}
					 
					check=true;	
              
       			   
       			   
			  }	   
            }
		  }
		  
       		
		  
		  return check;
		  }
	
	
	public boolean check(float coordinateX,float coordinateY,Ball b) throws IOException {
		
		boolean check = false; //change to false

        boolean control=false;
        boolean control2=false;
        int saveCol=0;

          for(Ball bobble:collectionBall) {


                if((coordinateY < (cordY(bobble)+Map.SCARTO_Y) && bobble.color !=0) ){
                        if(coordinateX >= cordX(bobble) && coordinateX < (cordX(bobble))+bobble.width-15) {
                                System.out.println("COL   " + coordinateX + b.x + cordX(bobble));
                                
                               float saveX=cordX(bobble);
                                     b.x = cordX(bobble);
                                     boolean isEqual=true;
                                     int tempSaveCol=0;
                                     System.out.println("ASSEGNAMENTO " + saveX  + " = " + mapCollect[0][saveCol].x + " ");
                                     while(isEqual) {
                                             if(coordinateX != mapCollect[0][tempSaveCol].x) {
                                              System.out.println("ASSEGNAMENTO " + coordinateX  + " = " + mapCollect[0][saveCol].x + " ");
                                             if( coordinateX <=mapCollect[0][tempSaveCol].x +55) {


                                                        isEqual=false;
                                                        saveCol=tempSaveCol;

                                             }else {
                                             tempSaveCol++;
                                                     if(tempSaveCol==13) {
                                                             isEqual=false;

                                                     }
                                             }
                                             }
                                             else {
                                                     isEqual=false;
                                                     saveCol=tempSaveCol;
                                             }
                                     }



                              System.out.println("ASSEGNAMENTO " + coordinateX  + " = " + mapCollect[0][saveCol].x + " ");
                                     for(int col = 1 ; col < 13; col++) {
                                         System.out.println(bobble.x + " " + mapCollect[0][col].x + " c: "+col);
                                      if(b.x==mapCollect[0][col].x ) {

                                              System.out.println(bobble.x + " " + mapCollect[0][col].x + " c: "+col);
                                               saveCol=col;
                                               System.out.println("COLONNA SAVE");


                                      }



                             }

                                     for(int row = 0; row < 8;row++) {

                                            


                                      if(b.y>=mapCollect[row][saveCol].y-30 && b.y<= mapCollect[row][saveCol].y+30) {
                                            
                                      mapCollect[row][saveCol] = b;

                                      saveGame(mapCollect);

                                      randomColorCannon= getColorInMap();

                                      System.out.println("mapCollect nuova bolla");



                                      for(int c=0; c<8; c++) {
                                                     for(int r=0; r<13; r++) {
                                                      System.out.print(" " + mapCollect[c][r].color + " ");

                                                     }
                                                     System.out.println();
                                             }
                                      

                                     }
                                     }
                                     /**
                                     ** controllo game OVer
                                     **/
                                     if(coordinateY>350) {
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
		
		
		addPoint=0;
		/*controllo orizzontale a 5*/
		for(int r=0; r<9; r++) {
			for(int c=0; c<13; c++) {
				int c2=c+1;
				int c3=c+2;
				int c4=c+3;
				int c5=c+5;
				if(mapCollect[r][c]!=null && mapCollect[r][c2]!=null && mapCollect[r][c3]!=null 
						&& mapCollect[r][c4]!=null &&mapCollect[r][c5]!=null && mapCollect[r][c].color !=0 && mapCollect[r][c2].color !=0 && mapCollect[r][c3].color != 0 && mapCollect[r][c4].color!=0 &&mapCollect[r][c5].color!=0) {
				
				if(mapCollect[r][c].color==mapCollect[r][c2].color && mapCollect[r][c2].color== mapCollect[r][c3].color && mapCollect[r][c3].color== mapCollect[r][c4].color && mapCollect[r][c4].color== mapCollect[r][c5].color ) {
				
							
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
							checkTris=true;
							if(checkTris) {
								if(addPoint==0) {
									addPoint=1;
								point = point + 5;
								}
							}
				
							
						}
				}   
					//controllo vittoria
   					int count=0;
   					for(int r1=0; r1<9; r1++) {
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
		
		/*controllo orizzontale particolare*/
		for(int r=0; r<9; r++) {
			for(int c=0; c<13; c++) {
				
				int c2=c-1;
				
				if(c2<0) {
					c2=0;
					
				}
				int c3=c-2;
				if(c3<0) {
					c3=0;
					
				}
				
				if(mapCollect[r][c]!=null && mapCollect[r][c2]!=null && mapCollect[r][c3]!=null && mapCollect[r][c].color !=0 && mapCollect[r][c2].color !=0 && mapCollect[r][c3].color != 0) {
				
				if(mapCollect[r][c].color==mapCollect[r][c2].color && mapCollect[r][c2].color== mapCollect[r][c3].color ) {
						
					
					mapCollect[r][c].color=0;
					mapCollect[r][c2].color=0;
					mapCollect[r][c3].color=0;
					mapCollect[r][c].eliminate();
					mapCollect[r][c2].eliminate();
					mapCollect[r][c3].eliminate();
					checkTris=true;
					if(addPoint==0) {
						addPoint=1;
					point = point + 3;
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
		
		
			/*controllo orizzontale*/
			for(int r=0; r<9; r++) {
				for(int c=0; c<13; c++) {
					int c2=c+1;
					int c3=c+2;
					int c4=c+3;
					int c5=c+5;
					if(mapCollect[r][c]!=null && mapCollect[r][c2]!=null && mapCollect[r][c3]!=null && mapCollect[r][c4]!=null &&mapCollect[r][c].color !=0 && mapCollect[r][c2].color !=0 && mapCollect[r][c3].color != 0 && mapCollect[r][c4].color!=0 ) {
					
					if(mapCollect[r][c].color==mapCollect[r][c2].color && mapCollect[r][c2].color== mapCollect[r][c3].color ) {
						if(mapCollect[r][c3].color== mapCollect[r][c4].color) {
						   
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
			for(int r=0; r<9; r++) {
				for(int c=0; c<13; c++) {
					int r2=r+1;
					int r3=r+2;
					if(mapCollect[r][c]!=null && mapCollect[r2][c]!=null && mapCollect[r3][c]!=null && mapCollect[r][c].color!=0 && mapCollect[r2][c].color!=0 && mapCollect[r3][c].color!=0) {
					
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
			for(int r=0; r<9; r++) {
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
			
			for(int r=0; r<9; r++) {
				for(int c=0; c<14; c++) {
					boolean stop=false;
					int i=0;
					int r2 = r-i;
					int r3=r2-1;
					
					if(r2<0) {
						r2=0;
					}
					if(r3<0) {
						r3=0;
					}
					i++;
					if(mapCollect[r2][c]!=null) {
						if(mapCollect[r2][c].color==0)
						{
							checkTris=true;
							mapCollect[r][c].color=0;
							mapCollect[r][c].eliminate();
							
							
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
			for(int r=0; r<9; r++) {
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
	    System.out.println("Scrivo");
	    String filePath = new File("").getAbsolutePath();
		File save = new File(filePath+"\\src\\res\\map\\save.txt");
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(save)));
	    
	    for(int r=0; r<9; r++) {
            for(int c=0; c<13; c++) {
	            out.print(matrix[r][c].color);
	       }
	       out.println();
	}
	out.close();
	StatoMenu.saveGame=save;
	
	   
		
		   
		  
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
