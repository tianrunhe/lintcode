package com.lintcode.problems;

/**
 * Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:
 *
 * All elements < k are moved to the left
 * All elements >= k are moved to the right
 * Return the partitioning index, i.e the first index i nums[i] >= k.
 *
 * Example
 * Example 1:
 *
 * Input:
 * [],9
 * Output:
 * 0
 *
 * Example 2:
 *
 * Input:
 * [3,2,2,1],2
 * Output:1
 * Explanation:
 * the real array is[1,2,2,3].So return 1
 * Challenge
 * Can you partition the array in-place and in O(n)?
 *
 * Notice
 * You should do really partition in array nums instead of just counting the numbers of integers smaller than k.
 *
 * If all elements in nums are smaller than k, then return nums.length
 */
public class PartitionArray {
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int a = nums[start];
            int b = nums[end];
            if (a < k) {
                start++;
            } else if (b >= k) {
                end--;
            } else { // a >= k || b < k
                swap(nums, start, end);
                start++;
                end--;
            }
        }
        int index = 0;
        while(index < nums.length && nums[index] < k) {
            index++;
        }
        return index;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
