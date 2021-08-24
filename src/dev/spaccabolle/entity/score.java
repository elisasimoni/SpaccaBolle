package dev.spaccabolle.entity;

import java.awt.Graphics;

import dev.spaccabolle.gfx.Assets;

public class score {
	
	public int tempPoint=0;
	public int number;
	public int number1;
	public int number2;
	public int number3;
	
	

	public score(int number, int number1, int number2, int number3) {
		this.number=number;
		this.number1=number1;
		this.number2=number2;
		this.number3=number3;
		
		
	}
	
	public void addPoint(int point) {

           this.tempPoint =this.tempPoint + point;
		
		
			for (int i = 0; i <= 3; i++) {
			    int definitive = tempPoint/(power(10, 3-i)); //prima le centinaia, poi le decine e infine le unità
			    switch(i) {
		    	case 0: number=definitive;
		    			break;
		    	case 1: number1=definitive;
		    			break;
		    	case 2: number2=definitive;
		    			break;
		    	case 3: number3=definitive;
		    			break;
		    	default:
		    			break;
		    }
			    tempPoint = tempPoint - definitive * power(10, 3-i);
			    
			}
			
			
			
		
	}
/* Questa funzione calcola la potenza V-ima di un numero 
intero U (U e V sono i parametri della funzione).
*/
	private static int power(int U, int V) {
			int risp = 1;  // inizializzo la risposta finale;
			for (int i = 1; i <= V; i++) 
			    risp *= U;
			return risp;
		    }
	
	public void render(Graphics g) {
		g.drawImage(Assets.numbers[number], 340, 720, 50, 50, null);
		g.drawImage(Assets.numbers[number1], 380, 720, 50, 50, null);
		g.drawImage(Assets.numbers[number2], 420, 720, 50, 50, null);
		g.drawImage(Assets.numbers[number3], 460, 720, 50, 50, null);
	}
	

}
