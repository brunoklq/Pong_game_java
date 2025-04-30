package griffith;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GamePanel4Test {

    GamePanel4 panel;

    @BeforeEach
    void setUp() throws IOException {
        panel = new GamePanel4();
    }

    @Test
    void testNewBall() {
        panel.newBall();
        Ball ball = panel.ball;

        assertNotNull(ball, "Ball should be initialized");
        assertEquals((GamePanel4.GAME_WIDTH / 2) - (GamePanel4.BALL_DIAMETER / 2), ball.x, "Ball X should be centered");
        assertTrue(ball.y >= 0 && ball.y <= GamePanel4.GAME_HEIGHT - GamePanel4.BALL_DIAMETER, "Ball Y should be within screen bounds");
    }

    @Test
    void testNewPaddles() {
        panel.newPaddles();

        assertNotNull(panel.paddle1, "paddle1 should not be null");
        assertNotNull(panel.paddle1_middle, "paddle1_middle should not be null");
        assertNotNull(panel.paddle2, "paddle2 shouldt bne null");
        assertNotNull(panel.paddle2_middle, "paddle2_middle should not be null");

        assertTrue(panel.paddle1.isControllable(), "paddle1 should be controllable");
        assertTrue(panel.paddle1_middle.isControllable(), "paddle1_middle should be controllable");
        assertTrue(panel.paddle2.isControllable(), "paddle2 should be controllable");
        assertTrue(panel.paddle2_middle.isControllable(), "paddle2_middle should be controllable");

     
    }
}
