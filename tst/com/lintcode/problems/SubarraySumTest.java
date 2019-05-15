package com.lintcode.problems;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubarraySumTest {

    private SubarraySum subarraySum = new SubarraySum();

    /**
     * Example 1:
     * 	Input:  [-3, 1, 2, -3, 4]
     * 	Output: [0, 2] or [1, 3].
     *
     * 	Explanation:
     * 	return anyone that the sum is 0.
     */
    @Test
    public void test1() {
        assertEquals(ImmutableList.of(0, 2), subarraySum.subarraySum(new int[]{-3, 1, 2, -3, 4}));
    }

    /**
     * Example 2:
     * 	Input:  [-3, 1, -4, 2, -3, 4]
     * 	Output: [1,5]
     */
    @Test
    public void test2() {
        assertEquals(ImmutableList.of(1, 5), subarraySum.subarraySum(new int[]{-3, 1, -4, 2, -3, 4}));
    }
}
