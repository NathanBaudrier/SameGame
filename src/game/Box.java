package game;

import java.awt.Image;

/**
 * The Box class represents a single item on the game grid in the SameGame application.
 * Each box has a character that defines its type, a position on the grid, a size,
 * and whether it is being hovered over.
 */
public class Box {

    private char character;
    private int x = 0; 
    private int y = 0;
    private int size = 0;
    private boolean hovered = false; 

    /**
     * Constructs a Box with the given character type.
     *
     * @param character the type of the box (e.g., 'R' for red, 'G' for green, etc.)
     */
    public Box(char character) {
        this.character = character;
    }

    /**
     * Returns the character that represents the box type.
     *
     * @return the character representing the box type
     */
    public char getCharacter() {
        return this.character;
    }

    /**
     * Updates the position and size of the box.
     *
     * @param newX the new x-coordinate of the box
     * @param newY the new y-coordinate of the box
     * @param newSize the new size of the box
     */
    public void update(int newX, int newY, int newSize) {
        this.x = newX;
        this.y = newY;
        this.size = newSize;
    }

    /**
     * Returns the x-coordinate of the box.
     *
     * @return the x-coordinate of the box
     */
    public int getX() {
        return this.x;
    }

    /**
     * Returns the y-coordinate of the box.
     *
     * @return the y-coordinate of the box
     */
    public int getY() {
        return this.y;
    }

    /**
     * Returns the size of the box.
     *
     * @return the size of the box
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Returns whether the box is currently hovered over by the mouse.
     *
     * @return true if the box is hovered, false otherwise
     */
    public boolean isHovered() {
        return this.hovered; 
    }

    /**
     * Sets the hovered state of the box.
     *
     * @param value the new hovered state
     * @return the new hovered state of the box
     */
    public boolean setHovered(boolean value) {
        return this.hovered = value;
    }

    /**
     * Returns the image representation of the box based on its character.
     *
     * @return the image representing the box, or null if no match is found
     */
    public Image getImage() {
        switch (this.character) {
            case Grid.RED:
                return Grid.RED_IMAGE;

            case Grid.GREEN:
                return Grid.GREEN_IMAGE;

            case Grid.BLUE:
                return Grid.BLUE_IMAGE;

            default:
                return null;
        }
    }

    /**
     * Checks if the given x and y coordinates are inside the bounds of the box.
     *
     * @param x the x-coordinate to check
     * @param y the y-coordinate to check
     * @return true if the given coordinates are inside the box, false otherwise
     */
    public boolean isInside(int x, int y) {
        return x >= this.x && x <= this.x + this.size && y >= this.y && y <= this.y + this.size;
    }
}
