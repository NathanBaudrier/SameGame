package components.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import components.windows.GridWindow;
import components.windows.MenuWindow;

import exceptions.grid.GridException;

import game.Game;
import game.Grid;
import utils.Utils;

/**
 * Represents the "Import File" button in the SameGame main menu.
 *
 * This button allows the user to start a new SameGame session using a custom grid loaded from a .txt file.
 * When clicked, it:
 * <ul>
 *   <li>Opens a file chooser to select a .txt file</li>
 *   <li>Validates and loads the grid from the selected file</li>
 *   <li>Initializes the game logic using this grid</li>
 *   <li>Closes the main menu window</li>
 *   <li>Opens the game window where the player can interact with the grid</li>
 * </ul>
 * The file must respect the expected grid format (10 lines × 15 characters, only R, V, or B).
 * If not, a {@link GridException} will be thrown.
 *
 * This is one of the two entry points for starting a game, the other being {@link RandomButton}.
 * 
 * @author Lakshman
 */
 public class ChooseButton extends BaseButton implements ActionListener {

  /** Reference to the MenuWindow so it can be disposed when launching the game */
  private MenuWindow window;
   
  /**
   * Creates a button that allows the user to choose a grid file to import.
   *
   * @param window the MenuWindow that contains this button
   */
  public ChooseButton(MenuWindow window) {
    super(Utils.readImage("resources/images/import.png"));

    this.window = window;
    
    this.addActionListener(this);
  }
  
   /**
    * Triggered when the button is clicked.
    * Opens a file chooser, loads the selected grid file, and launches the game if valid.
    *
    * @param event the click event
    */
  @Override
  public void actionPerformed(ActionEvent event) {
    JFileChooser chooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files (.txt)", "txt");
    
    chooser.setFileFilter(filter);
    chooser.setCurrentDirectory(new File("resources/grids/tutorial/"));

    int result = chooser.showOpenDialog(null);
    
    if (result == JFileChooser.APPROVE_OPTION) {
      File selectedFile = chooser.getSelectedFile();
      try {
        Grid grid = new Grid(selectedFile.getAbsolutePath());
        Game game = new Game(grid);
        GridWindow gridWindow = new GridWindow(game);
        
        this.window.dispose();
        gridWindow.setVisible(true);
      } catch (GridException  e) {
        System.err.println("Erreur while trying to create a new Grid instance:\n" + e.getMessage());
      }
    }
  }
}
