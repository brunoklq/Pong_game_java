package griffith;

import java.awt.*;

public class Score {
	
	
	static int GAME_WIDTH;
	static int GAME_HEIGHT;
	int player_1;
	int player_2;
	
	Score(int GAME_WIDTH, int GAME_HEIGHT){
		
		Score.GAME_HEIGHT = GAME_HEIGHT;
		Score.GAME_WIDTH = GAME_WIDTH;
		
	}
	
	public void draw(Graphics g) {
		
		g.setColor(Color.white);
		g.setFont(new Font("Consolas", Font.PLAIN, 60));
		g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);
		g.drawString(String.valueOf(player_1/10)+String.valueOf(player_1%10), (GAME_WIDTH/2)-85, 50);
		g.drawString(String.valueOf(player_2/10)+String.valueOf(player_2%10), (GAME_WIDTH/2)+20, 50);
	}
}
