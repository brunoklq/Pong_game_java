package griffith;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class Paddle extends Rectangle {

    int id;
    int yVelocity;
    int speed = 10; //Speed of paddle
    private final int initialY = y;

    public Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
    }
    //Handle key presses to set paddle direction
    public void keyPressed(KeyEvent e) {
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(-speed);
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(speed);
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(-speed);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(speed);
                }
                break;
        }
    }
    //Handle key releases to stop paddle
    public void keyReleased(KeyEvent e) {
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(-10);
                    move();
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(-10);
                    move();
                }
                break; // need to change the paddle and run this properly!
        }
    }
    //Direction of movement
    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }
    
    public void move() {
        y += yVelocity;

        // Keep paddle inside screen vertically
        if (y < 0) {
            y = 0;
        }
        if (y > GamePanel.GAME_HEIGHT - height) {
            y = GamePanel.GAME_HEIGHT - height;
        }
    }
    
    //reset the paddle to its original Y position
    public void resetPosition() {
        y = initialY;
    }
    
    //Draw the paddle on screen
    public void draw(Graphics g) {
        if (id == 1) {
            g.setColor(Color.blue);
        } else {
            g.setColor(Color.red);
        }
        g.fillRect(x, y, width, height);
    }
}
