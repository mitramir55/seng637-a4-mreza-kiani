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

    @Test
    public void aCorrectScale() {
        Range result = new Range(-2, 2);
        assertEquals(Range.scale(range, 2), result);
    }
}