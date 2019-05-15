package com.lintcode.problems;

/**
 * Given a sorted array, 'remove' the duplicates in place such that each element appear only once and return the 'new' length.
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * Example 1:
 *
 * Input:  []
 * Output: 0
 *
 * Example 2:
 *
 * Input:  [1,1,2]
 * Output: 2
 * Explanation:  uniqued array: [1,2]
 */
public class RemoveDuplicatesFromSortedArray {
    /*
     * @param nums: An ineger array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length;) {
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            nums[pos] = nums[i];
            i = j;
            pos++;
        }
        return pos;
    }
}
