package griffith;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaddleTest {

    Paddle paddle;

    @BeforeEach
    void setUp() {
        paddle = new Paddle(0, 200, 25, 100, 1); // x, y, width, height, id
    }

    @Test
    void testGetCenterY() {
        assertEquals(250, paddle.getCenterY()); // 200 + 100/2 = 250
    }
    
    @Test
    void testResetPosition() {
        paddle.y = 0; // move it somewhere else
        paddle.resetPosition();
        assertEquals(200, paddle.y); // should return to the initial y
    }

}
