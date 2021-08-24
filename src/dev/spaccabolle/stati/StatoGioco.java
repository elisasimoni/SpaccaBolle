package dev.spaccabolle.stati;


import java.awt.Graphics;
import dev.spaccabolle.Handler;
import dev.spaccabolle.Launcher;
import dev.spaccabolle.display.Display;
import dev.spaccabolle.entity.Ball;
import dev.spaccabolle.entity.Cannon;
import dev.spaccabolle.entity.CollectBall;

import dev.spaccabolle.gfx.Assets;
import dev.spaccabolle.input.KeyManager;

import dev.spaccabolle.entity.Map;

public class StatoGioco extends Stato{
    
        private static final int CANNON_X=(Launcher.GAME_WIDTH/2)-(Assets.cannon.getWidth()/2);
        private static final int SCARTO=100;
        private static final int CANNON_Y=(Launcher.GAME_HEIGHT/2)+Assets.cannon.getHeight()+SCARTO;
        private static final int EASY = 1;
        private static final int NORMAL = 2;
        private static final int HARD = 3;
        private static final int INITIAL_DRAGON = 200;
        private static final int EASY_DRAGON = 200;
        private static final int NORMAL_DRAGON = 300;
        private static final int HARD_DRAGON = 410;
        private static final int LIMITS = 15;
        
        public  static int xDragon = 500, yDragon=200, yDragonVictory = 450,yMove=-1;
    	public static int yDragonLimits=200, yDragonVictoryLimits=200;
    	
        static Cannon cannon;
        static CollectBall collectBall;
        static CollectBall collectBallMap;
        @SuppressWarnings("unused")
		private Map map; 
        public static boolean exit = false;
        public static boolean save = false;
        public static boolean pause = false;
        
        
        public static Pause paused;
        private DrawImage imageDraw;
        
		public StatoGioco(Handler handler) {
			super(handler);
			collectBall=new CollectBall();
			collectBallMap=new CollectBall();
			cannon = new Cannon(CANNON_X, CANNON_Y, Assets.cannon.getWidth(), Assets.cannon.getHeight(),collectBall);			
			paused = new Pause();
			imageDraw = new DrawImage();
			
			map = new Map(0, Ball.LEFT_BOUNCE,collectBallMap);
		}
		
		private void ifPause() {
		    if(KeyManager.pause && !CollectBall.gameOver) {
	    	 	pause = true;
		    }
			if (pause) {
			   if(KeyManager.easy) {
				   cannon.difficult = EASY;   		
				   yDragon = EASY_DRAGON;
				   yDragonLimits = EASY_DRAGON;
				}
			   if(KeyManager.normal) {
				   cannon.difficult = NORMAL;   		
				   yDragon = NORMAL_DRAGON;
				   yDragonLimits = NORMAL_DRAGON;
				}
			   if(KeyManager.hard) {
				   cannon.difficult = HARD;
				   yDragon = HARD_DRAGON;
				   yDragonLimits = HARD_DRAGON;
				}
		   }
		}
		
		private void ifExit() {
			if(KeyManager.exit && !CollectBall.gameOver && !CollectBall.victory) {
				   exit = true;
			}else if (KeyManager.exit){
				   System.exit(0);
			}
			   
		   if(exit) {
			   if(KeyManager.yes) {
				   System.exit(0);
			   }else if(KeyManager.no) {
				   exit = false;
			   }
		   }
		}
		
		private void ifGameOver() {
			if (CollectBall.gameOver) {
			   if(KeyManager.restart) {
				   Stato.setState(handler.getGame().menuState);
				   StatoMenu.run = false;
			   }
		   	}
		}
	
		private void getInput() {
		   ifPause();   //pause game
		   ifExit();	//exit game
		   ifGameOver(); //if game over restart game

		   if(KeyManager.save) {
			   save = true;
			   Display.saveFile();
		   }

		   if(KeyManager.enter) {
			   pause = false;
			   yDragon = INITIAL_DRAGON;
			   yDragonLimits = INITIAL_DRAGON;
		   }
		}
		 
		private void moveIcon() {
			if((yDragon < yDragonLimits-LIMITS || yDragon > yDragonLimits)) {
		          yMove*=-1;
		     }
		     yDragon+=yMove;
		}
		
		public void tick() {
			getInput();
			moveIcon();
			cannon.tick();
		    collectBallMap.tick();
		    collectBall.tick();
    
		}

		public void render(Graphics g) {
			imageDraw.render(g);
		}
}