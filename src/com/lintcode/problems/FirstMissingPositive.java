package com.lintcode.problems;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * Example
 * Example 1:
 *
 * Input:[1,2,0]
 * Output:3
 * Example 2:
 *
 * Input:[3,4,-1,1]
 * Output:2
 * Challenge
 * Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPositive {
    /**
     * @param A: An array of integers
     * @return: An integer
     */
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        for(int i = 0; i < n; i++) {
            while(A[i] > 0 && A[i] <= n && A[i] != A[A[i] - 1]) {
                swap(A, i, A[i] - 1);
            }
        }

        for(int i = 0; i < n; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
