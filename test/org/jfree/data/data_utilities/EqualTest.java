package org.jfree.data.data_utilities;

import org.jfree.data.DataUtilities;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class EqualTest {

    @Test
    public void testSimpleEqualArrays() {
        double[][] a = new double[][]{{1, 2, 3, 4}, {5, 6, 7}};
        double[][] b = new double[][]{{1, 2, 3, 4}, {5, 6, 7}};

        assertTrue(DataUtilities.equal(a, b));
    }

    @Test
    public void testFirstParameterNull() {
        double[][] a = null;
        double[][] b = new double[][]{{1, 2, 3, 4}, {5, 6, 7}};

        assertFalse(DataUtilities.equal(a, b));
    }

    @Test
    public void testSecondParameterNull() {
        double[][] a = null;
        double[][] b = new double[][]{{1, 2, 3, 4}, {5, 6, 7}};

        assertFalse(DataUtilities.equal(b, a));
    }

    @Test
    public void testBothParametersNull() {
        double[][] a = null;
        double[][] b = null;

        assertTrue(DataUtilities.equal(a, b));
    }

    @Test
    public void testDifferentLengths() {
        double[][] a = new double[][]{{1, 2, 3, 4}, {5, 6, 7}, {7, 1, 7}};
        double[][] b = new double[][]{{1, 2, 3, 4}, {5, 6, 7}};

        assertFalse(DataUtilities.equal(a, b));
    }
    @Test
    public void testSameLengthsDifferentArrays() {
        double[][] a = new double[][]{{1, 2, 3, 1}, {5, 6, 7}};
        double[][] b = new double[][]{{1, 2, 3, 4}, {5, 6, 7}};

        assertFalse(DataUtilities.equal(a, b));
    }


}
