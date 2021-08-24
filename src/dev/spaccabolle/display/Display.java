package dev.spaccabolle.display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigInteger;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import dev.spaccabolle.stati.StatoMenu;

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
	
	public static File getFile() {
	    JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(frame);
            if(response == JFileChooser.APPROVE_OPTION) {
                File file= new File(fileChooser.getSelectedFile().getAbsolutePath());
                return file;
            }
            return null;
	}
	public static void saveFile() {
			
		File dir = null;
		File file = new File(dir, "savedLevel.txt");
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setDialogTitle("Save your game");
		int resp = fileChooser.showOpenDialog(null);
		if (resp == JFileChooser.APPROVE_OPTION) {
		    dir = fileChooser.getSelectedFile();
		}
	}	
	

	public Canvas getCanvas(){
		return canvas;
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
}