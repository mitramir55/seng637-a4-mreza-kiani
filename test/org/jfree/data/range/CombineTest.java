package org.jfree.data.range;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CombineTest {
    @Test
    public void twoSeparateRanges() {
        Range r1 = new Range(-1, -0.5);
        Range r2 = new Range(0.5, 1);
        Range result = new Range(-1, 1);
        assertEquals(Range.combine(r1, r2), result);
    }

    @Test
    public void twoRangesWitIntersection() {
        Range r1 = new Range(-1, 0.5);
        Range r2 = new Range(-0.5, 1);
        Range result = new Range(-1, 1);
        assertEquals(Range.combine(r1, r2), result);
    }

    @Test
    public void aLeftNullRange() {
        Range r2 = new Range(-0.5, 1);
        assertEquals(Range.combine(null, r2), r2);
    }

    @Test
    public void aRightNullRange() {
        Range r1 = new Range(-1, 0.5);
        assertEquals(Range.combine(r1, null), r1);
    }

}