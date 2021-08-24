package dev.spaccabolle.display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import dev.spaccabolle.gfx.Assets;
import dev.spaccabolle.stati.*;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Display {

	private static JFrame frame;
	private Canvas canvas;
	
	
	private String title;
	private int width, height;
	
	public Display(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	private void createDisplay(){
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setIconImage(new ImageIcon(getClass().getResource("/res/textures/draghetto6.png")).getImage());
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		frame.add(canvas);
		frame.pack();
	}
	
	public static void closeDisplay() {
	    frame.setVisible(false);
	    frame.dispose();
	}
	
	public static void getFile() {
		JFileChooser fileChooser = new JFileChooser();
		 
	      int returnValue = fileChooser.showOpenDialog(null);
	      if (returnValue == JFileChooser.APPROVE_OPTION) {
	    	  StatoMenu.loadGame = fileChooser.getSelectedFile();
	        
	      }
	}
	public static void saveFile() {
		JFrame parentFrame = new JFrame();
		 
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Save your game");   
		 
		int userSelection = fileChooser.showSaveDialog(parentFrame);
		 
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    StatoMenu.saveGame = fileChooser.getSelectedFile();
		    System.out.println("Save as file: " +  StatoMenu.saveGame.getAbsolutePath());
		}
	
	}	
	
	
	

	public Canvas getCanvas(){
		return canvas;
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
}