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
}
