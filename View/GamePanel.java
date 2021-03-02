package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ButtonListener;
import Model.Game;

public class GamePanel {
    
    private JFrame window;
    private JTextField targetField = new JTextField();
    private JTextField inputField = new JTextField();
    private GameCanvas canvas;
    private JButton[] letterButtons;
    private JButton newButton = new JButton("New");

    public enum GameState {
        READY, PLAYING, GAMEOVER
    }
    private GameState gameState = GameState.READY;
    
    private Game game;

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
        targetField.setFont(new Font("Courier New", Font.BOLD, 18));
        targetField.setForeground(Color.red);
        inputField.setEditable(false);
        inputField.setFont(new Font("Courier New", Font.BOLD, 18));
        inputField.setForeground(Color.black);

        container.add(BorderLayout.NORTH, northPanel);

        canvas = new GameCanvas(this);
        container.add(BorderLayout.CENTER, canvas);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(4, 7));

        ButtonListener buttonListener = new ButtonListener(this);

        letterButtons = new JButton[26];
        for (int i = 0; i < 26; i++) {
            char text = (char)('a' + i);
            letterButtons[i] = new JButton(text + "");
            southPanel.add(letterButtons[i]);
            letterButtons[i].addActionListener(buttonListener);
        }

        newButton.addActionListener(buttonListener);
        southPanel.add(newButton);

        container.add(BorderLayout.SOUTH, southPanel);

        for (var b: letterButtons) {
            b.setEnabled(false);
        }
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public JButton getNewButton() {
        return newButton;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setTarget(String target) {
        targetField.setText(target);
    }
    
    public void setInput(String input) {
        inputField.setText(input);
    }

    public JButton[] getLetterButtons() {
        return letterButtons;
    }

    public GameCanvas getCanvas() {
        return canvas;
    }

    public String getTarget() {
        return targetField.getText();
    }

    public String getInput() {
        return inputField.getText();
    }
    
    public Game getGame() {
        return game;
    }
}
