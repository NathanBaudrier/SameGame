package components.panels;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import utils.Utils;

public class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        this.backgroundImage = Utils.readImage(imagePath);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
