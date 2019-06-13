package com.lintcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Example
 * Example 1:
 *
 * Input:[2,7,11,15]
 * Output:[]
 * Example 2:
 *
 * Input:[-1,0,1,2,-1,-4]
 * Output:	[[-1, 0, 1],[-1, -1, 2]]
 * Notice
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 *
 * The solution set must not contain duplicate triplets.
 */
public class ThreeSum {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers);
        List<List<Integer>> solutions = new ArrayList<>();
        for (int i = 0; i < numbers.length; ++i) {
            int a = numbers[i];
            int target = 0 - a;
            int start = i + 1;
            int end = numbers.length - 1;
            while (start < end) {
                int sum = numbers[start] + numbers[end];
                if (sum == target) {
                    List<Integer> solution = new ArrayList<>();
                    solution.add(numbers[i]);
                    solution.add(numbers[start]);
                    solution.add(numbers[end]);
                    if (!solutions.contains(solution)) {
                        solutions.add(solution);
                    }
                    start++;
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return solutions;
    }
}
