package griffith;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;


public class GameFrame2 extends JFrame{ // class getting JFrame

	GamePanel2 panel2;
	
	//general panel to have the frame of game
	
	GameFrame2() throws IOException{ // constructor for GameFrame
		
		panel2 = new GamePanel2();
		this.add(panel2);
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