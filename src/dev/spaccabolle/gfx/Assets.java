package dev.spaccabolle.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage[] btn_start,btn_pause,btn_exit,btn_load,ballGroup, dragon;

	public static BufferedImage cannon,arrow,dark_background, logo, game_over;
	

	public static BufferedImage readBobble = null;
	private static final int NUM_BOLLE = 5;
	public static void init(){
		
		System.out.println("Prova");
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/sheet.png"));
		cannon=ImageLoader.loadImage("/res/textures/cannone.png");
	    arrow=ImageLoader.loadImage("/res/textures/freccia.png");
	    logo = ImageLoader.loadImage("/res/textures/Logo.png");
	    game_over = ImageLoader.loadImage("/res/textures/GAMEOVER.jpeg");
	    dragon = new BufferedImage[2];
            dragon[0] = ImageLoader.loadImage("/res/textures/draghetto.png");
            dragon[1] = ImageLoader.loadImage("/res/textures/draghetto2.png");
	    dark_background=ImageLoader.loadImage("/res/textures/dark_background.jpg");
		btn_start = new BufferedImage[2];
		btn_start[0] = ImageLoader.loadImage("/res/textures/PLAY.png");
		btn_start[1] = ImageLoader.loadImage("/res/textures/PlayDark.png");
		btn_pause = new BufferedImage[2];
                btn_pause[0] = ImageLoader.loadImage("/res/textures/pause.png");
                btn_pause[1] = ImageLoader.loadImage("/res/textures/PauseDark.png");
                btn_exit = new BufferedImage[2];
                btn_exit[0] = ImageLoader.loadImage("/res/textures/exit.png");
                btn_exit[1] = ImageLoader.loadImage("/res/textures/exitDark.png");
                btn_load = new BufferedImage[2];
                btn_load[0] = ImageLoader.loadImage("/res/textures/load.png");
                btn_load[1] = ImageLoader.loadImage("/res/textures/loadDark.png");
		ballGroup = new BufferedImage[NUM_BOLLE];
	    ballGroup[1] = ImageLoader.loadImage("/res/textures/staticRedBall.png");
	    ballGroup[2] = ImageLoader.loadImage("/res/textures/staticBlueBall.png");
	    ballGroup[3] = ImageLoader.loadImage("/res/textures/staticGreenBall.png");
	    ballGroup[4] = ImageLoader.loadImage("/res/textures/staticYellowBall.png");

	}
	
}