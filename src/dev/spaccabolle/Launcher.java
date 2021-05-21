package dev.spaccabolle;

public class Launcher {
    
    public static final int GAME_WIDTH = 840;
    public static final  int GAME_HEIGHT = 920;

	public static void main(String[] args){
		Game game = new Game("SPACCABOLLE", GAME_WIDTH, GAME_HEIGHT);
		game.start();
	}
	
}
