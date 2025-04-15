package griffith;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import javax.swing.*;


public class GameFrame extends JFrame{ // class getting JFrame

	GamePanel panel;
	
	//general panel to have the frame of game
	
	GameFrame() throws IOException{ // constructor for GameFrame
		
		panel = new GamePanel();
		this.add(panel);
		this.setTitle("Pong Game");
		this.setResizable(false);
		this.setBackground(Color.blue);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}