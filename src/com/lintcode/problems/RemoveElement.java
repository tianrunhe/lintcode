package com.lintcode.problems;

/**
 * Given an array and a value, remove all occurrences of that value in place and return the new length.
 * The order of elements can be changed, and the elements after the new length don't matter.
 *
 * Example 1:
 * 	Input: [], value = 0
 * 	Output: 0
 *
 *
 * Example 2:
 * 	Input:  [0,4,4,0,0,2,4,4], value = 4
 * 	Output: 4
 *
 * 	Explanation:
 * 	the array after remove is [0,0,0,2]
 */
public class RemoveElement {

    /*
     * @param A: A list of integers
     * @param elem: An integer
     * @return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem) {
                count++;
            } else {
                int j = i + 1;
                while (j < A.length && A[i] == elem) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j++] = temp;
                }
                if (j == A.length) {
                    return A[i] == elem ? 0 : i + 1;
                }
            }
        }
        return count;
    }
}
