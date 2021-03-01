package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GameCanvas extends JPanel {
    
    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    private int health;
    private int remainingLetters;

    private GamePanel panel;

    public GameCanvas(GamePanel panel) {
        this.panel = panel;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        //setBackground(Color.white);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        GamePanel.GameState gameState = panel.getGameState();
        if (gameState == GamePanel.GameState.READY) {
            g2.setColor(Color.blue);
            g2.setFont(new Font("Courier New", Font.BOLD, 30));
            g2.drawString("Press <New> to Start", 70, 150);
        }
    }
}
