import javax.swing.JFrame;

import View.GamePanel;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(400, 100);
        window.setTitle("Project 1: Word Guess Game");

        var gamePanel = new GamePanel(window);
        gamePanel.init();

        window.pack();
        window.setVisible(true);
    }
}