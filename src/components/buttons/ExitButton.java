package components.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utils.Utils;

/**
 * ExitButton is a JButton used in the SameGame application to allow
 * the player to quit the game completely.
 *
 * When clicked, it triggers {@code System.exit(0)}, which closes the entire application.
 * Typically found in the end screen or menu, this button offers a quick way for the user
 * to exit the game.
 *
 * <p><b>Usage in SameGame:</b></p>
 * <pre>
 *     ExitButton exitButton = new ExitButton();
 * </pre>
 *
 * <p><b>Resources Used:</b></p>
 * <ul>
 *   <li>Button text: "Exit"</li>
 *   <li>Icon: "../resources/images/close.png"</li>
 * </ul>
 *
 * @see javax.swing.JButton
 */
public class ExitButton extends BaseButton implements ActionListener {  
  public ExitButton() {
    super(Utils.readImage("resources/images/close.png"));

    this.addActionListener(this);
  }
      
  @Override
  public void actionPerformed(ActionEvent event) {
    System.exit(0);   
  }
}
