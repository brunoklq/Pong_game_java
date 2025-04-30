package griffith;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainMenuTest {

    private MainMenu menu;

    @BeforeEach
    public void setup() {
        menu = new MainMenu();
    }

    @Test
    public void testPlayButtonPosition() {
        Rectangle expected = new Rectangle(GamePanel.GAME_WIDTH / 3 + 120, 150, 100, 50);
        assertEquals(expected, menu.playButton);
    }

    @Test
    public void testHelpButtonPosition() {
        Rectangle expected = new Rectangle(GamePanel.GAME_WIDTH / 3 + 120, 250, 100, 50);
        assertEquals(expected, menu.helpButton);
    }

    @Test
    public void testQuitButtonPosition() {
        Rectangle expected = new Rectangle(GamePanel.GAME_WIDTH / 3 + 120, 350, 100, 50);
        assertEquals(expected, menu.quitButton);
    }

    @Test
    public void testRenderDoesNotThrow() {
        // Create a mock Graphics2D context using a BufferedImage
        BufferedImage img = new BufferedImage(GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();

        assertDoesNotThrow(() -> {
            menu.render(g2d);
        }, "Render method should run without throwing exceptions");
    }
}