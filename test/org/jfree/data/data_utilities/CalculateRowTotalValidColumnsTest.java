package org.jfree.data.data_utilities;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculateRowTotalValidColumnsTest {
    private static Mockery mockingContext;
    private static Values2D values;
    private final double DELTA = .000000001d;

    @Before
    public void setUp() throws Exception {
        mockingContext = new Mockery();
        values = mockingContext.mock(Values2D.class);
    }

    @Test
    public void calculateRowTotalOfOneColumnWithValidColumn() {
        mockingContext.checking(new Expectations() {{
            one(values).getColumnCount();
            will(returnValue(1));
            one(values).getValue(0, 0);
            will(returnValue(5.1));
        }});

        double result = DataUtilities.calculateRowTotal(values, 0, new int[]{0});
        assertEquals("The calculated sum should be 5.1", 5.1, result, DELTA);
    }
    @Test
    public void calculateRowTotalOfOneColumnWithMoreValidColumns() {
        mockingContext.checking(new Expectations() {{
            one(values).getColumnCount();
            will(returnValue(1));
            one(values).getValue(0, 0);
            will(returnValue(5.1));
        }});

        double result = DataUtilities.calculateRowTotal(values, 0, new int[]{0, 1});
        assertEquals("The calculated sum should be 5.1", 5.1, result, DELTA);
    }
    @Test
    public void calculateRowTotalOfOneColumnWithNoValidColumns() {
        mockingContext.checking(new Expectations() {{
            one(values).getColumnCount();
            will(returnValue(1));
            one(values).getValue(0, 0);
            will(returnValue(5.1));
        }});

        double result = DataUtilities.calculateRowTotal(values, 0, new int[]{});
        assertEquals("The calculated sum should be 0", 0, result, DELTA);
    }
    @Test
    public void calculateRowTotalOfOneColumnWithNullElement() {
        mockingContext.checking(new Expectations() {{
            one(values).getColumnCount();
            will(returnValue(1));
            one(values).getValue(0, 0);
            will(returnValue(null));
        }});

        double result = DataUtilities.calculateRowTotal(values, 0, new int[]{0});
        assertEquals("The calculated sum should be 0", 0, result, DELTA);
    }
}
