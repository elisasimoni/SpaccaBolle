package dev.spaccabolle.entity;

import java.io.BufferedReader;
import java.io.File;

import dev.spaccabolle.entity.Ball;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import dev.spaccabolle.Launcher;

public class Map {
    private static final double SCARTO_X = 3.5;
    private static final int RADIUS = (int)(Ball.BOBBLE_SIZE / 1.25);
    private String line = null;
    private Ball ballMap = null;
    private int lineDimensionX = Ball.LEFT_BOUNCE;
    private int lineDimensionY = Launcher.GAME_HEIGHT;
    private int lineDimensionXLine = 0;
    private CollectBall collectBallMap;
    
    public Map(int gameYSize, int gameXSize, CollectBall collectBall) {
        this.collectBallMap=collectBall;
        BufferedReader reader = null;
        try {

        		String filePath = new File("").getAbsolutePath();
                reader = new BufferedReader(new FileReader(filePath + "\\src\\res\\map\\level1.txt"));
                reader = new BufferedReader(new FileReader("/SpaccaBolle/src/res/map/level1.txt"));

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
                        if(posChar == 9) {
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
                                        lineDimensionXLine = 0;
                                        break;
                                case 2:
                                        
                                        lineDimensionY = gameYSize+RADIUS;
                                        lineDimensionXLine = (int) (gameXSize/SCARTO_X);
                                        break;
                                case 3:
                                        
                                        lineDimensionY = gameYSize+(2*RADIUS);
                                        lineDimensionXLine = 0;
                                        break;
                                case 4:
                                        
                                        lineDimensionY = gameYSize+(3*RADIUS);
                                        lineDimensionXLine = (int) (gameXSize/SCARTO_X);
                                        break;
                                case 5:
                                        
                                        lineDimensionY = gameYSize+(4*RADIUS);
                                        lineDimensionXLine = 0;
                                        break;
                                case 6:
                                        
                                        lineDimensionY = gameYSize+(5*RADIUS);
                                        lineDimensionXLine =(int) (gameXSize/SCARTO_X);
                                        break;
                                default:
                                        break;
                                
                        
                        }
                        
                        switch(posChar) {
                        case 0:
                                lineDimensionX = gameXSize + lineDimensionXLine;
                                
                                break;
                        case 1:
                                lineDimensionX = gameXSize+RADIUS+lineDimensionXLine;
                                
                                break;
                        case 2:
                                lineDimensionX = gameXSize+(2*RADIUS)+lineDimensionXLine;
                                
                                break;
                        case 3:
                                lineDimensionX = gameXSize+(3*RADIUS)+lineDimensionXLine;
                                
                                break;
                        case 4:
                                lineDimensionX = gameXSize+(4*RADIUS)+lineDimensionXLine;
                                
                                break;
                        case 5:
                                lineDimensionX = gameXSize+(5*RADIUS)+lineDimensionXLine;
                                break;
                        case 6:
                                lineDimensionX = gameXSize+(6*RADIUS)+lineDimensionXLine;
                                break;
                        case 7:
                                lineDimensionX = gameXSize+(7*RADIUS)+lineDimensionXLine
                                ;
                                break;
                        default:
                                break;
                        
                
                }
                        
                ballMap = new Ball(lineDimensionX,lineDimensionY,Ball.BOBBLE_SIZE,Ball.BOBBLE_SIZE,readBobble);
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
}
