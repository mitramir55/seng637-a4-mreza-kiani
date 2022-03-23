package org.jfree.data.data_utilities;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CalculateColumnTotalTest.class,
        CalculateRowTotalTest.class,
        CreateNumberArrayTest.class,
        CreateNumberArray2DTest.class,
        GetCumulativePercentagesTest.class,
        CalculateColumnTotalValidRowsTest.class,
        CalculateRowTotalValidColumnsTest.class,
        CloneTest.class,
        EqualTest.class
})
public class DataUtilitiesJunitTestSuite {
}
