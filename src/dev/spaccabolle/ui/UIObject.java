package dev.spaccabolle.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public abstract class UIObject {
	
	protected float x, y;
	protected int larghezza, altezza;
	protected Rectangle bounds;
	protected boolean sopra = false;
	
	public UIObject(float x, float y, int larghezza, int altezza){
		this.x = x;
		this.y = y;
		this.larghezza = larghezza;
		this.altezza = altezza;
		bounds = new Rectangle((int) x, (int) y, larghezza, altezza);
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public abstract void onClick();
	
	public void onMouseMove(MouseEvent e){
		if(bounds.contains(e.getX(), e.getY()))
			sopra = true;
		else
			sopra = false;
	}
	
	public void onMouseRelease(MouseEvent e){
		if(sopra)
			onClick();
	}
	
	// Getters and setters

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return larghezza;
	}

	public void setWidth(int width) {
		this.larghezza = width;
	}

	public int getHeight() {
		return altezza;
	}

	public void setHeight(int height) {
		this.altezza = height;
	}

	public boolean isHovering() {
		return sopra;
	}

	public void setHovering(boolean hovering) {
		this.sopra = hovering;
	}

}