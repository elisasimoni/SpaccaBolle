package dev.spaccabolle.score;

import java.awt.Graphics;

import dev.spaccabolle.gfx.Assets;

public class Score {
	
	
	public static int tempPoint=0;
	public static int tempFlyngPoint=0;
	public static int number1;
	public static int number2;
	public static int number3;
	public static int number4;
	
	

	public Score( final int n1, final int n2, final int n3, final int n4 ) {
		Score.number1 = n1;
		Score.number2 = n2;
		Score.number3 = n3;
		Score.number4 = n4;
	}
	
	public void addPoint( int point, int flyngPoint ) {
		Score.tempPoint = Score.tempPoint + ( point * 10 );
        Score.tempFlyngPoint = (int)( Score.tempFlyngPoint + ( Math.pow(2, flyngPoint) ) );
        Score.tempPoint = Score.tempPoint + Score.tempFlyngPoint;
		
		for (int i = 0; i <= 3; i++) {
			int definitive = Score.tempPoint / ( power(10, 3-i) ); //prima le centinaia, poi le decine e infine le unità
			switch(i) {
		    	case 0: Score.number1 = definitive;
		    		break;
		    	case 1: Score.number2 = definitive;
		    		break;
		    	case 2: Score.number3 = definitive;
		    		break;
		    	case 3: Score.number4=definitive;
		    		break;
		    	default:
		    		break;
		    }
			
			Score.tempPoint = Score.tempPoint - definitive * power(10, 3-i);   
		}		
	}
	

	private static int power(int U, int V) {
			int risp = 1;  
			for (int i = 1; i <= V; i++) { 
			    risp = risp * U;
			}
			return risp;
	}
	
	public void render(Graphics g) {
		g.drawImage(Assets.numbers[Score.number1], 340, 600, 50, 50, null);
		g.drawImage(Assets.numbers[Score.number2], 380, 600, 50, 50, null);
		g.drawImage(Assets.numbers[Score.number3], 420, 600, 50, 50, null);
		g.drawImage(Assets.numbers[Score.number4], 460, 600, 50, 50, null);
	}
	

}
