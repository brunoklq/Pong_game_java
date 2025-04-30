package griffith;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoundTest {

    private Sound sound;

    @BeforeEach
    void setUp() {
        sound = new Sound();
    }

    @Test
    void testSoundUrlsAreNotNull() {
        for (int i = 0; i <= 7; i++) {
            assertNotNull(sound.soundURL[i], "sound URL at index " + i + " should not be null or ill get sad");
        }
    }

    @Test
    void testSetFileDoesNotThrow() {
        assertDoesNotThrow(() -> sound.setFile(0), "setting a valid sound file should not throw or ill get even more sad");
    }
}
