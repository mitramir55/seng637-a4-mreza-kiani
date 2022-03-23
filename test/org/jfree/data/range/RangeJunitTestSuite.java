package org.jfree.data.range;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CombineIgnoringNaNMethodTest.class,
        IntersectMethodTest.class,
        ExpandToIncludeTest.class,
        isNaNRangeTest.class,
        ShiftTest.class,
        ConstrainTest.class,
        CombineTest.class,
        ConstructorTest.class,
        ExpandTest.class,
        ScaleTest.class
})
public class RangeJunitTestSuite {
}
