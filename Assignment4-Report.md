**SENG 637- Dependability and Reliability of Software Systems**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#:              | 16  |
|------------------------|-----|
| Shahryar Soltanpour    |     |
| Mohammad Reza Kianifar |     |
| Muhammad Raihan        |     |

# Introduction

# Link of demo video

[Video Link](TODO://add-here-the-link-of-the-video)

It works for everyone with logged-in university account on outlook.
Please [tell us](mailto:mohammadreza.kianifa@ucalgary.ca) if you had any problem.\

# Analysis of 10 Mutants of the Range class

| Method                                                                                                       | Mutation                                                                                   | Analysis                                                                                                                                                                                                                                                                      |
|--------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| getUpperBound()                                                                                              | Negated double field upper → KILLED                                                        | Instead of returning this.upper, it returns -this.upper. Because we had plenty of tests that used the Range(-0.5, 0.5), when we negate the upper bound, and we check the contains method for value 0, the result changes from true to false, and the test fails.              |
| getLowerBound()                                                                                              | Incremented (a++) double field upper → KILLED                                              | Instead of returning this.lower, it returns this.lower+1. So for the Range(-0.5, 0.5), the range becomes Range(0.5, 0.5) and the contains(0) result will change from true to false, and the test fails.                                                                       | 
| getLength()                                                                                                  | Replaced double subtraction with addition → KILLED                                         | Instead of returning this.upper-this.lower, it returns this.upper+this.lower. So the length for Range(-2, -0.5) would be -2.5 instead of 1.5 and our tests that check method this will fail.                                                                                  |
| getLength()                                                                                                  | replaced double return with 0.0d for org/jfree/data/Range::getLength → KILLED              | Instead of returning this.upper-this.lower, it returns 0. So the length for Range(-2, -0.5) would be 0 instead of 1.5 and our tests that check method this will fail.                                                                                                         |
| getLength()                                                                                                  | replaced return of double value with -(x + 1) for org/jfree/data/Range::getLength → KILLED | Instead of returning this.upper-this.lower, it returns -(this.upper-this.lower)-1. So the length for Range(-2, -0.5) would be -2.5 instead of 0.5 and our tests that check method this will fail.                                                                             |
| getLength()                                                                                                  | Replaced double subtraction with multiplication → KILLED                                   | Instead of returning this.upper-this.lower, it returns this.upper*this.lower. So the length for Range(-2, -0.5) would be 1 instead of 0.5 and our tests that check method this will fail.                                                                                     |
| combine(Range range1, Range range2) <br> if (range1 == null)                                                 | negated conditional → KILLED                                                               | Instead of checking (range1 == null) it checks !(range1 == null). We had a test that passed range1(-1, 0), range2(0, 1) to the function, and the result should be Range(-1, 1). But now because the if condition is true, it will return range2 as result and the test fails. |
| combine(Range range1, Range range2) <br> if (range1 == null)                                                 | removed conditional - replaced equality check with false → KILLED                          | Instead of checking (range1 == null) it's always false. We had a test that passed range1 as null and range2(0, 1) to the function, and the result should be range2. But now the code raise NullPointerException and fails.                                                    |
| expand(Range range, double lowerMargin, double upperMargin)<br>ParamChecks.nullNotPermitted(range, "range"); | removed call to org/jfree/chart/util/ParamChecks::nullNotPermitted → KILLED                | It removes this line. We had a test that passed range=null to the function, and expected IllegalArgumentException but now it doesn't  work and code raises NullPointerException.                                                                                              |  
| expand(Range range, double lowerMargin, double upperMargin)<br>upper = lower;                                | Negated double local variable → KILLED                                                     | Instead of assigning lower to upper, it assigns -lower to upper. So the final Range changes. We had a test that we finally expected Range(-3, 3), but now we receive Range(-3, -3), and the test fails.                                                                       |  
 
# Report all the statistics and the mutation score for each test class

# Analysis drawn on the effectiveness of each of the test classes

# A discussion on the effect of equivalent mutants on mutation score accuracy

# A discussion of what could have been done to improve the mutation score of the test suites

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

# Explain your SELENUIM test case design process

# Explain the use of assertions and checkpoints

# how did you test each functionaity with different test data

# Discuss advantages and disadvantages of Selenium vs. Sikulix

# How the team work/effort was divided and managed

# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself
