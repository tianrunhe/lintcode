package com.lintcode.problems;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class MergeSortedArrayTest {

    private MergeSortedArray msa = new MergeSortedArray();

    /**
     * Example 1:
     *
     * Input：[1, 2, 3] 3  [4,5]  2
     * Output：[1,2,3,4,5]
     * Explanation:
     * After merge, A will be filled as [1, 2, 3, 4, 5]
     */
    @Test
    public void test1() {
        int[] A = new int[] {1, 2, 3, 0, 0};
        int[] B = new int[] {4, 5};
        msa.mergeSortedArray(A, 3, B, B.length);
        assertTrue(Arrays.equals(A, new int[] {1, 2, 3, 4, 5}));
    }

    /**
     * Example 2:
     *
     * Input：[1,2,5] 3 [3,4] 2
     * Output：[1,2,3,4,5]
     * Explanation:
     * After merge, A will be filled as [1, 2, 3, 4, 5]
     */
    @Test
    public void test2() {
        int[] A = new int[] {1, 2, 5, 0, 0};
        int[] B = new int[] {3, 4};
        msa.mergeSortedArray(A, 3, B, B.length);
        assertTrue(Arrays.equals(A, new int[] {1, 2, 3, 4, 5}));
    }
}
