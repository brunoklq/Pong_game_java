package griffith;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class PongGame extends MouseInput {

    public static JFrame frame;
    public static GamePanel gamePanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            frame = new JFrame("Pong");

            try {
                gamePanel = new GamePanel(); // Initialize the first game panel
                frame.add(gamePanel);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);

            // Start a thread to watch for state change and transition to GamePanel2
            new Thread(() -> {
                while (true) {
                    if (GamePanel.State == GamePanel.STATE.GAME2) {
                        try {
                            GamePanel2 gamePanel2 = new GamePanel2(); // Initialize the second game panel
                            SwingUtilities.invokeLater(() -> {
                                frame.getContentPane().removeAll(); // Remove the current game panel
                                frame.add(gamePanel2); // Add the new game panel
                                frame.revalidate();
                                frame.repaint();

                                // Ensure GamePanel2 gets focus for key events
                                gamePanel2.requestFocus();
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break; // Exit the loop after the transition
                    }
                    
                    if (GamePanel.State == GamePanel.STATE.GAME3) {
                        try {
                            GamePanel3 gamePanel3 = new GamePanel3();
                            SwingUtilities.invokeLater(() -> {
                                frame.getContentPane().removeAll();
                                frame.add(gamePanel3);
                                frame.revalidate();
                                frame.repaint();
                                gamePanel3.requestFocus();
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    
                    if (GamePanel.State == GamePanel.STATE.GAME4) {
                        try {
                            GamePanel4 gamePanel4 = new GamePanel4();
                            SwingUtilities.invokeLater(() -> {
                                frame.getContentPane().removeAll();
                                frame.add(gamePanel4);
                                frame.revalidate();
                                frame.repaint();
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    }

                    try {
                        Thread.sleep(100); // Check periodically
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });
    }
}