package dev.spaccabolle.stati;

import java.awt.Graphics;
import java.io.File;

import javax.swing.JFileChooser;

import dev.spaccabolle.Handler;
import dev.spaccabolle.Launcher;
import dev.spaccabolle.display.Display;
import dev.spaccabolle.gfx.Assets;
import dev.spaccabolle.ui.ClickListener;
import dev.spaccabolle.ui.UIImageButton;
import dev.spaccabolle.ui.UIManager;

public class StatoMenu extends Stato{

	private UIManager uiManager;
	private int YMoveButton=840;
	private int yMovelogo=-430, dimDragon=0,xDragon=800,yDragon=445,yMove=-1;
	private static final int yLogoLimits = 30, xDragonLimits=345,yDragonLimits=445;

	public StatoMenu(Handler handler) {
		
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);

		uiManager.addObject(new UIImageButton(50, YMoveButton, 220, 150, Assets.btn_start, new ClickListener() {
			public void onClick() {
			        handler.getMouseManager().setUIManager(null);
			        System.out.println("Menu :"+uiManager.getObjects());
				Stato.setState(handler.getGame().gameState);
			}
			
		}));
		uiManager.addObject(new UIImageButton(308, YMoveButton, 220, 150, Assets.btn_load, new ClickListener() {
                    public void onClick() {
                            File file;
                            file=Display.getFile();
                            System.out.println(file);
                    }
            }));
		uiManager.addObject(new UIImageButton(566, YMoveButton, 220, 150, Assets.btn_exit, new ClickListener() {
                    public void onClick() {
                            System.exit(0);
                    }
            }));
	System.out.println("Menu :"+uiManager.getObjects());
	}
	
	private void moveLogo() {
	    yMovelogo+=2;
	}
	
	private void moveDragon() {
	    if(xDragon > xDragonLimits) {
	        xDragon-=2;
	    }else {
	        if(yDragon < yDragonLimits-15 || yDragon > yDragonLimits+15) {
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
		g.drawImage(Assets.logo, 70, yMovelogo, 650, 650, null);
		g.drawImage(Assets.dragon[0], xDragon, yDragon, dimDragon, dimDragon, null);
		uiManager.render(g);
		
		
	}
}
