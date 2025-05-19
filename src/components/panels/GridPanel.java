package components.panels;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import components.events.BoxClickedListener;
import components.events.BoxHoverListener;
import components.windows.GridWindow;
import game.Grid;
import game.Box;

public class GridPanel extends JPanel {
    
    private GridWindow window;

    public GridPanel(GridWindow window) {
        super();

        this.window = window;

        this.addMouseMotionListener(new BoxHoverListener(this));
        this.addMouseListener(new BoxClickedListener(this));
    } 

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.window.getPointsMenu().updateDisplayPoints();

        Grid grid = this.window.getGame().getGrid();

        int size = Math.min(this.getWidth() / Grid.MAX_COLUMNS, this.getHeight() / Grid.MAX_LINES);
        int startX = (this.getWidth() - (size * Grid.MAX_COLUMNS)) / 2;
        int startY = (this.getHeight() - (size * Grid.MAX_LINES)) / 2;

        grid.updateBoxes(startX, startY, size);

        Graphics pencil = g.create();

        for(int i = 0; i < Grid.MAX_LINES; i++) {
            for(int j = 0; j < Grid.MAX_COLUMNS; j++) {
                Box box = grid.getBoxes()[i][j];

                if(box != null) {
                    if(box.isHovered() && grid.getHoveredBoxes().size() > 1) {
                        pencil.setColor(new Color(255, 247, 174, 180));
                        pencil.drawRect(box.getX(), box.getY(), box.getSize(), box.getSize());
                        pencil.fillRect(box.getX(), box.getY(), box.getSize(), box.getSize());
                        pencil.setColor(Color.WHITE);
                    }

                    pencil.drawImage(box.getImage(), box.getX(), box.getY(), box.getSize(), box.getSize(), this);
                }
            }
        }
    }

    public GridWindow getWindow() {
        return this.window;
    }
}
