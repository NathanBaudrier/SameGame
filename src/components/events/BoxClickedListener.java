package components.events;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import components.panels.GridPanel;
import components.windows.EndWindow;
import game.Box;
import game.Game;
import game.Grid;

public class BoxClickedListener extends MouseAdapter {

    private GridPanel panel;

    public BoxClickedListener(GridPanel panel) {
        this.panel = panel;
    }
    
    @Override
    public void mouseClicked(MouseEvent event) {
        Game game = this.panel.getWindow().getGame();
        Grid grid = game.getGrid();
        Box box = grid.getBoxAt(event.getX(), event.getY());

        if(box != null && grid.getHoveredBoxes().size() > 1) {
            game.addPoints((int) Math.pow((double) grid.getHoveredBoxes().size() - 2, (double) 2));

            for(Box hoveredBox : grid.getHoveredBoxes()) {
                grid.removeBox(hoveredBox);
            }

            grid.update();

            this.panel.repaint();

            if(grid.hasNoMoreMoves()) {
                this.panel.getWindow().dispose();

                EndWindow window = new EndWindow(game);
                window.setVisible(true);
            }
        }
    }
}
