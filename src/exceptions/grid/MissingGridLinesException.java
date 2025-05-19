package exceptions.grid;

import game.Grid;

/**
 * Exception thrown when a grid file contains fewer lines than expected.
 * <p>
 * The file must contain exactly {@link game.Grid#MAX_LINES} lines.
 * </p>
 */
public class MissingGridLinesException extends GridException {

    /**
     * Constructs a new MissingGridLinesException with the actual number of lines.
     *
     * @param linesNumber the number of lines found in the file
     */
    public MissingGridLinesException(long linesNumber) {
        super(
            "MissingGridLinesException: Not enough lines in the selected file to match a grid format (current: " + String.valueOf(linesNumber)
            + ", requested: " + String.valueOf(Grid.MAX_LINES) + ")"
        );
    }
}
