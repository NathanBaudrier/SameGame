package exceptions.grid;

/**
 * Base exception class for grid-related errors.
 * <p>
 * This exception is extended by specific grid exceptions such as:
 * <ul>
 *     <li>{@link InvalidGridCharacterException}</li>
 *     <li>{@link MissingGridCharactersException}</li>
 *     <li>{@link MissingGridLinesException}</li>
 * </ul>
 * </p>
 */
public class GridException extends Exception {

    /**
     * Constructs a new GridException with the specified detail message.
     *
     * @param message the detail message
     */
    public GridException(String message) {
        super(message);
    }
}
