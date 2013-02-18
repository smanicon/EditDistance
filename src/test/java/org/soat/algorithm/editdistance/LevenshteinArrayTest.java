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
}
