package components.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import components.windows.EndWindow;
import components.windows.MenuWindow;
import utils.Utils;

/**
 * RestartButton is a JButton used in the SameGame application to allow
 * the player to restart the game by returning to the main menu.
 *
 * When clicked, this button disposes the current game window (instance of {@link BaseWindow})
 * and opens a fresh {@link MenuWindow}, effectively resetting the game state.
 *
 * This button is typically displayed on the end game screen or pause menu.
 *
 * <p><b>Usage in SameGame:</b></p>
 * <pre>
 *     // Inside a window like EndWindow
 *     RestartButton restartButton = new RestartButton(this);
 * </pre>
 *
 * <p><b>Resources Used:</b></p>
 * <ul>
 *   <li>Button text: "Restart"</li>
 *   <li>Icon: "../resources/images/restart.png"</li>
 * </ul>
 *
 * @see components.windows.MenuWindow
 * @see components.windows.EndWindow
 */
public class RestartButton extends BaseButton implements ActionListener {
  private EndWindow window;

  public RestartButton(EndWindow window) {
    super(Utils.readImage("resources/images/restart.png"));
    
    this.window = window; 
     
    this.addActionListener(this);
  }
      
  @Override   
  public void actionPerformed(ActionEvent event) {        
    this.window.dispose();   
    new MenuWindow().setVisible(true);
  }
}
