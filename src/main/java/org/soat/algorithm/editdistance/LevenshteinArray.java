package org.soat.algorithm.editdistance;

/**
 * LevenshteinArray implements the Levenshtein algorithm to calculate the edit
 * distance between two words.
 *
 * @author SManicon <sebastien.manicon@soat.fr>
 * @version 1.0
 */
public class LevenshteinArray {
    private int[][] array;
    private int width, height;

    /**
     * Build a new LevenshteinArray object, and init all properties.
     *
     * @param width     The width of the array.
     * @param height    The height of the array.
     */
    public LevenshteinArray(int width, int height) {
        this.array  = new int[width][height];
        this.width  = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    /**
     * Set the cell value.
     *
     * @param x     the x coordinate of the array.
     * @param y     the y coordinate of the array.
     * @param value the new cell value.
     */
    public void setCellValue(int x, int y, int value) {
        this.array[x][y] = value;
    }

    /**
     * Get the cell value. If the x or y param value is -1,
     * then the value returned is the margin value.
     *
     * @param x the x coordinate of the array.
     * @param y the y coordinate of the array.
     *
     * @return  the value of the cell.
     */
    public int getCellValue(int x, int y) {
        if (x == -1 || y == -1) {
            return this.getMarginValue(x, y);
        }
        return this.array[x][y];
    }

    private int getMarginValue(int x, int y) {
        if(x == -1) {
            return y + 1;
        }

        return x + 1;
    }

    /**
     * @see LevenshteinArray#calculateCellValue(int, int, boolean)
     *
     * @param x the x coordinate of the array.
     * @param y the y coordinate of the array.
     * @param c1 char to test.
     * @param c2 char to test.
     *
     */
    public void calculateCellValue(int x, int y, char c1, char c2) {
        calculateCellValue(x, y, c1 == c2);
    }

    /**
     * Apply the Levenshtein calculate on a cell. Test on previews cell
     * if there are an insertion, a suppression or a substitution.
     * To calculate a cell, make sur the previous cells ( [x-1, y], [x, y-1]
     * and [x-1, y-1] ) has been already calculated.
     *
     * @param x the x coordinate of the array.
     * @param y the y coordinate of the array.
     * @param isSame
     */
    public void calculateCellValue(int x, int y, boolean isSame) {
        int insertion    = this.getCellValue(x-1, y) + 1;
        int suppression  = this.getCellValue(x, y-1) + 1;
        int substitution = this.getCellValue(x-1, y-1) + (isSame ? 0 : 1);

        this.setCellValue(x, y, Math.min(insertion, Math.min(suppression, substitution)));
    }

}
