package com.lintcode.problems;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class TwoSumTest {

    private TwoSum twoSum = new TwoSum();

    /**
     * Example1:
     * numbers=[2, 7, 11, 15], target=9
     * return [0, 1]
     */
    @Test
    public void test1() {
        assertTrue(Arrays.equals(new int[] {0, 1}, twoSum.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    /**
     * Example2:
     * numbers=[15, 2, 7, 11], target=9
     * return [1, 2]
     */
    @Test
    public void test2() {
        assertTrue(Arrays.equals(new int[] {1, 2}, twoSum.twoSum(new int[]{15, 2, 7, 11}, 9)));
    }
}
