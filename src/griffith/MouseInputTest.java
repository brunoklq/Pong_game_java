package griffith;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.MouseEvent;
import javax.swing.JFrame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MouseInputTest {

    private MouseInput mouseInput;
    private JFrame testFrame;

    @BeforeEach
    public void setup() {
        mouseInput = new MouseInput();
        testFrame = new JFrame();
    }

    @Test
    public void testSinglePlayerFromSelect() {
        GamePanel.State = GamePanel.STATE.SELECT;

        MouseEvent event = new MouseEvent(testFrame, 0, 0, 0,
                GamePanel.GAME_WIDTH / 3 + 150, 160, 1, false);

        mouseInput.mousePressed(event);

        assertEquals(GamePanel.STATE.GAME, GamePanel.State);
    }

    @Test
    public void testSelectFromMenu() {
        GamePanel.State = GamePanel.STATE.MENU;

        MouseEvent event = new MouseEvent(testFrame, 0, 0, 0,
                GamePanel.GAME_WIDTH / 3 + 150, 160, 1, false);

        mouseInput.mousePressed(event);

        assertEquals(GamePanel.STATE.SELECT, GamePanel.State);
    }

    @Test
    public void testDoubleTroubleFromSelect() {
        GamePanel.State = GamePanel.STATE.SELECT;

        MouseEvent event = new MouseEvent(testFrame, 0, 0, 0,
                GamePanel.GAME_WIDTH / 3 + 150, 260, 1, false);

        mouseInput.mousePressed(event);

        assertEquals(GamePanel.STATE.GAME2, GamePanel.State);
    }

    @Test
    public void testDuoFromSelect() {
        GamePanel.State = GamePanel.STATE.SELECT;

        MouseEvent event = new MouseEvent(testFrame, 0, 0, 0,
                GamePanel.GAME_WIDTH / 3 + 150, 360, 1, false);

        mouseInput.mousePressed(event);

        assertEquals(GamePanel.STATE.GAME3, GamePanel.State);
    }

    @Test
    public void testDoubleTrouble2FromSelect() {
        GamePanel.State = GamePanel.STATE.SELECT;

        MouseEvent event = new MouseEvent(testFrame, 0, 0, 0,
                GamePanel.GAME_WIDTH / 3 + 150, 460, 1, false);

        mouseInput.mousePressed(event);

        assertEquals(GamePanel.STATE.GAME4, GamePanel.State);
    }
}