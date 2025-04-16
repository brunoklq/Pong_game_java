package griffith;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;

public class MainMenu {

	public Rectangle playButton = new Rectangle(Game.GAME_WIDTH/2 + 120 ,150 ,100 ,50);
	public Rectangle playButton = new Rectangle(Game.GAME_WIDTH/2 + 120 ,150 ,100 ,50);
	public Rectangle playButton = new Rectangle(Game.GAME_WIDTH/2 + 120 ,150 ,100 ,50);
	
	public void render(Graphics g) {
		Font fnt0 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("Pong Pro Max", GamePanel.GAME_WIDTH / 3, 100);
		
	}
	
	

	
}
