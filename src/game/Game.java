package game;

/**
 * Represents a game session containing a grid and a score system.
 * 
 * This class manages the state of the game (started or not), the player's score,
 * and provides methods to start the game, update the score, and reset it.
 * 
 * It relies on a Grid object to represent the game board or environment.
 * 
 * Example usage:
 * <pre>
 *     Grid grid = new Grid();
 *     Game game = new Game(grid);
 *     game.start();
 *     game.addPoints(10);
 *     int score = game.getPoints();
 * </pre>
 * 
 * @author Nathan
 */
public class Game {

    private int points = 0;

    private Grid grid;

    /**
     * Constructs a new Game instance with the specified grid.
     *
     * @param grid the Grid object used in this game
     */
    public Game(Grid grid) {
        this.grid = grid;
    }

    /**
     * Returns the grid used in this game.
     *
     * @return the Grid object associated with the game
     */
    public Grid getGrid() {
        return this.grid;
    }

    /**
     * Returns the current score of the game.
     *
     * @return the number of points accumulated
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * Adds the specified number of points to the current score.
     *
     * @param points the number of points to add
     */
    public void addPoints(int points) {
        this.points += points;
    }
}
