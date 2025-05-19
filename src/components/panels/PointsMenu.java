package components.panels;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

import components.windows.GridWindow;

public class PointsMenu extends JMenuBar {

    private GridWindow window;
    
    private JLabel pointsLabel;
    
    public PointsMenu(GridWindow window) {
        super();

        this.window = window;

        this.pointsLabel = new JLabel();
        this.pointsLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, this.getHeight() * 3 / 4)); 

        this.updateDisplayPoints();

        this.add(Box.createHorizontalGlue());
        this.add(this.pointsLabel);
        this.add(Box.createHorizontalGlue());

        this.updateSize();
    }

    public void updateDisplayPoints() {
        this.pointsLabel.setText("Points: " + String.valueOf(this.window.getGame().getPoints()));
    }

    public void updateSize() {
        this.setSize(new Dimension(this.window.getWidth(), (int) (this.window.getHeight() * 0.05)));
        this.pointsLabel.setFont(this.pointsLabel.getFont().deriveFont((float) (this.getHeight() * 3 / 4)));
    }
}
