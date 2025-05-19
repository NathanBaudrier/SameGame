package exceptions.grid;

import game.Grid;

/**
 * Exception thrown when a line in a grid file does not contain the expected number of characters.
 * <p>
 * Each line must contain exactly {@link game.Grid#MAX_COLUMNS} characters.
 * </p>
 */
public class MissingGridCharactersException extends GridException {

    /**
     * Constructs a new MissingGridCharactersException for the given line number.
     *
     * @param line the line number that is missing characters (1-based)
     */
    public MissingGridCharactersException(int line) {
        super(
            "MissingGridCharactersException: Line incomplete on selected file, missing character(s) on line " + line 
            + " (max characters per line = " + Grid.MAX_COLUMNS + ")"
        );
    }
}
