package org.jfree.data.data_utilities;

import org.jfree.data.DataUtilities;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CloneTest {


    @Test
    public void testCloneWithSimpleArgument() {
        double[][] array = new double[][]{{1, 2, 3, 4}, {5, 6, 7}};
        double[][] result = DataUtilities.clone(array);
        assertArrayEquals(array, result);
    }

    @Test
    public void testCloneWithEmptyArgument() {
        double[][] array = new double[][]{{}, {}};
        double[][] result = DataUtilities.clone(array);
        assertArrayEquals(array, result);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCloneWithNullArgument() {
        DataUtilities.clone(null);
    }

}
