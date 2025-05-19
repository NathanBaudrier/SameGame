package components.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import components.windows.GridWindow;
import components.windows.MenuWindow;

import game.Game;
import game.Grid;
import utils.Utils;

/**
 * Represents the "Random Grid" button in the SameGame main menu.
 *
 * This button allows the user to start a new SameGame session with a randomly generated grid.
 * When clicked, it:
 * <ul>
 *   <li>Generates a 10x15 grid filled with random colored blocks (R, G, B)</li>
 *   <li>Initializes the game logic using this grid</li>
 *   <li>Closes the main menu window</li>
 *   <li>Opens the game window where the player can interact with the grid</li>
 * </ul>
 *
 * This is one of the two entry points for starting a game, the other being {@link ChooseButton},
 * which allows importing a grid from a text file.
 *
 * @author Lakshman
 */
public class RandomButton extends BaseButton implements ActionListener {
  
  /** Reference to the MenuWindow so it can be disposed when launching the game */
  private MenuWindow window;

 /**
  * Creates a button that starts the SameGame with a random grid.
  *
  * @param window the MenuWindow that contains this button
  */
  public RandomButton(MenuWindow window) {
    super(Utils.readImage("resources/images/dice.png"));

    this.window = window;

    this.addActionListener(this);
  }
      
  /**
  * Triggered when the button is clicked.
  * Starts a new game with a randomly generated grid and opens the game window.
  *
  * @param event the click event
  */
  @Override
  public void actionPerformed(ActionEvent event) {      
    Grid grid = new Grid();
    Game game = new Game(grid);
        
    this.window.dispose(); 
    new GridWindow(game).setVisible(true);
  }
}
