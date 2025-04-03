package griffith;

public class Paddle extends Rectangle {
	
	int id;
	int yVelocity;
	int speed = 10;
	
	//Initialize values
	Paddle(int x, int y, int width, int height, int id) {
		
		super(x, y, width, height);
		this.id = id;
	}
	
	public void keyPressed(KeyEvent e) {
		
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
	
	public void setYDirection(int yDirection) {
		
	}
	public void move() {
		
	}
	public void drawn(Graphics g) {
		
	}
}
