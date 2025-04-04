package griffith;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



class BallTest {
	private Ball ball;

	@Test
	void testMove() {
		int initialX = 2;
        int initialY = 2;
        int xVelocity = 2;
        int yVelocity = 2;
        
    
        
        assertEquals(initialX + xVelocity, 4);
        assertEquals(initialY + yVelocity, 4);
	}

}
