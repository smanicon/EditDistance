package org.soat.algorithm.editdistance;

import static org.fest.assertions.api.Assertions.*;

import org.junit.Test;

/**
 * Default test for the LevenshteinArray class.
 */
public class LevenshteinArrayTest {

    @Test
    public void testMarginValue() {
        LevenshteinArray la = new LevenshteinArray(10, 10);

        assertThat(la.getCellValue(-1, -1)).isEqualTo(0);
        assertThat(la.getCellValue(-1,  9)).isEqualTo(10);
        assertThat(la.getCellValue( 9, -1)).isEqualTo(10);
    }

    @Test
    public void testCellCalculateSubstitutionNotSame() {
        LevenshteinArray la = new LevenshteinArray(10, 10);

        la.calculateCellValue(0, 0, false);
        assertThat(la.getCellValue(0, 0)).isEqualTo(1);
    }

    @Test
    public void testCellCalculateSubstitutionSame() {
        LevenshteinArray la = new LevenshteinArray(10, 10);

        la.calculateCellValue(0, 0, true);
        assertThat(la.getCellValue(0, 0)).isEqualTo(0);
    }

    @Test
    public void testCellCalculateInsertion() {
        LevenshteinArray la = new LevenshteinArray(10, 10);

        la.setCellValue(0, 0, 3);
        la.setCellValue(1, 0, 3);
        la.setCellValue(0, 1, 1);

        la.calculateCellValue(1, 1, true);
        assertThat(la.getCellValue(1, 1)).isEqualTo(2);
    }

    @Test
    public void testCellCalculateSuppression() {
        LevenshteinArray la = new LevenshteinArray(10, 10);

        la.setCellValue(0, 0, 3);
        la.setCellValue(1, 0, 3);
        la.setCellValue(0, 1, 1);

        la.calculateCellValue(1, 1, true);
        assertThat(la.getCellValue(1, 1)).isEqualTo(2);
    }

    @Test
    public void testAlgorithmOnSameWord() {
        LevenshteinArray la = new LevenshteinArray(4, 4);

        assertThat(la.getDistanceOf("abc", "abc")).isEqualTo(0);
    }

    @Test
    public void testAlgorithmWithSubstitution() {
        LevenshteinArray la = new LevenshteinArray(4, 4);

        assertThat(la.getDistanceOf("abc", "adc")).isEqualTo(1);
    }

    @Test
    public void testAlgorithmWithInsertion() {
        LevenshteinArray la = new LevenshteinArray(4, 4);

        assertThat(la.getDistanceOf("abc", "bc")).isEqualTo(1);
    }

    @Test
    public void testAlgorithmWithSuppression() {
        LevenshteinArray la = new LevenshteinArray(4, 4);

        assertThat(la.getDistanceOf("bc", "abc")).isEqualTo(1);
    }

    @Test
    public void testAlgorithmWithEmptyWord() {
        LevenshteinArray la = new LevenshteinArray(4, 4);
        assertThat(la.getDistanceOf("", "abc")).isEqualTo(3);
        assertThat(la.getDistanceOf("abc", "")).isEqualTo(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAlgorithmWithStr1OutOfBoundary() {
        LevenshteinArray la = new LevenshteinArray(4, 4);

        la.getDistanceOf("abcde","abc");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAlgorithmWithStr2OutOfBoundary() {
        LevenshteinArray la = new LevenshteinArray(4, 4);

        la.getDistanceOf("abc","abcde");
    }

    @Test
    public void testAlgorithmWithSomeWord() {
        LevenshteinArray la = new LevenshteinArray(20, 20);

        assertThat(la.getDistanceOf("word", "world")).isEqualTo(1);
        assertThat(la.getDistanceOf("happy", "apply")).isEqualTo(2);
        assertThat(la.getDistanceOf("week", "weed")).isEqualTo(1);
        assertThat(la.getDistanceOf("whole", "while")).isEqualTo(1);
        assertThat(la.getDistanceOf("player", "gamer")).isEqualTo(3);
        assertThat(la.getDistanceOf("clear", "beer")).isEqualTo(3);
    }

}
