package utils;

import java.awt.Image;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

import javax.imageio.ImageIO;

/**
 * Utility class providing helper methods for file and image operations.
 * 
 * Includes methods to safely close readers and to load images from file paths.
 * These utilities are used throughout the SameGame project to simplify repetitive tasks.
 * 
 * Example usage:
 * <pre>
 *     Image image = Utils.readImage("resources/img.png");
 *     Utils.closeReader(reader);
 * </pre>
 * 
 * @author Nathan
 */
public class Utils {

    /**
     * Safely closes a Reader instance.
     * If an IOException occurs while closing, it will print an error message.
     * 
     * @param reader the reader to be closed
     */
    public static void closeReader(Reader reader) {
        try {
            reader.close();
        } catch(IOException e) {
            System.err.println("Error while trying to close the reader:\n" + e.getMessage());
        }
    }

    /**
     * Loads an image from the specified file path.
     * If an error occurs while loading the image, it returns null and prints an error message.
     * 
     * @param filePath the path to the image file
     * @return the loaded Image, or null if loading failed
     */
    public static Image readImage(String filePath) {
        try {
            return ImageIO.read(new File(filePath));
        } catch(IOException e) {
            System.err.println("Error while trying to read an image:\n" + e.getMessage());
        }

        return null;
    }
}
