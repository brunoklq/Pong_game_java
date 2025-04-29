package griffith;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;


public class GameFrame2 extends JFrame{ // class getting JFrame

	GamePanel panel;
	
	//general panel to have the frame of game
	
	GameFrame2() throws IOException{ // constructor for GameFrame
		
		panel = new GamePanel();
		this.add(panel);
		this.setTitle("Pong Game");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.addMouseListener(new MouseInput());
	}
}