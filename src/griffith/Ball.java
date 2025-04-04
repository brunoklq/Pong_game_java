package griffith;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class Ball extends Rectangle{ // class for ball 
	
	
	//attributes
	Random random;
	int xVelocity;
	int yVelocity;
	int initialSpeed = 1;

	Ball(int x, int y, int width, int height){ // constructor for ball
		super(x,y,width,height);
		random = new Random();
		int randomXDirection = random.nextInt(1);
		if(randomXDirection == 0)
			randomXDirection--;
		setXDirection(randomXDirection*initialSpeed);
		
		int randomYDirection = random.nextInt(1);
		if(randomYDirection == 0)
			randomYDirection--;
		setYDirection(randomYDirection*initialSpeed);
		
		
	}
	
	public void setXDirection(int randomXDirection) { // method to set direction x
		xVelocity = randomXDirection;
	}
	public void setYDirection(int randomYDirection) {// method to set direction y
		yVelocity = randomYDirection;
	}
	
	public void move() { // method to move ball
		x += xVelocity;
		y += yVelocity;
	}
	public void draw(Graphics g) { // method to draw the graphics of ball
		g.setColor(Color.white);
		g.fillOval(x, y, height, width);
	}



}

