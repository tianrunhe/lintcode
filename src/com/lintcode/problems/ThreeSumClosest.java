package com.lintcode.problems;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers.
 *
 * Example
 * Example 1:
 *
 * Input:[2,7,11,15],3
 * Output:20
 * Explanation:
 * 2+7+11=20
 * Example 2:
 *
 * Input:[-1,2,1,-4],1
 * Output:2
 * Explanation:
 * -1+2+1=2
 * Challenge
 * O(n^2) time, O(1) extra space
 *
 * Notice
 * You may assume that each input would have exactly one solution.
 */
public class ThreeSumClosest {

    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        int result = numbers[0] + numbers[1] + numbers[numbers.length - 1];
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            int start = i + 1, end = numbers.length - 1;
            while (start < end) {
                int sum = numbers[i] + numbers[start] + numbers[end];
                if (sum < target) {
                    start++;
                } else {
                    end--;
                }

                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}
