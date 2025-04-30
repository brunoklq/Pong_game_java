package griffith;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GamePanel3 extends JPanel implements Runnable {

    // Constants for the game window
    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int) (GAME_WIDTH * 0.5555);
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;

    // Game objects and assets
    private MainMenu mainmenu = new MainMenu();
    private Sound sound;
    private boolean soundStarted = false;

    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;

    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;
    private BufferedImage backgroundImage;

    // Constructor
    public GamePanel3() throws IOException {
        try {
            backgroundImage = ImageIO.read(new File("src/griffith/image_campo3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        newPaddles();
        newBall();

        score = new Score(GAME_WIDTH, GAME_HEIGHT);
        sound = new Sound(); // ✅ Initialize sound object

        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.requestFocusInWindow();
        this.setPreferredSize(SCREEN_SIZE);
        this.addMouseListener(new MouseInput());

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newBall() {
        random = new Random();
        ball = new Ball((GAME_WIDTH / 2) - (BALL_DIAMETER / 2), random.nextInt(GAME_HEIGHT - BALL_DIAMETER),
                BALL_DIAMETER, BALL_DIAMETER);
    }

    public void newPaddles() {
        paddle1 = new Paddle(0, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
        paddle2 = new Paddle(GAME_WIDTH - PADDLE_WIDTH, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2),
                PADDLE_WIDTH, PADDLE_HEIGHT, 2);
        
        paddle1.enableControl();
        paddle2.enableControl();
    }

    public void draw(Graphics g) {
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    public void move() {
        paddle1.move();
        paddle2.move();
        ball.move();
    }

    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        graphics.drawImage(backgroundImage, 0, 0, GAME_WIDTH, GAME_HEIGHT, this);
        draw(graphics);
        g.drawImage(image, 0, 0, GAME_WIDTH, GAME_HEIGHT, this);
    }

    public void checkCollision() {
        // Bounce ball off top and bottom
        if (ball.y <= 0) {
            ball.setYDirection(-ball.yVelocity);
        }
        if (ball.y >= GAME_HEIGHT - BALL_DIAMETER) {
            ball.setYDirection(-ball.yVelocity);
        }

        // Bounce ball off paddles
        if (ball.intersects(paddle1)) {
            ball.xVelocity = Math.abs(ball.xVelocity) + 1;
            ball.yVelocity += (ball.yVelocity > 0) ? 1 : -1;
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }

        if (ball.intersects(paddle2)) {
            ball.xVelocity = Math.abs(ball.xVelocity) + 1;
            ball.yVelocity += (ball.yVelocity > 0) ? 1 : -1;
            ball.setXDirection(-ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }

        // Prevent paddles from going out of bounds
        if (paddle1.y <= 0) paddle1.y = 0;
        if (paddle1.y >= GAME_HEIGHT - PADDLE_HEIGHT) paddle1.y = GAME_HEIGHT - PADDLE_HEIGHT;
        if (paddle2.y <= 0) paddle2.y = 0;
        if (paddle2.y >= GAME_HEIGHT - PADDLE_HEIGHT) paddle2.y = GAME_HEIGHT - PADDLE_HEIGHT;

        // Score and reset
        if (ball.x <= 0) {
            score.player_2++;
            newPaddles();
            newBall();
            System.out.println("Player 2: " + score.player_2);
        }
        if (ball.x >= GAME_WIDTH - BALL_DIAMETER) {
            score.player_1++;
            newPaddles();
            newBall();
            System.out.println("Player 1: " + score.player_1);
        }
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1_000_000_000 / amountOfTicks;
        double delta = 0;

        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            if (delta >= 1) {
                if (!soundStarted && sound != null) {
                    sound.setFile(6);
                    sound.loop();
                    soundStarted = true;
                }
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }

    // Key adapter for keyboard input
    public class AL extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);
        }
    }
}
