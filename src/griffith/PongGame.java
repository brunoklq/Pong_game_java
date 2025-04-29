package griffith;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import javax.swing.*;



public class PongGame extends MouseInput {

	
	public static boolean useFirstGame=false;


	public static void main(String[] args) throws IOException { // the main method 
		
		
		MouseInput menu = new MouseInput();
		
		
		
		launchGame(useFirstGame);
		
	
}
	

	public static void launchGame(boolean useFirstGame) throws IOException {
	    JFrame gameFrame = new JFrame();
	    
	    if (useFirstGame) {
	        GamePanel gamePanel = new GamePanel();
	        gameFrame.add(gamePanel);
	    } else {
	        GamePanel2 gamePanel2 = new GamePanel2();
	        gameFrame.add(gamePanel2);
	    }
	    gameFrame.pack();
	    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    gameFrame.setVisible(true);
	    
	    
	}

	

}
