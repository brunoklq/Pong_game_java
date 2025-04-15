package griffith;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Paddle extends Rectangle {

    private static final long serialVersionUID = 1L;

    int id;
    int yVelocity;
    int speed = 10;

    private final int initialY;
    private Color color = Color.WHITE;
    private boolean controllable = true;

    // Constructor assigns paddle position and ID, sets initial position and color
    public Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
        this.initialY = y;
        this.color = (id == 1) ? Color.BLUE : Color.RED; // Default color per player
    }

    // Resets the paddle's position to its initial Y coordinate
    public void resetPosition() {
        y = initialY;
    }

    // Enables paddle control (e.g., for human player)
    public void enableControl() {
        controllable = true;
    }

    // Disables paddle control (e.g., for AI or pause)
    public void disableControl() {
        controllable = false;
    }

    // Returns whether the paddle is currently controllable
    public boolean isControllable() {
        return controllable;
    }

    // Returns the paddle's current color
    public Color getColor() {
        return color;
    }

    // Sets the direction and magnitude of vertical movement
    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }

    // Updates paddle position and restricts movement within screen bounds
    public void move() {
        y += yVelocity;

        // Prevent paddle from moving off-screen vertically
        if (y < 0) {
            y = 0;
        }
        if (y > GamePanel.GAME_HEIGHT - height) {
            y = GamePanel.GAME_HEIGHT - height;
        }
    }

    // Draws the paddle with its assigned color
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    
	}
    

    // Handles keyboard input for paddle movement
    public void keyPressed(KeyEvent e) {
        if (!controllable) return;

        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(-speed);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(speed);
                    move();
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(-speed);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(speed);
                    move();
                }
                break;
        }
    }

    // Handles key release to stop paddle movement
    public void keyReleased(KeyEvent e) {
        if (!controllable) return;

        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(0);
                    move();
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(0);
                    move();
                }
                break;
        }
    }
}
