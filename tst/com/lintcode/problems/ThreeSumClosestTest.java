package com.lintcode.problems;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThreeSumClosestTest {

    private ThreeSumClosest testee = new ThreeSumClosest();

    /**
     * Example 1:
     *
     * Input:[2,7,11,15],3
     * Output:20
     * Explanation:
     * 2+7+11=20
     */
    @Test
    public void test1() {
        assertEquals(20, testee.threeSumClosest(new int[] {2, 7, 11, 15}, 3));
    }

    /**
     * Example 2:
     *
     * Input:[-1,2,1,-4],1
     * Output:2
     * Explanation:
     * -1+2+1=2
     */
    @Test
    public void test2() {
        assertEquals(2, testee.threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
    }
}
