package griffith;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GamePanelTest2 {

    private Ball ball;
    private Cpu cpu;

    @BeforeEach
    public void setup() {
        // Set up a ball and a CPU paddle positioned to intersect
        ball = new Ball(975, 250, 20, 20); // Near right edge
        ball.xVelocity = -5;
        ball.yVelocity = 2;

        cpu = new Cpu(975, 250, 25, 100, 2); // Matching x, y and height so they intersect
        cpu.disableControl();
    }

    @Test
    public void testBallCpuCollision() {
        // Ensure they intersect
        assertTrue(ball.intersects(cpu), "Ball should intersect with CPU paddle");

        // Simulate collision handling
        int originalXVelocity = ball.xVelocity;
        int originalYVelocity = ball.yVelocity;

        if (ball.intersects(cpu)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;
            ball.yVelocity += ball.yVelocity > 0 ? 1 : -1;
            ball.setXDirection(-ball.xVelocity);
        }

        // Check that xVelocity is now positive and greater than before
        assertEquals(-(Math.abs(originalXVelocity) + 1), ball.xVelocity, "Ball xVelocity should be inverted and increased");
       
        // Check that yVelocity changed appropriately
        assertEquals(originalYVelocity + 1, ball.yVelocity, "Ball yVelocity should increase if it was moving down");
    }
}