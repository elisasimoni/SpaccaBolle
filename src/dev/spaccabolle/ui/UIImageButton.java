package dev.spaccabolle.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject {

	private BufferedImage[] immagini;
	private ClickListener clicker;
	
	public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
		super(x, y, width, height);
		this.immagini = images;
		this.clicker = clicker;
	}

	public void tick() {}

	public void render(Graphics g) {
		if(sopra)
			g.drawImage(immagini[1], (int) x, (int) y, larghezza, altezza, null);
		else
			g.drawImage(immagini[0], (int) x, (int) y, larghezza, altezza, null);
	}

	public void onClick() {
		clicker.onClick();
	}

}