package griffith;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;

public class MainMenu {

	public void render(Graphics g) {
		Font fnt0 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("Pong Pro Max", GamePanel.GAME_WIDTH / 3, 100);
		
	}
	
	

	
}
