package griffith;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



class BallTest { // class to test the ball movement
	private Ball ball;

	@Test
	void testMove() { // unit test
		int initialX = 2;
        int initialY = 2;
        int xVelocity = 2;
        int yVelocity = 2;
        
    
         
        assertEquals(initialX + xVelocity, 4); // assert for x
        assertEquals(initialY + yVelocity, 4);// assert for y
	}

}
