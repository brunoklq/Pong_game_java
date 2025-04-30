package griffith;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import javax.swing.*;



public class PongGame extends MouseInput {

	public static JFrame frame;
	public static GamePanel gamePanel;
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            frame = new JFrame("Pong");

            try {
                gamePanel = new GamePanel(); 
                frame.add(gamePanel);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);

        
            new Thread(() -> {
                while (true) {
                    if (GamePanel.State == GamePanel.STATE.GAME2) {
                        try {
                            GamePanel2 gamePanel2 = new GamePanel2();
                            SwingUtilities.invokeLater(() -> {
                                frame.getContentPane().removeAll();
                                frame.add(gamePanel2);
                                frame.revalidate();
                                frame.repaint();
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break; 
                    }

                    try {
                        Thread.sleep(100); 
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });
    }
}