package dev.spaccabolle.test;

import static org.junit.jupiter.api.Assertions.*;


import javax.swing.JFileChooser;

import org.junit.jupiter.api.Test;

import dev.spaccabolle.display.Display;

class DisplayTest {
	
	@Test
	void testGetFile() {
		JFileChooser fileChooser = new JFileChooser();
		assertNotEquals(fileChooser, Display.getFile());
	}
	
	
	@Test
	void testSaveFile() {
		
		
	}

}
