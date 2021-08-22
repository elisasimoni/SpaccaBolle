package dev.spaccabolle.stati;

import java.awt.Color;
import java.awt.Graphics;
import dev.spaccabolle.Handler;
import dev.spaccabolle.Launcher;
import dev.spaccabolle.entity.Ball;
import dev.spaccabolle.entity.Cannon;
import dev.spaccabolle.entity.CollectBall;
import dev.spaccabolle.gfx.Assets;
import dev.spaccabolle.input.KeyManager;
import dev.spaccabolle.ui.ClickListener;
import dev.spaccabolle.ui.UIImageButton;
import dev.spaccabolle.ui.UIManager;
import dev.spaccabolle.entity.Map;

public class StatoGioco extends Stato{
    
        private static final int CANNON_X=(Launcher.GAME_WIDTH/2)-(Assets.cannon.getWidth()/2);
        private static final int SCARTO=100;
        private static final int CANNON_Y=(Launcher.GAME_HEIGHT/2)+Assets.cannon.getHeight()+SCARTO;
    
        private Cannon cannon;
        private CollectBall collectBall;
        private CollectBall collectBallMap;
        @SuppressWarnings("unused")
		private Map map;
        private UIManager uiManager; 
        public static boolean pause = false;
        
	public StatoGioco(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		collectBall=new CollectBall();
		collectBallMap=new CollectBall();
		cannon = new Cannon(CANNON_X, CANNON_Y, Assets.cannon.getWidth(), Assets.cannon.getHeight(),collectBall);
		map = new Map(0, Ball.LEFT_BOUNCE,collectBallMap);
		
		
		uiManager.addObject(new UIImageButton(40, 800, 200, 90, Assets.btn_save, new ClickListener(){
			public void onClick() {
				
				Stato.setState(handler.getGame().menuState);
				
				
			}
		}));
		uiManager.addObject(new UIImageButton(330, 800, 200, 90, Assets.btn_pause, new ClickListener() {
			
			public void onClick() {
				System.out.println("SONO QUIIIII");
				handler.getMouseManager().setUIManager(null);
				Stato.setState(handler.getGame().menuState);
				
			}
		}));
		uiManager.addObject(new UIImageButton(600, 800, 200, 90, Assets.btn_exit_statoGioco, new ClickListener() {
			public void onClick() {
				
			}
		}));
	}
	
	 private void getInput() {
			//avviare lo stato di pausa
			
			if(KeyManager.pause) {
			 
			  pause = true;
			  
			  
				
		   }
		   if(KeyManager.space) {
			   pause = false;
			  
		   }
		   //uscita dal gioco 
		   if(KeyManager.exit) {
			   System.exit(0);
		   }
		   
		   if(KeyManager.home) {
			   Stato.setState(handler.getGame().menuState);//non funzionano i tasti poi!! 
		   }
		   if (pause) {
			   if(KeyManager.hard) {
					cannon.difficult = 3;  
					pause = false;
				}
			   if(KeyManager.normal) {
					cannon.difficult = 2;   		
					pause = false;
				}
			   if(KeyManager.easy) {
					cannon.difficult = 1;   		
					pause = false;
				}
		   }
		}
		
		public void tick() {
			
			getInput();
			cannon.tick();
		    collectBallMap.tick();
		    collectBall.tick();
		    
		  //  uiManager.tick();
		}

	public void render(Graphics g) {
	    g.drawImage(Assets.dark_background, 0, 0, Launcher.GAME_WIDTH, Launcher.GAME_HEIGHT, null);
	   
	    cannon.render(g);
	    collectBall.render(g);
	    collectBallMap.render(g); 
	   
	    uiManager.render(g);
	    if(pause) {
	    	g.setColor(Color.WHITE);
	    	g.drawImage(Assets.black, 200, 200, 400, 400, null);
	    	g.drawRect(200, 200, 400, 400);
	    	
	    	g.drawImage(Assets.easy, 280, 210, 290, 90, null);
	    	g.drawImage(Assets.normal, 280, 310, 290, 90, null);
	    	g.drawImage(Assets.hard, 280, 410, 290, 90, null);
	    	
	    	g.drawImage(Assets.home, 210, 510, 90, 90, null);
	    	g.drawImage(Assets.pause, 353, 510, 90, 90, null);
	    	g.drawImage(Assets.exit, 495, 510, 90, 90, null);
	    	
	    	
	    }
	}
}