package components.windows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import components.buttons.ExitButton;
import components.buttons.RestartButton;
import components.events.EndWindowResizedListener;
import components.panels.BackgroundPanel;
import game.Game;

public class EndWindow extends BaseWindow {

    private Game game;
    private JLabel endLabel;
    private ExitButton exitButton;
    private RestartButton restartButton;

    public EndWindow(Game game) {
        super();
        this.game = game;
        this.addComponents();
        this.addComponentListener(new EndWindowResizedListener(this));
    }

    @Override
    protected void addComponents() {
        BackgroundPanel background = new BackgroundPanel("resources/images/background.png");
        background.setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setOpaque(false);

        this.endLabel = new JLabel("GG! You scored " + this.game.getPoints() + " points.");
        this.endLabel.setHorizontalAlignment(JLabel.CENTER);
        this.endLabel.setVerticalAlignment(JLabel.CENTER);
        centerPanel.add(this.endLabel);
        
        centerPanel.add(Box.createVerticalStrut(20));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0));
        buttonPanel.setOpaque(false);
        this.exitButton = new ExitButton();
        this.restartButton = new RestartButton(this);
        buttonPanel.add(exitButton);
        buttonPanel.add(restartButton);
        centerPanel.add(buttonPanel);

        // Center the content vertically
        background.add(centerPanel, BorderLayout.CENTER);
        
        this.setContentPane(background);
    }

    @Override
    public void updateSize() {
        int maxWidth = (int) (this.getWidth() * 0.13);
        int maxHeight = (int) (this.getHeight() * 0.1);
        int buttonSize = Math.min(maxWidth, maxHeight);

        this.exitButton.setPreferredSize(new Dimension(buttonSize, buttonSize));
        this.restartButton.setPreferredSize(new Dimension(buttonSize, buttonSize));
        this.exitButton.resizeImage(buttonSize, buttonSize);
        this.restartButton.resizeImage(buttonSize, buttonSize);

        int fontSize = Math.max(16, (int) (this.getWidth() * 0.03)); 
        this.endLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, fontSize));
    }
}
