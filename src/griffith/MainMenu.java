package griffith;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenu {
	
	

	public Rectangle playButton = new Rectangle(GamePanel.GAME_WIDTH / 3 + 120 ,150 ,100 ,50);
	public Rectangle helpButton = new Rectangle(GamePanel.GAME_WIDTH / 3 + 120 ,250 ,100 ,50);
	public Rectangle quitButton = new Rectangle(GamePanel.GAME_WIDTH / 3 + 120 ,350 ,100 ,50);
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT);
		
		Font fnt0 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("Pongo!", GamePanel.GAME_WIDTH / 3 + 85 , 100);
		
		Font fnt1 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt1);
		g.drawString("Play", playButton.x + 20, playButton.y +30);
		g2d.draw(playButton);
		
		g.drawString("Help", helpButton.x + 20, helpButton.y +30);
		g2d.draw(helpButton);
		g.drawString("Quit", quitButton.x + 20, quitButton.y +30);
		g2d.draw(quitButton);
	}
	
	

	
}
