package org.jfree.data.range;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpandTest {
    private Range range;
    private final double DELTA = 0.0001;

    @Before
    public void setUp() throws Exception {
        range = new Range(-1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void expandNullRange() {
        Range.expand(null, 2, 2);
    }

    @Test
    public void anEqualExpansion() {
        Range result = new Range(-3, 3);
        assertEquals(Range.expand(range, 1, 1), result);
    }

    @Test
    public void doubleExpansion() {
        Range result = new Range(-5, 5);
        assertEquals(Range.expand(range, 2, 2), result);
    }

    @Test
    public void strangeExpansion() {
        Range result = new Range(2, 2);
        assertEquals(Range.expand(range, -2, 0), result);
    }

}