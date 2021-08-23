package dev.spaccabolle.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	
	public static BufferedImage[] btn_start,btn_pause,btn_exit,btn_load,ballGroup, dragon, btn_save, btn_exit_statoGioco, numbers;

	public static BufferedImage cannon,arrow,dark_background, logo, game_over, victory, exit, black, home, pause, easy, normal, hard;

	public static BufferedImage readBobble = null;
	private static final int NUM_BOLLE = 5;
	public static void init(){
		
		System.out.println("Prova");
		
		cannon=ImageLoader.loadImage("/res/textures/cannoneFreccia.png");
	    arrow=ImageLoader.loadImage("/res/textures/freccia.png");
	    logo = ImageLoader.loadImage("/res/textures/Logo.png");
	    dark_background=ImageLoader.loadImage("/res/textures/dark_background.jpg");
	    game_over = ImageLoader.loadImage("/res/textures/GAMEOVER.jpeg");
	    victory = ImageLoader.loadImage("/res/textures/victory.png");
	    black = ImageLoader.loadImage("/res/textures/Blackground.png");
	    home = ImageLoader.loadImage("/res/textures/home.png");
	    pause = ImageLoader.loadImage("/res/textures/pause2.png");
		exit = ImageLoader.loadImage("/res/textures/power button.png");
		easy = ImageLoader.loadImage("/res/textures/easy1.png");
		normal = ImageLoader.loadImage("/res/textures/normal1.png");
		hard = ImageLoader.loadImage("/res/textures/hard1.png");
	    
		dragon = new BufferedImage[2];
        	dragon[0] = ImageLoader.loadImage("/res/textures/draghetto.png");
            dragon[1] = ImageLoader.loadImage("/res/textures/draghetto2.png");
	    
		btn_start = new BufferedImage[2];
			btn_start[0] = ImageLoader.loadImage("/res/textures/PLAY.png");
			btn_start[1] = ImageLoader.loadImage("/res/textures/PlayDark.png");
		btn_pause = new BufferedImage[2];
            btn_pause[0] = ImageLoader.loadImage("/res/textures/pause3.png");
            btn_pause[1] = ImageLoader.loadImage("/res/textures/PauseDark.png");
        btn_exit = new BufferedImage[2];
            btn_exit[0] = ImageLoader.loadImage("/res/textures/exit.png");
            btn_exit[1] = ImageLoader.loadImage("/res/textures/exitDark.png");
        btn_exit_statoGioco = new BufferedImage[2];
            btn_exit_statoGioco[0] = ImageLoader.loadImage("/res/textures/ExitDark2.png");
            btn_exit_statoGioco[1] = ImageLoader.loadImage("/res/textures/exitDark.png");
        btn_load = new BufferedImage[2];
            btn_load[0] = ImageLoader.loadImage("/res/textures/load.png");
            btn_load[1] = ImageLoader.loadImage("/res/textures/loadDark.png");
        btn_save = new BufferedImage[2];
    		btn_save[0] = ImageLoader.loadImage("/res/textures/save.png");
    		btn_save[1] = ImageLoader.loadImage("/res/textures/save.png");
    	numbers = new BufferedImage[10];
    		numbers[0] = ImageLoader.loadImage("/res/textures/number_zero.png");
    		numbers[1] = ImageLoader.loadImage("/res/textures/number_one.png");
    		numbers[2] = ImageLoader.loadImage("/res/textures/number_two.png");
    		numbers[3] = ImageLoader.loadImage("/res/textures/number_three.png");
    		numbers[4] = ImageLoader.loadImage("/res/textures/number_four.png");
    		numbers[5] = ImageLoader.loadImage("/res/textures/number_five.png");
    		numbers[6] = ImageLoader.loadImage("/res/textures/number_six.png");
    		numbers[7] = ImageLoader.loadImage("/res/textures/number_seven.png");
    		numbers[8] = ImageLoader.loadImage("/res/textures/number_eight.png");
    		numbers[9] = ImageLoader.loadImage("/res/textures/number_nine.png");
    		
    		
    		
        ballGroup = new BufferedImage[NUM_BOLLE];
	    ballGroup[1] = ImageLoader.loadImage("/res/textures/staticRedBall.png");
	    ballGroup[2] = ImageLoader.loadImage("/res/textures/staticBlueBall.png");
	    ballGroup[3] = ImageLoader.loadImage("/res/textures/staticGreenBall.png");
	    ballGroup[4] = ImageLoader.loadImage("/res/textures/staticYellowBall.png");

	}
	
}