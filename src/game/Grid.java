package game;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import exceptions.grid.GridException;
import exceptions.grid.InvalidGridCharacterException;
import exceptions.grid.MissingGridCharactersException;
import exceptions.grid.MissingGridLinesException;

import utils.Index;
import utils.Utils;

/**
 * Represents a grid made of colored characters (R, V, B) for the SameGame.
 * 
 * A grid can be generated randomly or loaded from a text file. It is structured
 * as a 2D character array with fixed dimensions: 10 lines and 15 columns.
 * 
 * The grid supports validation and throws custom exceptions if the file
 * is invalid (missing lines, missing characters, invalid characters).
 * 
 * Each character in the grid represents a color:
 * - R: Red
 * - V: Green ('Vert' in French)
 * - B: Blue
 * 
 * Usage:
 * <pre>
 *     Grid randomGrid = new Grid();
 *     Grid loadedGrid = new Grid("path/to/file.txt");
 * </pre>
 * 
 * @author Nathan
 */
public class Grid {

    /** Constant of the representation of the color red in the grid */
    public static final char RED = 'R';
    /** Constant of the representation of the color green in the grid */
    public static final char GREEN = 'V';
    /** Constant of the representation of the color blue in the grid */
    public static final char BLUE = 'B'; 

    /** The image representing the color red in the grid */
    public static final Image RED_IMAGE = Utils.readImage("resources/images/items/red-item.png");
    /** The image representing the color green in the grid */
    public static final Image GREEN_IMAGE = Utils.readImage("resources/images/items/green-item.png");
    /** The image representing the color blue in the grid */
    public static final Image BLUE_IMAGE = Utils.readImage("resources/images/items/blue-item.png");

    /** The maximum number of lines in a grid */
    public static final int MAX_LINES = 10;
    /** The maximum number of characters in a grid */
    public static final int MAX_COLUMNS = 15;
    
    /** Array representing the data of a grid */
    private Box[][] boxes = new Box[MAX_LINES][MAX_COLUMNS];

    /**
     * Constructs a grid filled with random color characters (R, V, B).
     */
    public Grid() {
        char[] colors = {RED, GREEN, BLUE}; 

        for (int i = 0; i < MAX_LINES; i++) {
            for (int j = 0; j < MAX_COLUMNS; j++) {
                this.boxes[i][j] = new Box(colors[(new Random()).nextInt(colors.length)]);
            }
        }
    }

    /**
     * Constructs a grid from a file containing exactly 10 lines of 15 characters.
     * Each character must be R, V, or B (case-insensitive).
     * 
     * @param filePath the path to the file containing grid data
     * @throws GridException if the file content is invalid:
     *         - missing lines
     *         - missing characters
     *         - invalid characters
     */
    public Grid(String filePath) throws GridException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            
            String line;
            int currentLine = 0;

            while ((line = reader.readLine()) != null) {
                currentLine++;

                if (currentLine > MAX_LINES) break;

                if (line.length() < MAX_COLUMNS) {
                    Utils.closeReader(reader);
                    throw new MissingGridCharactersException(currentLine);
                }

                for (int i = 0; i < MAX_COLUMNS; i++) {
                    char character = Character.toUpperCase(line.charAt(i));

                    if (character != RED && character != GREEN && character != BLUE) {
                        Utils.closeReader(reader);
                        throw new InvalidGridCharacterException(currentLine, i + 1);
                    }

                    this.boxes[currentLine - 1][i] = new Box(character);
                }
            }

            if (currentLine < MAX_LINES) {
                Utils.closeReader(reader);
                throw new MissingGridLinesException(Integer.toUnsignedLong(currentLine));
            }

            Utils.closeReader(reader);
        } catch (FileNotFoundException e) {
            System.err.println(filePath + " is invalid or not found:\n" + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error while trying to read the file:\n" + e.getMessage());
        }
    }

    /**
     * Updates the grid by applying gravity to all the boxes and shifting columns left if empty.
     */
    public void update() {
        for (int j = 0; j < MAX_COLUMNS; j++) {
            int currentLine = MAX_LINES - 1;
    
            for (int i = MAX_LINES - 1; i >= 0; i--) {
                if (boxes[i][j] != null) {
                    boxes[currentLine][j] = boxes[i][j];
                    if (currentLine != i) {
                        boxes[i][j] = null;
                    }
                    currentLine--;
                }
            }
        }
    
        int currentColumn = 0;
    
        for (int j = 0; j < MAX_COLUMNS; j++) {
            if (!isColumnEmpty(j)) {
                for (int i = 0; i < MAX_LINES; i++) {
                    boxes[i][currentColumn] = boxes[i][j];
                    if (currentColumn != j) {
                        boxes[i][j] = null;
                    }
                }
                currentColumn++;
            }
        }
    }    

    /**
     * Checks if a column is empty.
     * 
     * @param column the column index to check
     * @return true if the column is empty, false otherwise
     */
    private boolean isColumnEmpty(int column) {
        for(int i = 0; i < MAX_LINES; i++) {
            if(this.boxes[i][column] != null) return false;
        }

        return true;
    }

    /**
     * Returns the data of the grid as a 2D Box array.
     * 
     * @return a 10x15 array representing the grid content
     */
    public Box[][] getBoxes() {
        return this.boxes;
    }

    /**
     * Updates the position and size of the boxes in the grid.
     * 
     * @param startX the x-coordinate where the boxes should start being placed
     * @param startY the y-coordinate where the boxes should start being placed
     * @param size the size of the boxes
     */
    public void updateBoxes(int startX, int startY, int size) {
        for(int i = 0; i < MAX_LINES; i++) {
            for(int j = 0; j < MAX_COLUMNS; j++) {
                Box box = this.boxes[i][j];

                if(box != null) {
                    int x = startX + j * size;
                    int y = startY + i * size;

                    box.update(x, y, size);
                }
            }
        }
    }

    /**
     * Retrieves the Box at the specified coordinates.
     * 
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     * @return the Box at the given coordinates, or null if there is no Box there
     */
    public Box getBoxAt(int x, int y) {
        for(int i = 0; i < MAX_LINES; i++) {
            for(int j = 0; j < MAX_COLUMNS; j++) {
                Box box = this.boxes[i][j];
                if(box != null && box.isInside(x, y)) return this.boxes[i][j];
            }
        }

        return null;
    }

    /**
     * Retrieves the grid coordinates (index) of the given Box.
     * 
     * @param box the Box to find the coordinates of
     * @return the Index object representing the grid coordinates of the Box
     */
    public Index getBoxIndex(Box box) {
        for(int i = 0; i < MAX_LINES; i ++) {
            for(int j = 0; j < MAX_COLUMNS; j++) {
                if(this.boxes[i][j] == box) {
                    return new Index(i, j);
                }
            }
        }

        return null;
    }

    /**
     * Resets all the boxes by removing their hover state.
     */
    public void resetBoxes() {
        for(Box[] line : this.boxes) {
            for(Box box : line) {
                if(box != null && box.isHovered()) {
                    box.setHovered(false);
                }
            }
        }
    }

    public void setHoveredConnectedBoxesFromBox(Box box) {
        this.setHoveredConnectedBoxes(box, box);
    }

    /**
     * Marks the connected boxes of the targetBox as hovered.
     * 
     * @param targetBox the box from which connected boxes will be marked
     * @param box the current box being processed
     */
    private void setHoveredConnectedBoxes(Box targetBox, Box box) {
        if(box == null || box.getCharacter() != targetBox.getCharacter() || box.isHovered()) return; 

        box.setHovered(true);

        Index index = this.getBoxIndex(box);
        int i = index.getI();
        int j = index.getJ();

        if(i + 1 < MAX_LINES) {
            this.setHoveredConnectedBoxes(targetBox, this.boxes[i + 1][j]);
        }

        if(i - 1 >= 0) {
            this.setHoveredConnectedBoxes(targetBox, this.boxes[i - 1][j]);
        }

        if(j + 1 < MAX_COLUMNS) {
            this.setHoveredConnectedBoxes(targetBox, this.boxes[i][j + 1]);
        }

        if(j - 1 >= 0) {
            this.setHoveredConnectedBoxes(targetBox, this.boxes[i][j - 1]);
        }
    }

    /**
     * Retrieves a list of all the hovered boxes.
     * 
     * @return a list of hovered boxes
     */
    public List<Box> getHoveredBoxes() {
        List<Box> hoveredBoxes = new ArrayList<Box>();

        for(Box[] line : this.boxes) {
            for(Box box : line) {
                if(box != null && box.isHovered()) hoveredBoxes.add(box);
            }
        }

        return hoveredBoxes;
    }

    /**
     * Removes the specified box from the grid.
     * 
     * @param box the Box to remove
     */
    public void removeBox(Box box) {
        for(int i = 0; i < MAX_LINES; i++) {
            for(int j = 0; j < MAX_COLUMNS; j++) {
                if(this.boxes[i][j] == box) this.boxes[i][j] = null; 
            }
        }
    }

    public boolean hasNoMoreMoves() {
        for(Box[] line : this.boxes) {
            for(Box box : line) {
    
                if(box != null) {
                    this.setHoveredConnectedBoxes(box, box);
    
                    boolean hasMatch = this.getHoveredBoxes().size() > 1;

                    this.resetBoxes();
    
                    if(hasMatch) return false;
                }
            }
        }
    
        return true;
    }    

    /**
     * Returns a string representation of the grid.
     * 
     * @return a string representing the grid content
     */
    @Override
    public String toString() {
        String content = "";

        for(int i = 0; i < MAX_LINES; i++) {
            for(int j = 0; j < MAX_COLUMNS; j++) {
                content += this.boxes[i][j].getCharacter();
            }

            content += "\n";
        }

        return content;
    }
}
