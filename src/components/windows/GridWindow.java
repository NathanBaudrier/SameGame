package components.windows;

import java.awt.BorderLayout;

import components.events.GridWindowResizedListener;
import components.panels.GridPanel;
import components.panels.PointsMenu;

import game.Game;

/**
 * GridWindow is the main game window in the SameGame application.
 * It displays the game board (GridPanel) and the player's points (PointsPanel).
 */
public class GridWindow extends BaseWindow {

    private Game game;

    private GridPanel gridPanel;
    private PointsMenu pointsMenu; 

    /**
     * Constructs a new GridWindow with the given Game instance.
     *
     * @param game the current game logic object
     */
    public GridWindow(Game game) {
        super();

        this.game = game;

        this.addComponents();
    }

    /**
     * Adds the components to the GridWindow, including:
     * - PointsPanel at the top to display score
     * - GridPanel in the center to display the game board
     */
    @Override
    protected void addComponents() {
        this.add(this.pointsMenu = new PointsMenu(this), BorderLayout.NORTH);
        this.add(this.gridPanel = new GridPanel(this), BorderLayout.CENTER);

        this.addComponentListener(new GridWindowResizedListener(this));
    }

    @Override
    public void updateSize() {};

    public Game getGame() {
        return this.game;
    }

    public GridPanel getGridPanel() {
        return this.gridPanel;
    }

    public PointsMenu getPointsMenu() {
        return this.pointsMenu;
    }
}
