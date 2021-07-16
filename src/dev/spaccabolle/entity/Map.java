package dev.spaccabolle.entity;

import java.io.BufferedReader;
import java.io.File;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import dev.spaccabolle.Launcher;

public class Map {
    public static final double SCARTO_X = 10;
    
    
    public static final int RADIUS = (int)(Ball.BOBBLE_SIZE / 1.25);
    
    public static final double SCARTO_Y = RADIUS+3;
    public static final int RADIUS_NINE = RADIUS + 506;
    private String line = null;
    public Ball ballMap = null;
    public static double finalX = 0;
    
    // coordinate posizionamento su colonne e righe
    public int lineDimensionX = Launcher.GAME_WIDTH;
    public int lineDimensionY = Launcher.GAME_HEIGHT;
    
    
    
    public static CollectBall collectBallMap;
    
    public static CollectBall getCollectBallMap() {
		return collectBallMap;
	}
	public static void setCollectBallMap(CollectBall collectBallMap) {
		Map.collectBallMap = collectBallMap;
	}
	public static int numBobble = 105;
    public static int[] coordinateX = new int[numBobble];
    public static int[] coordinateY = new int[numBobble];
   
    
    public void getCoordinateX(int[] coordinateX) {
    	Map.coordinateX=coordinateX;
    }
    public void getCoordinateY(int[] coordinateY) {
    	Map.coordinateY=coordinateY;
    }
    public int[] getCoordinateX() {
        return coordinateX;
    }
    public int[] getCoordinateY() {
        return coordinateY;
    }
   
    public Map(int gameYSize, int gameXSize, CollectBall collectBall) {
        Map.collectBallMap=collectBall;
       
        
        BufferedReader reader = null;
        try {

        		String filePath = new File("").getAbsolutePath();
                reader = new BufferedReader(new FileReader(filePath + "\\src\\res\\map\\level1.txt"));
               

        } catch (FileNotFoundException e2) {
                // TODO Auto-generated catch block
                e2.printStackTrace();
        }
        
        try {
                line = reader.readLine();
        } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
        }
        
        int posLine = 1;
        while(line!=null) {
                for(int i = 0; i < line.length(); i++) {
                        
                        
                        char elem = line.charAt(i);
                        String checkElem = String.valueOf(elem);
                        int posChar = i;
                        if(posChar == 13) {
                                posChar = 0;
                        }
                        
                        
                        int readBobble=0;
                        switch(checkElem) { 
                        case "0":
                                readBobble = 0;
                                break;
                        case "1": 
                                readBobble = 1;
                                break;
                        case "2":
                                readBobble = 2;
                                break;
                        case "3":
                                readBobble = 3;
                                break;
                        case "4":
                                readBobble = 4;
                                break;
                        default:
                                break;
                                
                        
                        }
                        
                        
                        switch(posLine) {
                                case 1:
                                        
                                        lineDimensionY = gameYSize;
                                        break;
                                case 2:
                                        
                                        lineDimensionY = gameYSize+RADIUS;
                                        break;
                                case 3:
                                        
                                        lineDimensionY = gameYSize+(2*RADIUS);
                                        break;
                                case 4:
                                        
                                        lineDimensionY = gameYSize+(3*RADIUS);
                                        break;
                                case 5:
                                        
                                        lineDimensionY = gameYSize+(4*RADIUS);
                                        break;
                                case 6:
                                        
                                        lineDimensionY = gameYSize+(5*RADIUS);
                                        break;
                                case 7:
                                		lineDimensionY = gameYSize+(6*RADIUS);
                                		break;
                                case 8:
                            			lineDimensionY = gameYSize+(7*RADIUS);
                            			break;		
                            	
                                default:
                                        break;
                                
                        
                        }
                        
                        switch(posChar) {
                        case 0:
                                lineDimensionX = RADIUS;
                                break;
                        case 1:
                                lineDimensionX = 2*RADIUS;
                                break;
                        case 2:
                                lineDimensionX = 3*RADIUS;
                                break;
                        case 3:
                                lineDimensionX = 4*RADIUS;
                                break;
                        case 4:
                                lineDimensionX = 5*RADIUS;
                                
                                break;
                        case 5:
                                lineDimensionX = 6*RADIUS;
                                break;
                        case 6:
                                lineDimensionX = 7*RADIUS;
                                break;
                        case 7:
                                lineDimensionX = 8*RADIUS;
                                
                                break;
                        case 8:
                            	lineDimensionX = 9*RADIUS;
                            	break;
                        case 9:
                    			lineDimensionX = RADIUS_NINE;
                    			break;
                        case 10:
                        		lineDimensionX = 11*RADIUS+1;
                        		break;
                        case 11:
                				lineDimensionX = 12*RADIUS;
                				break;
                        case 12:
            					lineDimensionX = 13*RADIUS;
            					break;
                       
                        default:
                                break;
                        
                
                }
                        
                ballMap = new Ball(lineDimensionX,lineDimensionY,Ball.BOBBLE_SIZE,Ball.BOBBLE_SIZE,readBobble);
                loadCoordinate(lineDimensionX,lineDimensionY);
                collectBallMap.addBall(ballMap);              
                }
                
                try {
                        line = reader.readLine();
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                posLine++;
        }
    }
    private void loadCoordinate(int xMap, int yMap) {
    	
    	for (int iterX=0; iterX<collectBallMap.numBolle(); iterX++) {
      	  coordinateX[iterX] = xMap;
      	}
      for (int iterY=0; iterY<collectBallMap.numBolle(); iterY++) {
    	  coordinateY[iterY] = yMap;
    	}
    }
    
}
