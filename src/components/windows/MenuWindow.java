package components.windows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import components.panels.BackgroundPanel;
import utils.Utils;
import components.buttons.ChooseButton;
import components.buttons.RandomButton;
import components.events.MenuWindowResizedListener;

/**
 * Represents the main menu window of the SameGame application.
 *
 * This window is the entry point of the application and allows the user to choose between two options:
 * <ul>
 *   <li>Start a game with a randomly generated grid using the {@link RandomButton}</li>
 *   <li>Import a grid from a .txt file using the {@link ChooseButton}</li>
 * </ul>
 * 
 * The window includes a background image, a game logo, and a footer with credits.
 * It uses a {@link BackgroundPanel} for custom background rendering and places components using a BorderLayout.
 * 
 * This class extends {@link BaseWindow}, which provides the basic window setup.
 * 
 * @author [Your Name]
 */
public class MenuWindow extends BaseWindow {

    private JLabel logoLabel;
    private JLabel creditsLabel;
    private RandomButton randomButton;
    private ChooseButton chooseButton;

    /**
     * Constructs the menu window and adds all visual components.
     */
    public MenuWindow() {
        super();

        this.addComponents();
        this.addComponentListener(new MenuWindowResizedListener(this));
    }

    /**
     * Adds visual components to the window:
     * <ul>
     *   <li>Background image</li>
     *   <li>Centered game logo</li>
     *   <li>Top credit/creator image</li>
     *   <li>Two buttons at the bottom: Random and Import</li>
     * </ul>
     */
    @Override
    protected void addComponents() {
        this.setLayout(new BorderLayout());
        
        BackgroundPanel background = new BackgroundPanel("resources/images/background.png");

        JLabel logoLabel = new JLabel();
        logoLabel.setHorizontalAlignment(JLabel.CENTER); 

        background.setLayout(new BorderLayout());    
        background.add(logoLabel, BorderLayout.CENTER);

        this.logoLabel = logoLabel;

        JLabel creditsJLabel = new JLabel();
        creditsJLabel.setHorizontalAlignment(JLabel.CENTER);
        background.add(creditsJLabel, BorderLayout.NORTH);

        this.creditsLabel = creditsJLabel;

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50));
        buttonPanel.add(this.randomButton = new RandomButton(this));
        buttonPanel.add(this.chooseButton = new ChooseButton(this));

        background.add(buttonPanel, BorderLayout.SOUTH); 

        this.updateSize();

        this.setContentPane(background);
    }

    @Override
    public void updateSize() {
        double imageRatio = 612.0 / 408.0; 
        double maxWidthRatio = 0.6;
        double maxHeightRatio = 0.7;
    
        int maxWidth = (int) (this.getWidth() * maxWidthRatio);
        int maxHeight = (int) (maxWidth / imageRatio);
    
        int heightLimit = (int) (getHeight() * maxHeightRatio);
        if (maxHeight > heightLimit) {
            maxHeight = heightLimit;
            maxWidth = (int) (maxHeight * imageRatio);
        }

        Image logo = Utils.readImage("resources/images/logo.png").getScaledInstance(maxWidth, maxHeight, Image.SCALE_SMOOTH);
        this.logoLabel.setIcon(new ImageIcon(logo));

        imageRatio = 1024.0 / 145.0; 
        maxWidthRatio = 0.8;
        maxHeightRatio = 0.6;
    
        maxWidth = (int) (this.getWidth() * maxWidthRatio);
        maxHeight = (int) (maxWidth / imageRatio);
    
        heightLimit = (int) (getHeight() * maxHeightRatio);
        if (maxHeight > heightLimit) {
            maxHeight = heightLimit;
            maxWidth = (int) (maxHeight * imageRatio);
        }

        Image credits = Utils.readImage("resources/images/credits.png").getScaledInstance(maxWidth, maxHeight, Image.SCALE_SMOOTH);
        this.creditsLabel.setIcon(new ImageIcon(credits));

        maxWidth = (int) (this.getWidth() * 0.1);
        maxHeight = (int) (this.getHeight() * 0.08);

        int buttonSize = Math.min(maxWidth, maxHeight);

        this.randomButton.setPreferredSize(new Dimension(buttonSize, buttonSize));
        this.chooseButton.setPreferredSize(new Dimension(buttonSize, buttonSize));
        this.randomButton.resizeImage(buttonSize, buttonSize);
        this.chooseButton.resizeImage(buttonSize, buttonSize);
    }
}