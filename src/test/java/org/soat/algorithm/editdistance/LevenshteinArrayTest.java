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



}
