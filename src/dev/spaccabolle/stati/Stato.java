package dev.spaccabolle.stati;

import java.awt.Graphics;
import java.io.File;

import dev.spaccabolle.Handler;

public abstract class Stato {
	
	private static Stato statoCorrente = null;
	public static File level;
	
	public static void setState(Stato state){
		statoCorrente = state;
	}
	
	public static Stato getState(){
		return statoCorrente;
	}
	
	
	//CLASS
	
	protected Handler handler;
	
	public Stato(Handler handler){
		this.handler = handler;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
