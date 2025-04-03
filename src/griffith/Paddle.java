package griffith;

import java.awt.event.KeyEvent;

import com.sun.prism.Graphics;
import com.sun.prism.paint.Color;

public class Paddle extends Rectangle {
	
	int id;
	int yVelocity;
	int speed = 10;
	
	//Initialize values
	Paddle(int x, int y, int width, int height, int id) {
		
		super(x, y, width, height);
		this.id = id;
	}
	//Handle keys for player 1 (W,S) and player 2 (UP,DOWN)
	public void keyPressed(KeyEvent e) {
		switch(id) {
		case 1:
			if(e.getKeyCode() == KeyEvent.VK_W) setYDirection(-speed);
			if(e.getKeyCode() == KeyEvent.VK_S) setYDirection(speed);
			break;
		case 2:
			if(e.getKeyCode() == KeyEvent.VK_UP) setYDirection(-speed);
			if(e.getKeyCode() == KeyEvent.VK_DOWN) setYDirection(speed);
			break;
		}
	}
	//Stop Paddle Movement
		public void keyReleased(KeyEvent e) {
		    switch(id) {
		    case 1:
		    	if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S)
		    		setYDirection(0);
		    	break;
		    case 2:
		    	if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN)
		    		setYDirection(0);
		    	break;
		    }		
	}
	
	public void setYDirection(int yDirection) {
		yVelocity = yDirection;
	}
	public void move() {
		y += yVelocity;
	}
	public void drawn(Graphics g) {
		if (id == 1) g.setColor(Color.BLUE);
		else g set.Color(Color.RED);
		
		g.fillRect(x, y, width, height);
	}
}
