package dev.spaccabolle.display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;

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
	public static void saveFile(StatoMenu menuFile) {
		
		String filePath = new File("").getAbsolutePath();
		JFileChooser fileChooser = new JFileChooser(new File(filePath+"//src//res//map"));
		fileChooser.setDialogTitle("Save your game");   
		
		int retrival = fileChooser.showSaveDialog(frame);
	    if (retrival == JFileChooser.APPROVE_OPTION) {
	        try {
	            File fw = new File(fileChooser.getSelectedFile()+".txt");
	            FileInputStream in = new FileInputStream(menuFile.saveGame);
	            FileOutputStream out = new FileOutputStream(fw);
	      
	            try {
	      
	                int n;
	      
	                // read() function to read the
	                // byte of data
	                while ((n = in.read()) != -1) {
	                    // write() function to write
	                    // the byte of data
	                    out.write(n);
	                }
	            }
	            finally {
	                if (in != null) {
	      
	                    // close() function to close the
	                    // stream
	                    in.close();
	                }
	                // close() function to close
	                // the stream
	                if (out != null) {
	                    out.close();
	                }
	            }
	            System.out.println("File Copied");
	        
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