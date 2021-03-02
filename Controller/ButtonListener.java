package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Model.Game;
import View.GamePanel;

public class ButtonListener implements ActionListener{
    
    private GamePanel panel;
    private int clicks = 0;

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
            panel.setInput("");
            for (var b: panel.getLetterButtons()) {
                b.setEnabled(true);
            }
            //canvas set health
            panel.getCanvas().repaint();
        }
    }
}
