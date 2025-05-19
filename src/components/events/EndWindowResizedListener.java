package components.events;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import components.windows.EndWindow;

public class EndWindowResizedListener extends ComponentAdapter {

    EndWindow window;
    
    public EndWindowResizedListener(EndWindow window) {
        this.window = window;
    }

    @Override
    public void componentResized(ComponentEvent event) {
        this.window.updateSize();
    }
}
