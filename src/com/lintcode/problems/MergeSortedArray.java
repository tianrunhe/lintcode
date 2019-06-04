package com.lintcode.problems;

public class MergeSortedArray {

    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int i = 0;
        int j = 0;
        while (j < n) {
            if (A[i] != 0 && A[i] < B[j]) {
                i++;
            } else {
                int k = m + j;
                while(k != i) {
                    A[k] = A[k - 1];
                    k--;
                }
                A[k] = B[j];
                j++;
            }
        }
    }
}
