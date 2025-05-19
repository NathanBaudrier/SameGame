package components.events;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import components.windows.GridWindow;

public class GridWindowResizedListener extends ComponentAdapter {

    private GridWindow window;

    public GridWindowResizedListener(GridWindow window) {
        this.window = window;
    }

    @Override
    public void componentResized(ComponentEvent event) {        
        this.window.getPointsMenu().updateSize();
    }
}
