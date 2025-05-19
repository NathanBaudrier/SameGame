package components.events;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import components.windows.MenuWindow;

public class MenuWindowResizedListener extends ComponentAdapter {
    
    MenuWindow window;

    public MenuWindowResizedListener(MenuWindow window) {
        this.window = window;
    }

    @Override
    public void componentResized(ComponentEvent event) {
        this.window.updateSize();
    }
}
