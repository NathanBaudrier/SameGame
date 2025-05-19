package utils;

/**
 * Represents a pair of indices (i, j) used to refer to the position of an element in a 2D grid.
 * The class provides methods to retrieve the row and column indices.
 * 
 * Usage example:
 * <pre>
 *     Index index = new Index(5, 10);
 *     int row = index.getI();
 *     int column = index.getJ();
 * </pre>
 * 
 * @author Nathan
 */
public class Index {

    private int i, j; 

    /**
     * Constructs an Index with the specified row (i) and column (j).
     * 
     * @param i the row index
     * @param j the column index
     */
    public Index(int i, int j) {
        this.i = i;
        this.j = j;
    }

    /**
     * Returns the row index (i).
     * 
     * @return the row index
     */
    public int getI() {
        return this.i;
    }

    /**
     * Returns the column index (j).
     * 
     * @return the column index
     */
    public int getJ() {
        return this.j;
    }
}
