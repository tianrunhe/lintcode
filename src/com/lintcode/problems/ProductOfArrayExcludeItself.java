package com.lintcode.problems;

import java.util.Arrays;
import java.util.List;

/**
 * Given an integers array A.
 *
 * Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], calculate B WITHOUT divide operation.Out put B
 *
 * Example
 * Example 1
 *
 * Input: A = [1, 2, 3]
 * Output: [6, 3, 2]
 * Explanation：B[0] = A[1] * A[2] = 6; B[1] = A[0] * A[2] = 3; B[2] = A[0] * A[1] = 2
 * Example 2
 *
 * Input: A = [2, 4, 6]
 * Output: [24, 12, 8]
 */
public class ProductOfArrayExcludeItself {

    /**
     * @param nums: Given an integers array A
     * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public List<Long> productExcludeItself(List<Integer> nums) {
        int n = nums.size();
        Long[] res = new Long[n];
        res[0] = 1l;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums.get(i - 1);
        }
        long right = 1l;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums.get(i);
        }

        return Arrays.asList(res);
    }
}
