
package griffith;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

class PaddleTest {

    Paddle paddle;

    @BeforeEach
    void setUp() {
        paddle = new Paddle(0, 200, 25, 100, 1); // Player 1 paddle
    }

    // Test if getCenterY correctly returns the paddle's vertical center
    @Test
    void testGetCenterY() {
        assertEquals(250, paddle.getCenterY()); // 200 + 100/2 = 250
    }

    // Test if the paddle resets to its initial Y position
    @Test
    void testResetPosition() {
        paddle.y = 50;
        paddle.resetPosition();
        assertEquals(200, paddle.y);
    }

    // Test that the paddle does not move outside the top or bottom screen bounds
    @Test
    void testBoundaryRestriction() {
        paddle.y = -100;
        paddle.move();
        assertTrue(paddle.y >= 0);

        paddle.y = GamePanel.GAME_HEIGHT + 100;
        paddle.move();
        assertTrue(paddle.y <= GamePanel.GAME_HEIGHT - paddle.height);
    }

    // Test that paddle color is correctly assigned based on ID
    @Test
    void testColorAttribute() {
        assertEquals(Color.BLUE, paddle.getColor()); // Player 1 default color is blue
    }

    // Test enabling and disabling paddle controls
    @Test
    void testControlToggle() {
        paddle.disableControl();
        assertFalse(paddle.isControllable());

        paddle.enableControl();
        assertTrue(paddle.isControllable());
    }
}
