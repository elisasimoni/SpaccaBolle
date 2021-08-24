package dev.spaccabolle.display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.io.File;
import java.io.FileWriter;

import javax.swing.ImageIcon;
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
		frame.setIconImage(new ImageIcon(getClass().getResource("/res/textures/draghetto4.png")).getImage());
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
		
		@SuppressWarnings("unused")
		String filePath = new File("").getAbsolutePath();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Save your game");   
		@SuppressWarnings("unused")
		int userSelection = fileChooser.showSaveDialog(frame);
		
		int retrival = fileChooser.showSaveDialog(null);
	    if (retrival == JFileChooser.APPROVE_OPTION) {
	        try {
	            FileWriter fw = new FileWriter(fileChooser.getSelectedFile()+".txt");
	            
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	
	}	

	public Canvas getCanvas(){
		return canvas;
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
}