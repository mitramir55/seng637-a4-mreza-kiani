package org.jfree.data.range;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScaleTest {
    private Range range;

    @Before
    public void setUp() throws Exception {
        range = new Range(-1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void expandNullRange() {
        Range.scale(null, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void aNegativeScale() {
        Range.scale(range, -2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void aSmallNegativeScale() {
        Range.scale(range, -0.5);
    }

    @Test
    public void aCorrectScale() {
        Range result = new Range(-2, 2);
        assertEquals(Range.scale(range, 2), result);
    }

    /*
    This test is for changing the factor to 1 in the if condition.
     */
    @Test
    public void aMutationStrengthenCorrectScaleTest() {
        Range result = new Range(-0.5, 0.5);
        assertEquals(Range.scale(range, 0.5), result);
    }
}