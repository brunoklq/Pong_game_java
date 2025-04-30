package griffith;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlaySelect {

	public Rectangle coopButton = new Rectangle(GamePanel.GAME_WIDTH / 3 + 120 ,150 ,100 ,50);
	public Rectangle cpuButton = new Rectangle(GamePanel.GAME_WIDTH / 3 + 120 ,250 ,100 ,50);
	public Rectangle complexButton = new Rectangle(GamePanel.GAME_WIDTH / 3 + 120 ,350 ,100 ,50);
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT);
		
		Font fnt0 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("Select Game Mode", GamePanel.GAME_WIDTH / 3 + 85 , 100);
		
		Font fnt1 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt1);
		g.drawString("Coop", coopButton.x + 20, coopButton.y +30);
		g2d.draw(coopButton);
		
		g.drawString("Single", cpuButton.x + 20, cpuButton.y +30);
		g2d.draw(cpuButton);
		g.drawString("Complex", complexButton.x + 20, complexButton.y +30);
		g2d.draw(complexButton);
		
}
}