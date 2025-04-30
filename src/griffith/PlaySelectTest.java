package griffith;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlaySelectTest {

    private PlaySelect playSelect;

    @BeforeEach
    public void setup() {
        playSelect = new PlaySelect();
    }

    @Test
    public void testSingleButtonPosition() {
        Rectangle expected = new Rectangle(GamePanel.GAME_WIDTH / 3 + 120, 150, 128, 50);
        assertEquals(expected, playSelect.singleButton);
    }

    @Test
    public void testDoubleTroubleButtonPosition() {
        Rectangle expected = new Rectangle(GamePanel.GAME_WIDTH / 3 + 120, 250, 260, 50);
        assertEquals(expected, playSelect.dtButton);
    }

    @Test
    public void testDuoButtonPosition() {
        Rectangle expected = new Rectangle(GamePanel.GAME_WIDTH / 3 + 120, 350, 100, 50);
        assertEquals(expected, playSelect.duoButton);
    }

    @Test
    public void testDoubleTrouble2ButtonPosition() {
        Rectangle expected = new Rectangle(GamePanel.GAME_WIDTH / 3 + 120, 450, 280, 50);
        assertEquals(expected, playSelect.dt2Button);
    }

    @Test
    public void testRenderDoesNotThrow() {
        BufferedImage image = new BufferedImage(GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        assertDoesNotThrow(() -> {
            playSelect.render(g2d);
        }, "Render method should run without throwing exceptions");
    }
}