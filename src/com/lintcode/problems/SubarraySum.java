package com.lintcode.problems;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an integer array, find a subarray where the sum of numbers is zero.
 * Your code should return the index of the first number and the index of the last number.
 *
 * Example 1:
 * 	Input:  [-3, 1, 2, -3, 4]
 * 	Output: [0, 2] or [1, 3].
 *
 * 	Explanation:
 * 	return anyone that the sum is 0.
 *
 * Example 2:
 * 	Input:  [-3, 1, -4, 2, -3, 4]
 * 	Output: [1,5]
 */
public class SubarraySum {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> prefixSumToIndex = new HashMap<>();
        prefixSumToIndex.put(0, 0);
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            Integer index = prefixSumToIndex.get(prefixSum);
            if (index != null) {
                result.add(index);
                result.add(i);
                return result;
            } else {
                prefixSumToIndex.put(prefixSum, i + 1);
            }
        }
        return result;
    }
}
