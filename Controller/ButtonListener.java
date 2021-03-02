package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Model.Game;
import View.GamePanel;

public class ButtonListener implements ActionListener{
    
    private GamePanel panel;

    public ButtonListener(GamePanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == panel.getNewButton()) {
            var game = new Game();
            panel.setGame(game);
            panel.setGameState(GamePanel.GameState.PLAYING);
            panel.setTarget(game.getTarget());
            panel.setInput(game.getInput());
            for (var b: panel.getLetterButtons()) {
                b.setEnabled(true);
            }
            //canvas set health
            panel.getCanvas().repaint();
        } else {

            button.setEnabled(false);

            Game game = panel.getGame();

            String target = game.getTarget();
            String input = game.getInput();
            String letter = button.getText();
            boolean found = false;

            for (int i = 0; i < target.length(); i++) {
                if (target.substring(i, i + 1).equals(letter)) {
                    found = true;
                    game.reduceRemainingLetters();
                    //System.out.println(game.getRemainingLetters());
                    String temp_before = "";
                    if (i > 0) temp_before = input.substring(0, i);
                    String temp_after = "";
                    if (i < target.length() - 1) temp_after = input.substring(i + 1, target.length());
                    input = temp_before + letter + temp_after;
                    game.setInput(input);
                    panel.setInput(input);
                }
            }

            if (!found) game.reduceHealth();

            if (game.getHealth() == 0 || game.getRemainingLetters() == 0) {
                panel.setGameState(GamePanel.GameState.GAMEOVER);
                for (var b: panel.getLetterButtons()) {
                    b.setEnabled(false);
                }
            }

            panel.getCanvas().repaint();
        }
    }
}
