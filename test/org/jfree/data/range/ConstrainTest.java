package org.jfree.data.range;

import org.jfree.data.Range;
import org.junit.*;

import static org.junit.Assert.*;

public class ConstrainTest {
    private Range range;
    private final double DELTA = 0.0001;

    @Before
    public void setUp() throws Exception {
        range = new Range(-1, 1);
    }

    @Test
    public void anIncludedValue() {
        assertEquals(range.constrain(0), 0.0, DELTA);
    }

    @Test
    public void aLargerValue() {
        assertEquals(range.constrain(2), 1, DELTA);
    }

    @Test
    public void aSmallerValue() {
        assertEquals(range.constrain(-2), -1, DELTA);
    }

    @Test
    public void nanValue() {
        assertEquals(range.constrain(Double.NaN), Double.NaN, DELTA);
    }

    @Test
    public void testContainsMethod() {
        assertTrue(range.contains(0.5));
    }

    @Test
    public void testContainsMethodWithNonContainsValue() {
        assertFalse(range.contains(4));
    }

    @Test
    public void testContainsMethodWithMarginalValue() {
        assertTrue(range.contains(1));
    }

    @Test
    public void testContainsMethodWithLowerMarginalValue() {
        assertTrue(range.contains(-1));
    }

}