package com.lintcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are zero-based.
 *
 * Example
 * Example1:
 * numbers=[2, 7, 11, 15], target=9
 * return [0, 1]
 * Example2:
 * numbers=[15, 2, 7, 11], target=9
 * return [1, 2]
 * Challenge
 * Either of the following solutions are acceptable:
 *
 * O(n) Space, O(nlogn) Time
 * O(n) Space, O(n) Time
 * Notice
 * You may assume that each input would have exactly one solution
 */
public class TwoSum {

    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, List<Integer>> mapping = new HashMap<>();
        for (int i = 0; i < numbers.length; ++i) {
            List<Integer> indices = mapping.getOrDefault(numbers[i], new ArrayList<Integer>());
            indices.add(i);
            mapping.put(numbers[i], indices);
            int part = target - numbers[i];
            if (mapping.get(part) != null) {
                List<Integer> jIndices = mapping.get(part);
                for (int j : jIndices) {
                    if (i < j) {
                        return new int[] {i, j};
                    } else if (i > j) {
                        return new int[] {j, i};
                    }
                }
            }
        }
        return null;
    }
}
