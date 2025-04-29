package griffith;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import javax.swing.*;



public class PongGame {

	
	public static void main(String[] args) throws IOException { // the main method 
		
		JFrame frame = new JFrame();
		GamePanel panel = new GamePanel();
		GamePanel2 panel2 = new GamePanel2();
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel2);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		
		//The game is ready and now with a background with a field sccoer game
		
	}
	
}
