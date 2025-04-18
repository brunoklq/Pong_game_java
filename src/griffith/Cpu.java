package griffith;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Cpu extends Rectangle {
	

	    private static final long serialVersionUID = 1L;

	    int id;
	    int yVelocity;
	    int speed = 10;
	    
	    int centerY = y + height / 2;
	    
	    private long lastMoveTime = 0;
	    private final long MOVE_INTERVAL = 16;
       

	    private final int initialY;
	    private Color color = Color.WHITE;
	    private boolean controllable = true;

	    // Constructor assigns paddle position and ID, sets initial position and color
	    public Cpu(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
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
	    

	    // Handles cpu movement
	    
	    public void autoMove(Ball ball) {
	        if (!controllable) {
	            long currentTime = System.currentTimeMillis();
	            if (currentTime - lastMoveTime >= MOVE_INTERVAL) {
	                lastMoveTime = currentTime;

	                int centerY = y + height / 2;
	                int ballCenterY = ball.y + ball.height / 2;

	                if (Math.abs(centerY - ballCenterY) > speed) {
	                    if (centerY < ballCenterY) {
	                        setYDirection(speed);
	                    } else {
	                        setYDirection(-speed);
	                    }
	                } else {
	                    setYDirection(0);
	                }

	                move();
	            }
	        }
	    }}


