package griffith;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.awt.event.MouseListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseEvent;


public class GamePanel2 extends JPanel implements Runnable {

	// attributes for GamePanel
	
	static final int GAME_WIDTH = 1000;

	static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));

	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);

	static final int BALL_DIAMETER = 20;

	static final int PADDLE_WIDTH = 25;

	static final int PADDLE_HEIGHT = 100;

	private MainMenu mainmenu = new MainMenu();
	
	
	public static enum STATE{ //Implementing Main Menu
		MENU,
		GAME
	};
	
	public static STATE State = STATE.MENU;

	
	// attributes inherited for GamePanel
	Thread gameThread;

	Image image;

	Graphics graphics;

	Random random;

	Paddle paddle1;
	Paddle paddle2;
	Paddle paddle1_middle;
	
	Cpu cpu;
	
	Ball ball;
	Score score;
	private BufferedImage backgroundImage;
	

	GamePanel2() throws IOException{ // constructor for gamePane

		try {
			
			backgroundImage = ImageIO.read(new File("src/griffith/image_campo.png")); // the background image drawing behind the set of paddles
			
			
		} 
		
		catch(IOException e) {
	        e.printStackTrace();
		}

		newPaddles();
		newBall();
		
		
	
		score = new Score(GAME_WIDTH,GAME_HEIGHT);

		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);


		gameThread = new Thread(this);

		gameThread.start();
		this.addMouseListener(new MouseInput());
	}
	
	
	
	public void newBall() { // method to get a new ball with ther attributes

		random = new Random();
		ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT-BALL_DIAMETER), BALL_DIAMETER,BALL_DIAMETER);

	}
	public void newPaddles() { // method to get a new paddle with ther attributes
		paddle1 = new Paddle(0, (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
		paddle1_middle = new Paddle(100, (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
		paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH, (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT, 2);
		
		cpu = new Cpu(GAME_WIDTH-PADDLE_WIDTH, (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT, 2);
		
		cpu.disableControl(); 
		
	}
	public void draw(Graphics g) { // method again to draw a graphic
		paddle1.draw(g);
		paddle1_middle.draw(g);
		cpu.draw(g); //method call for whenever the cpu is used
		ball.draw(g);
		score.draw(g);
		Toolkit.getDefaultToolkit().sync();
	}
	public void move() { // method to move the paddle and ball
		if(State == STATE.GAME) {//Main menu Code
		paddle1.move();
		paddle2.move();
		paddle1_middle.move();
		
		ball.move();
		
		cpu.autoMove(ball);
	} 
	}
	public void paint(Graphics g) { //method to paint and create image

		if(State == STATE.GAME) {//Main menu Code
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		graphics.drawImage(backgroundImage,0,0,GAME_WIDTH, GAME_HEIGHT, this);
		draw(graphics);
		
		g.drawImage(image,0,0,GAME_WIDTH, GAME_HEIGHT, this);
		}
		else if(State == STATE.MENU) {
		mainmenu.render(g);
		}

	}
public void checkCollision() { // the complex checkcollision method
		
		//bounce ball off top & bottom window edges
		if(ball.y <=0) {
			ball.setYDirection(-ball.yVelocity);
		}
		if(ball.y >= GAME_HEIGHT-BALL_DIAMETER) {
			ball.setYDirection(-ball.yVelocity);
		}
		//bounce ball off paddles
		if(ball.intersects(paddle1)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; //optional for more difficulty
			if(ball.yVelocity>0)
				ball.yVelocity++; //optional for more difficulty
			else
				ball.yVelocity--;
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		/*if(ball.intersects(paddle2)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; //optional for more difficulty
			if(ball.yVelocity>0)
				ball.yVelocity++; //optional for more difficulty
			else
				ball.yVelocity--;
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}*/
		
		if(ball.intersects(cpu)) {     //same method but fpr the cpu
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; //optional for more difficulty
			if(ball.yVelocity>0)
				ball.yVelocity++; //optional for more difficulty
			else
				ball.yVelocity--;
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		
		//stops paddles at window edges
		if(paddle1.y<=0)
			paddle1.y=0;
		if(paddle1.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
			paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;
		
		if(paddle2.y<=0)
			paddle2.y=0;
		if(paddle2.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
			paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;
		
		if(cpu.y<=0)
			cpu.y=0;
		if(cpu.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
			cpu.y = GAME_HEIGHT-PADDLE_HEIGHT;
		//give a player 1 point and creates new paddles & ball
		if(ball.x <=0) {
			score.player_2++;
			newPaddles();
			newBall();
			System.out.println("Player 2: "+score.player_2);
		}
		if(ball.x >= GAME_WIDTH-BALL_DIAMETER) {
			score.player_1++;
			newPaddles();
			newBall();
			System.out.println("Player 1: "+score.player_1);
		}
	}
	
	
	public void run() { // method to run the game in gamepanel
		long lastime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000/ amountOfTicks;
		double delta = 0;
		while(true) {
			
			long now = System.nanoTime();
			delta += ( now - lastime)/ns;
			lastime = now;
			if(delta >=1)
			{
				cpu.autoMove(ball);
				move();
				checkCollision();
				repaint();
				delta--;
			}
			
		}
	
	}
	public class AL extends KeyAdapter { // method to read the event to get keyboard values
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
			paddle1_middle.keyPressed(e);
		}

		public void keyReleased(KeyEvent e) {// method to read the event to get keyboard values
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
			paddle1_middle.keyPressed(e);
		}
	
		
	
	
	}

	
	
}