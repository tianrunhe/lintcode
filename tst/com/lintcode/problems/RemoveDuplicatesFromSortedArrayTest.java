package com.lintcode.problems;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveDuplicatesFromSortedArrayTest {

    private RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();

    /**
     * Input:  []
     * Output: 0
     */
    @Test
    public void test1() {
        assertEquals(0, removeDuplicatesFromSortedArray.removeDuplicates(new int[]{}));
    }

    /**
     * Input:  [1,1,2]
     * Output: 2
     * Explanation:  uniqued array: [1,2]
     */
    @Test
    public void test2() {
        assertEquals(2, removeDuplicatesFromSortedArray.removeDuplicates(new int[]{1, 1, 2}));
    }
}
