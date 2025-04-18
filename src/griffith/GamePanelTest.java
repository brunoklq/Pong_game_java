package griffith;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class GamePanelTest {

	@Test
    public void testGamePanelInitialization() {
        try {
            GamePanel panel = new GamePanel();

            // Check if components are initialized
            assertNotNull(panel);
            assertNotNull(panel.score);
            assertNotNull(panel.ball);
            assertNotNull(panel.paddle1);
            assertNotNull(panel.cpu); // you used cpu instead of paddle2

            // Check screen size dimensions
            assertEquals(1000, panel.getPreferredSize().width);
            assertEquals((int)(1000 * 0.5555), panel.getPreferredSize().height);

        } catch (IOException e) {
            fail("GamePanel threw IOException during initialization.");
        }
    }

}
