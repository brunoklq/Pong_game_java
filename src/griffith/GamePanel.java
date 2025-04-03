package griffith;

import java.awt.*;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public abstract class GamePanel extends JPanel implements Runnable{
	
	Paddle paddle1;
	Paddle paddle2;
	
	static final int GAME_WIDTH = 1000;

	static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
	
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);

	static final int BALL_DIAMETER = 20;

	static final int PADDLE_WIDTH = 25;

	static final int PADDLE_HEIGHT = 100;

	Thread gameThread;

	Image image;

	Graphics graphics;

	Random random;

	}

			GamePanel(){
			
				
			
				this.setPreferredSize(SCREEN_SIZE);
				
				random = new Random();

				paddle1 = new Paddle(0, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
				paddle2 = new Paddle(GAME_WIDTH - PADDLE_WIDTH, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2), PADDLE_WIDTH, PADDLE_HEIGHT, 2);
			
				
			
				gameThread = new Thread(this);
			
				gameThread.start();
			
			}
				}


