package components.buttons;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BaseButton extends JButton {

    private Image image;
    
    public BaseButton(Image image) {
        this.image = image;

        this.setIcon(new ImageIcon(image));

        this.setOpaque(false);
        this.setContentAreaFilled(false); 
        this.setBorderPainted(false);
    }

    public void resizeImage(int newWidth, int newHeiht) {
        this.setIcon(new ImageIcon(this.image.getScaledInstance(newWidth, newWidth, Image.SCALE_SMOOTH)));
    }
}
