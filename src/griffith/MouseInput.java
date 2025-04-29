package griffith;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JFrame;

public class MouseInput implements MouseListener{


	
	
	
	
	
	public boolean v1;
	
	public boolean isV1() {
		return v1;
	}

	public void setV1(boolean v1) {
		this.v1 = v1;
	}

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
				
				PongGame.useFirstGame = true;
				GamePanel.State = GamePanel.STATE.GAME;
				
				
			
				System.out.println("Game started! P1");
			}
		}
		
		//Help Button
		if(mx >= GamePanel.GAME_WIDTH / 3 + 120 && mx <= GamePanel.GAME_WIDTH / 3 + 220) 
		{
			if(my >= 250 && my <= 300) 
			{
				PongGame.useFirstGame = false;
				GamePanel2.State = GamePanel2.STATE.GAME;
			
			
				System.out.println("Game started! P2");
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


