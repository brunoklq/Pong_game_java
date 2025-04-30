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


public class GamePanel extends JPanel implements Runnable {

	// attributes for GamePanel

	
	static final int GAME_WIDTH = 1000;

	static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));

	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);

	static final int BALL_DIAMETER = 20;

	static final int PADDLE_WIDTH = 25;

	static final int PADDLE_HEIGHT = 100;

	private MainMenu mainmenu = new MainMenu();
	
	private PlaySelect playselect = new PlaySelect(); 
	
	Sound sound = new Sound();
	
	public static enum STATE{ //Implementing Main Menu
		MENU,
		SELECT,
		GAME,
		GAME2,
		GAME3,
		GAME4
	};
	
	public static STATE State = STATE.MENU;

	
	// attributes inherited for GamePanel
	Thread gameThread;
	Random random;
	
	Image image;

	Graphics graphics;


	Paddle paddle1;
	Paddle paddle2;
	//Paddle paddle1_middle;
	
	Cpu cpu;
	Cpu cpu2;
	
	Ball ball;
	Score score;
	private BufferedImage backgroundImage;
	
	

	GamePanel() throws IOException{ // constructor for gamePane

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
		this.addMouseListener(new MouseInput());
		this.setPreferredSize(SCREEN_SIZE);


		gameThread = new Thread(this);
		gameThread.start();
		
		

		sound.setFile(0); // index 5 is the song for this one
		sound.play();
		sound.loop(); 

		
	}
	
	
	
	public void newBall() { // method to get a new ball with ther attributes

		random = new Random();
		ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT-BALL_DIAMETER), BALL_DIAMETER,BALL_DIAMETER);

	}
	public void newPaddles() { // method to get a new paddle with ther attributes
		paddle1 = new Paddle(0, (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
		//paddle1_middle = new Paddle(45, (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
		paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH, (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT, 2);
		
		cpu = new Cpu(GAME_WIDTH-PADDLE_WIDTH, (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT, 2);
		cpu.disableControl(); 
		cpu2 = new Cpu(GAME_WIDTH-PADDLE_WIDTH, (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT, 2);
		cpu2.disableControl();
		
	}
	public void draw(Graphics g) { // method again to draw a graphic
		paddle1.draw(g);
		//paddle1_middle.draw(g);
		cpu.draw(g); //method call for whenever the cpu is used
		ball.draw(g);
		score.draw(g);
		Toolkit.getDefaultToolkit().sync();
	}
	public void move() { // method to move the paddle and ball
		if(State == STATE.GAME) {//Main menu Code
		paddle1.move();
		paddle2.move();
		//paddle1_middle.move();
		
		ball.move();
		cpu.autoMove(ball);
	} 
	}
    public void paint(Graphics g) {
        if (State == STATE.GAME || State == STATE.GAME2) {
            image = createImage(getWidth(), getHeight());
            graphics = image.getGraphics();
            graphics.drawImage(backgroundImage, 0, 0, GAME_WIDTH, GAME_HEIGHT, this);
            draw(graphics);
            g.drawImage(image, 0, 0, GAME_WIDTH, GAME_HEIGHT, this);
        } else if (State == STATE.MENU) {
            mainmenu.render(g);
        } else if (State == STATE.SELECT) {
            playselect.render(g);
        }
    }
	
	
    public void checkCollision() { // the complex checkcollision method
        
        // Wall Bounce
        if (ball.y <= 0 || ball.y >= GAME_HEIGHT - BALL_DIAMETER) {
            ball.setYDirection(-ball.yVelocity);
            sound.setFile(1); // Wall bounce sound
            sound.play(); // Play the wall bounce sound
        }

        // Paddle Collision (Player 1)
        if (ball.intersects(paddle1)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;
            ball.yVelocity += ball.yVelocity > 0 ? 1 : -1;
            ball.setXDirection(ball.xVelocity);
            
            sound.setFile(3); // Paddle bounce sound for player paddle
            sound.play(); // Play the paddle bounce sound
        }

        // Paddle Collision (CPU)
        if (ball.intersects(cpu)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;
            ball.yVelocity += ball.yVelocity > 0 ? 1 : -1;
            ball.setXDirection(-ball.xVelocity);
            
            sound.setFile(3); // Paddle bounce sound for CPU paddle
            sound.play(); // Play the paddle bounce sound
        }

       
        if (ball.intersects(paddle2)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;
            ball.yVelocity += ball.yVelocity > 0 ? 1 : -1;
            ball.setXDirection(-ball.xVelocity);
            
            sound.setFile(4); // Another paddle bounce sound if needed
            sound.play(); // Play the paddle bounce sound
        }

        if (paddle1.y < 0) paddle1.y = 0;
        if (paddle1.y > GAME_HEIGHT - PADDLE_HEIGHT) paddle1.y = GAME_HEIGHT - PADDLE_HEIGHT;

        if (paddle2.y < 0) paddle2.y = 0;
        if (paddle2.y > GAME_HEIGHT - PADDLE_HEIGHT) paddle2.y = GAME_HEIGHT - PADDLE_HEIGHT;

        if (ball.x <= 0) {
            score.player_2++;
            newPaddles();
            newBall();
        }

        if (ball.x >= GAME_WIDTH - BALL_DIAMETER) {
            score.player_1++;
            newPaddles();
            newBall();
        }
    }

	
	public void run() { // method to run the game in gamepanel
		long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        

        boolean introPlaying = true;
        

        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            boolean cpuMusicPlaying = false;


            if (delta >= 1) {
                switch (State) {
                    case GAME:
                    case GAME2:
                    case GAME3:
                    case GAME4:
                        if (introPlaying) {
                            sound.stop(); // Stop intro music
                            introPlaying = false;
                            
                            if (State == STATE.GAME && !cpuMusicPlaying) {
                                sound.stop(); // Stop any other music playing
                                sound.setFile(5); // Set the CPU song
                                sound.play();
                                sound.loop(); // Loop the CPU song
                                cpuMusicPlaying = true;
                            }
                        }
                        cpu.autoMove(ball);
                        if (State == STATE.GAME2) cpu2.autoMove(ball);
                        move();
                        checkCollision();
                        repaint();
                        break;

                    case MENU:
                    case SELECT:
                        repaint();
                        break;
                }
                delta--;
            }
        }

    }
	
	public class AL extends KeyAdapter { // method to read the event to get keyboard values
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
			//paddle1_middle.keyPressed(e);
		}

		public void keyReleased(KeyEvent e) {// method to read the event to get keyboard values
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
			//paddle1_middle.keyPressed(e);
		}
	
		
	
	
	}

	
	
}