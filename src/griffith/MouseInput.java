package griffith;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {}

	public void mousePressed(MouseEvent e) 
	{
		int mx = e.getX();
		int my = e.getY();
		
		//public Rectangle playButton = new Rectangle(GamePanel.GAME_WIDTH / 3 + 120 ,150 ,100 ,50);
		//public Rectangle helpButton = new Rectangle(GamePanel.GAME_WIDTH / 3 + 120 ,250 ,100 ,50);
	    //public Rectangle quitButton = new Rectangle(GamePanel.GAME_WIDTH / 3 + 120 ,350 ,100 ,50);
		
		//Play one player Button
		if(mx >= GamePanel.GAME_WIDTH / 3 + 120 && mx <= GamePanel.GAME_WIDTH / 3 + 220) 
		{
			if(my >= 150 && my <= 200) 
			{
				GamePanel.State = GamePanel.STATE.GAME;
				System.out.println("Game started!");
			}
		}
		
		//Help Button
		if(mx >= GamePanel.GAME_WIDTH / 3 + 120 && mx <= GamePanel.GAME_WIDTH / 3 + 220) 
		{
			if(my >= 250 && my <= 300) 
			{
				//System.out.println("Help needs to be written");
			}
		}
				
		//Quit Button
		if(mx >= GamePanel.GAME_WIDTH / 3 + 120 && mx <= GamePanel.GAME_WIDTH / 3 + 220) 
		{
			if(my >= 350 && my <= 400) 
			{
				GamePanel.State = GamePanel.STATE.GAME;
				System.out.println("Goodbye!!");
				System.exit(1);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}
