package griffith;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JFrame;

public class MouseInput implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {}

	public void mousePressed(MouseEvent e) 
	{
		int mx = e.getX();
		int my = e.getY();
		
		
		//Select what to play
		if(mx >= GamePanel.GAME_WIDTH / 3 + 120 && mx <= GamePanel.GAME_WIDTH / 3 + 220) 
		{
			if(my >= 150 && my <= 200) 
			{
				if(GamePanel.State == GamePanel.STATE.SELECT)
				{
					GamePanel.State = GamePanel.STATE.GAME;	
					System.out.println("Single Player");
				}
				else 
				{
				GamePanel.State = GamePanel.STATE.SELECT;	
				System.out.println("Select the gamemode");
				}
			}
		}
		
		//Help Button
		if(mx >= GamePanel.GAME_WIDTH / 3 + 120 && mx <= GamePanel.GAME_WIDTH / 3 + 220) 
		{
			if(my >= 250 && my <= 300) 
			{
				if(GamePanel.State == GamePanel.STATE.SELECT)
				{
					GamePanel.State = GamePanel.STATE.GAME2;	
					System.out.println("Single Player");
				}
				else
				{
				System.out.println("Help");
				}
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


