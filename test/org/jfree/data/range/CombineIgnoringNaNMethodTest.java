package org.jfree.data.range;

import org.jfree.data.Range;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CombineIgnoringNaNMethodTest {

    @BeforeClass
    public static void setUpBeforeClass() {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void aCombineWithMarginalValues() {
        Range r1 = new Range(-1, 1);
        Range r2 = new Range(1, 2);
        Range result = Range.combineIgnoringNaN(r1, r2);
        Range expected = new Range(-1, 2);
        assertEquals(expected, result);
    }

    @Test
    public void aCombineWithIntersection() {
        Range r1 = new Range(-1, 1.5);
        Range r2 = new Range(0.5, 2);
        Range result = Range.combineIgnoringNaN(r1, r2);
        Range expected = new Range(-1, 2);
        assertEquals(expected, result);
    }

    @Test
    public void aCombineWithNoIntersection() {
        Range r1 = new Range(-1, 0.5);
        Range r2 = new Range(1.5, 2);
        Range result = Range.combineIgnoringNaN(r1, r2);
        Range expected = new Range(-1, 2);
        assertEquals(expected, result);
    }

    @Test
    public void aFullyNullCombination() {
        Range result = Range.combineIgnoringNaN(null, null);
        assertNull(result);
    }

    @Test
    public void aPartialNullCombinationPar2() {
        Range r2 = new Range(-1, 0.5);
        Range result = Range.combineIgnoringNaN(null, r2);
        assertEquals(r2, result);
    }

    @Test
    public void aPartialNullCombination() {
        Range r1 = new Range(-1, 0.5);
        Range result = Range.combineIgnoringNaN(r1, null);
        assertEquals(r1, result);
    }

    @Test
    public void aCombinationOfNullAndNaNValue() {
        Range r2 = new Range(Double.NaN, Double.NaN);
        Range result = Range.combineIgnoringNaN(null, r2);
        assertNull(result);
    }

    @Test
    public void aCombinationOfNaNValueAndNull() {
        Range r1 = new Range(Double.NaN, Double.NaN);
        Range result = Range.combineIgnoringNaN(r1, null);
        assertNull(result);
    }

    @Test
    public void aCombinationOfAllNaNValues() {
        Range r1 = new Range(Double.NaN, Double.NaN);
        Range r2 = new Range(Double.NaN, Double.NaN);
        Range result = Range.combineIgnoringNaN(r1, r2);
        assertNull(result);
    }

    @Test
    public void aCombinationWithNaNValue() {
        Range r1 = new Range(-1, 0.5);
        Range r2 = new Range(Double.NaN, Double.NaN);
        Range result = Range.combineIgnoringNaN(r1, r2);
        assertEquals(r1, result);
    }

    @Test
    public void aCombinationWithPartialUpperBondNaNValue() {
        Range r1 = new Range(-1, 0.5);
        Range r2 = new Range(-2, Double.NaN);
        Range result = Range.combineIgnoringNaN(r1, r2);
        Range expected = new Range(-2, 0.5);
        assertEquals(expected, result);
    }

    @Test
    public void aCombinationWithUpperBondNaNValue() {
        Range r1 = new Range(-1, Double.NaN);
        Range r2 = new Range(-1, Double.NaN);
        Range result = Range.combineIgnoringNaN(r1, r2);
        Range expected = new Range(-1, Double.NaN);
        assertEquals(expected, result);
    }

    @After
    public void tearDown() {
    }

    @AfterClass
    public static void tearDownAfterClass() {
    }
}