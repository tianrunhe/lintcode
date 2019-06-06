package com.lintcode.problems;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FirstMissingPositiveTest {

    private FirstMissingPositive testee = new FirstMissingPositive();

    /**
     * Example 1:
     *
     * Input:[1,2,0]
     * Output:3
     */
    @Test
    public void test1() {
        assertEquals(3, testee.firstMissingPositive(new int[] {1, 2, 0}));
    }

    /**
     * Example 2:
     *
     * Input:[3,4,-1,1]
     * Output:2
     */
    @Test
    public void test2() {
        assertEquals(3, testee.firstMissingPositive(new int[] {1, 2, 0}));
    }

    @Test
    public void test3() {
        assertEquals(2, testee.firstMissingPositive(new int[] {3, 4, -1, 1}));
    }
}
