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

	public Rectangle singleButton = new Rectangle(GamePanel.GAME_WIDTH / 3 + 120 ,150 ,128 ,50);
	public Rectangle dtButton = new Rectangle(GamePanel.GAME_WIDTH / 3 + 120 ,250 ,165 ,50);
	public Rectangle duoButton = new Rectangle(GamePanel.GAME_WIDTH / 3 + 120 ,350 ,115 ,50);
	public Rectangle dt2Button = new Rectangle(GamePanel.GAME_WIDTH / 3 + 120 ,450 ,115 ,50);
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT);
		
		Font fnt0 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("Select Game Mode", GamePanel.GAME_WIDTH / 4+30 , 100);
		
		Font fnt1 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt1);
		g.drawString("Single", singleButton.x + 20, singleButton.y +30);
		g2d.draw(singleButton);
		
		g.drawString("Double Trouble", dtButton.x + 20, dtButton.y +30);
		g2d.draw(dtButton);
		g.drawString("Duo", duoButton.x + 20, duoButton.y +30);
		g2d.draw(duoButton);
		g.drawString("Duoble Trouble 2", dt2Button.x + 20, dt2Button.y +30);
		g2d.draw(dt2Button);
		
		
		
		
		
}
}