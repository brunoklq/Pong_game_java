package griffith;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Graphics;

import org.junit.jupiter.api.Test;

class ScoreTest {
	
	 @Test
	 public void testScoreConstructor() {
	        Score score = new Score(800, 600);

	        // Check if static dimensions were set correctly
	        assertEquals(800, Score.GAME_WIDTH);
	        assertEquals(600, Score.GAME_HEIGHT);

	        // Check default player scores
	        assertEquals(0, score.player_1);
	        assertEquals(0, score.player_2);
	    }

	    @Test
	    public void testScoreValues() {
	        Score score = new Score(600, 600);

	        // Simulate scoring
	        score.player_1 = 5;
	        score.player_2 = 3;

	        assertEquals(5, score.player_1);
	        assertEquals(3, score.player_2);
	    }
}
