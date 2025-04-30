package griffith;

import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle {

    private static final long serialVersionUID = 1L;

    private static final int DEFAULT_SPEED = 10;

    int id;
    int yVelocity;
    int speed;
    private final int initialY;
    private Color color = Color.WHITE;
    private boolean controllable = true;

    /**
     * Assigns paddle position and ID, sets initial position and color.
     */
    public Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
        this.initialY = y;
        this.color = getColorById(id);
        this.speed = DEFAULT_SPEED;
    }

    /**
     * Resets the paddle to initial position.
     */
    public void resetPosition() {
        y = initialY;
    }

    /**
     * Enables user control for the paddle.
     */
    public void enableControl() {
        controllable = true;
    }

    
    /**
     * Disables user control for the paddle (used for AI or paused state).
     */
    public void disableControl() {
        controllable = false;
    }

    /**
     * Returns whether the paddle is currently controllable.
     */
    public boolean isControllable() {
        return controllable;
    }

    /**
     * Returns the paddle's assigned color.
     * 
     */
    public Color getColor() {
        return color;
    }

    /**
     * Helper to choose paddle color based on ID.
     */
    private Color getColorById(int id) {
        if (id == 1) return Color.BLUE;
        if (id == 2) return Color.RED;
        return Color.WHITE; // fallback
    }

    /**
     * Sets the vertical movement direction of the paddle.
     */
    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }

    /**
     * Updates the paddle's vertical position based on its velocity,
     * and restricts it within the game panel boundaries.
     */
    public void move() {
        y += yVelocity;

        if (y < 0) {
            y = 0;
        } else if (y > (GamePanel.GAME_HEIGHT - height)) {
            y = GamePanel.GAME_HEIGHT - height;
        }
    }

    /**
     * Draws the paddle on screen with its assigned color.
     */
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    /**
     * Returns the vertical center Y position of the paddle.
     */
    public double getCenterY() {
        return y + height / 2;
    }

    /**
     * Handles key press events to control paddle movement.
     */
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
                break;}
    }

    /**
     * Handles key release events to stop paddle movement.
     */
    public void keyReleased(KeyEvent e) {
        if (!controllable) return;

        int key = e.getKeyCode();

        if ((id == 1 && (key == KeyEvent.VK_W || key == KeyEvent.VK_S)) ||
            (id == 2 && (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN))) {
            setYDirection(0);
        }
    }
}
