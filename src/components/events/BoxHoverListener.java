package components.events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import components.panels.GridPanel;
import game.Box;
import game.Grid;

public class BoxHoverListener extends MouseMotionAdapter {

    private GridPanel panel;

    public BoxHoverListener(GridPanel panel) {
        this.panel = panel;
    }
    
    @Override
    public void mouseMoved(MouseEvent event) {
        Grid grid = this.panel.getWindow().getGame().getGrid();
        boolean refresh = false; 

        if(grid.getHoveredBoxes().size() > 1) refresh = true; 

        grid.resetBoxes();

        Box box = grid.getBoxAt(event.getX(), event.getY());

        if(box != null) {
            grid.setHoveredConnectedBoxesFromBox(box);
            
            this.panel.repaint();
        } else if(refresh) {
            this.panel.repaint();
        }
    }
}
