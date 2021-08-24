package dev.spaccabolle.stati;

import java.awt.Graphics;
import java.io.File;

import dev.spaccabolle.Handler;
import dev.spaccabolle.Launcher;
import dev.spaccabolle.display.Display;
import dev.spaccabolle.entity.Ball;
import dev.spaccabolle.entity.CollectBall;
import dev.spaccabolle.entity.Map;
import dev.spaccabolle.gfx.Assets;
import dev.spaccabolle.ui.ClickListener;
import dev.spaccabolle.ui.UIImageButton;
import dev.spaccabolle.ui.UIManager;

public class StatoMenu extends Stato{
	private static final int yLogoLimits = 30, xDragonLimits=345,yDragonLimits=445;
	private static final int LIMITS = 15;
	
	private int yMove=-1;
	private int YMoveButton=840;
	
	public static int yMovelogo=-430;
	public static int dimDragon=0;
	public static int xDragon=800;
	public static int yDragon=445;
	public static UIManager uiManager;
	public static boolean run = false;
	public static boolean home = false;
	public static boolean isLoadGame = false;
	public static  File loadGame;
	static String filePath = new File("").getAbsolutePath();
	public static  File saveGame = new File(filePath+"//src//res//map//save.txt") ;
	public StatoMenu(Handler handler) {
		
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);

		uiManager.addObject(new UIImageButton(50, YMoveButton, 220, 150, Assets.btn_start, new ClickListener() {
			public void onClick() {
				//handler.getMouseManager().setUIManager(null);
				Stato.setState(handler.getGame().gameState);
				run = true;
			}
		}));
		
		uiManager.addObject(new UIImageButton(40, 640, 200, 90, Assets.trasparent, new ClickListener() {
			public void onClick() {
				if(run) {
					
				}
			}
		}));
		uiManager.addObject(new UIImageButton(330, 640, 200, 90, Assets.trasparent, new ClickListener() {
			public void onClick() {
				if(run) {
					StatoGioco.pause = true;
				}
			}
		}));
	
		uiManager.addObject(new UIImageButton(600, 640, 200, 90, Assets.trasparent, new ClickListener() {
			public void onClick() {
				if(run) {
					StatoGioco.exit = true;
				}
			}
		}));
		uiManager.addObject(new UIImageButton(210, 510, 90, 90, Assets.trasparent, new ClickListener() {
			public void onClick() {
				if(StatoGioco.pause) {
					Stato.setState(handler.getGame().menuState);
					StatoGioco.pause = false;
					run = false;
					home = true;
				}
			}
		}));
		uiManager.addObject(new UIImageButton(353, 510, 90, 90, Assets.trasparent, new ClickListener() {
			public void onClick() {
				if(StatoGioco.pause) {
					StatoGioco.pause = false;
				}
			}
		}));
		uiManager.addObject(new UIImageButton(495, 510, 90, 90, Assets.trasparent, new ClickListener() {
			public void onClick() {
				if(StatoGioco.pause) {
					StatoGioco.exit = true;
				}
			}
		}));
		uiManager.addObject(new UIImageButton(308, YMoveButton, 220, 150, Assets.btn_load, new ClickListener() {
                    @SuppressWarnings("static-access")
					public void onClick() {
                    	if(!run) {
                    		loadGame = Display.getFile();
                    		StatoGioco game= (StatoGioco) handler.getGame().gameState;
                    		game.level=loadGame;
                    		game.collectBallMap = new CollectBall();
                    		game.map=new Map(0, Ball.LEFT_BOUNCE,game.collectBallMap,game.level);
                            isLoadGame=true;  
                            run = true;
                            
                    	}
                    }
            }));
		uiManager.addObject(new UIImageButton(566, YMoveButton, 220, 150, Assets.btn_exit, new ClickListener() {
                    public void onClick() {
                    	if(!run) {
                            System.exit(0);
                    	}
                    }
            }));
	}
	
	private void moveLogo() {
	    yMovelogo+=2;
	}
	
	private void moveDragon() {
	    if(xDragon > xDragonLimits) {
	        xDragon-=2;
	    }else {
	        if(yDragon < yDragonLimits-LIMITS || yDragon > yDragonLimits+LIMITS) {
	            yMove*=-1;
	        }
	        yDragon+=yMove;
	    }
	    if(dimDragon<150)
	        dimDragon++;
	}

	public void tick() {
		uiManager.tick();
		if(yMovelogo < yLogoLimits) {
		    moveLogo();
		}
		moveDragon();
	}

	public void render(Graphics g) {
		g.drawImage(Assets.dark_background, 0, 0, Launcher.GAME_WIDTH, Launcher.GAME_HEIGHT, null);
		g.drawImage(Assets.logo, 70, StatoMenu.yMovelogo, 650, 650, null);
		g.drawImage(Assets.dragon, StatoMenu.xDragon, StatoMenu.yDragon, StatoMenu.dimDragon, StatoMenu.dimDragon, null);
		StatoMenu.uiManager.render(g);
	//	imageDraw.render(g);
	}
}
