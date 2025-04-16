package griffith;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		//public Rectangle playButton = new Rectangle(GamePanel.GAME_WIDTH / 3 + 120 ,150 ,100 ,50);
		//public Rectangle helpButton = new Rectangle(GamePanel.GAME_WIDTH / 3 + 120 ,250 ,100 ,50);
	    //public Rectangle quitButton = new Rectangle(GamePanel.GAME_WIDTH / 3 + 120 ,350 ,100 ,50);
		
		//Play Button
		if(mx >= GamePanel.GAME_WIDTH / 3 + 120 && mx <= GamePanel.GAME_WIDTH / 3 + 220) 
		{
			if(my >= 150 && my <= 200) 
			{
				GamePanel.State = GamePanel.STATE.GAME;
			}
		}
	}

	public void mousePressed(MouseEvent e) 
	{
		int mx = e.getX();
		int my = e.getY();
		
		//public Rectangle playButton = new Rectangle(GamePanel.GAME_WIDTH / 3 + 120 ,150 ,100 ,50);
		//public Rectangle helpButton = new Rectangle(GamePanel.GAME_WIDTH / 3 + 120 ,250 ,100 ,50);
	    //public Rectangle quitButton = new Rectangle(GamePanel.GAME_WIDTH / 3 + 120 ,350 ,100 ,50);
		
		//Play Button
		if(mx >= GamePanel.GAME_WIDTH / 3 + 120 && mx <= GamePanel.GAME_WIDTH / 3 + 220) 
		{
			if(my >= 150 && my <= 200) 
			{
				GamePanel.State = GamePanel.STATE.GAME;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
