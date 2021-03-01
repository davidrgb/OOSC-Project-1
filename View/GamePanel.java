package View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GamePanel {
    
    private JFrame window;
    private JTextField targetField = new JTextField();
    private JTextField inputField = new JTextField();
    //canvas
    private JButton[] letterButtons;
    private JButton newButton = new JButton("New");

    public enum GameState {
        READY, PLAYING, GAMEOVER
    }
    private GameState gameState = GameState.READY;
    
    //game

    public GamePanel(JFrame window) {
        this.window = window;
    }

    public void init() {
        Container container = window.getContentPane();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2, 1));
        northPanel.add(targetField);
        northPanel.add(inputField);
        targetField.setEditable(false);
        inputField.setEditable(false);

        container.add(BorderLayout.NORTH, northPanel);

        //canvas

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(4, 7));

        //button listener

        letterButtons = new JButton[26];
        for (int i = 0; i < 26; i++) {
            char text = (char)('a' + i);
            letterButtons[i] = new JButton(text + "");
            southPanel.add(letterButtons[i]);
            //add action listener
        }

        //add new button listener
        southPanel.add(newButton);

        container.add(BorderLayout.SOUTH, southPanel);

        for (var b: letterButtons) {
            b.setEnabled(false);
        }
    }
}
