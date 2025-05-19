package components.windows;

import javax.swing.JFrame;

/**
 * BaseWindow is an abstract class that defines the basic structure
 * for all windows in the SameGame application.
 * It ensures that each window meets the minimum size requirements 
 * and sets common window properties such as title, size, and close operation.
 */
abstract public class BaseWindow extends JFrame {

    /**
     * Constructs a BaseWindow and validates window dimensions 
     * from the Config class.
     */
    public BaseWindow() {
        super();

        this.setTitle("Same Game");
        this.setSize(1024, 1024);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Abstract method to add UI components to the window.
     * Must be implemented by subclasses.
     */
    abstract protected void addComponents();

    abstract public void updateSize();
}
