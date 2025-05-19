package exceptions.grid;

/**
 * Exception thrown when an invalid character is found in a grid file.
 * <p>
 * Only 'R', 'V', or 'B' (case-insensitive) are valid grid characters.
 * </p>
 */
public class InvalidGridCharacterException extends GridException {

    /**
     * Constructs a new InvalidGridCharacterException with line and column information.
     *
     * @param line   the line number where the invalid character was found (1-based)
     * @param column the column number of the invalid character (1-based)
     */
    public InvalidGridCharacterException(int line, int column) {
        super(
            "InvalidGridCharacterException: Invalid character for grid files at line " + line 
            + " and column " + column
        );
    }
}
