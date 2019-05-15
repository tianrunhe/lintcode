package com.lintcode.problems;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveElementTest {

    private RemoveElement removeElement = new RemoveElement();

    /**
     * Example 1:
     * 	Input: [], value = 0
     * 	Output: 0
     */
    @Test
    public void test1() {
        int[] input = new int[] {};
        assertEquals(0, removeElement.removeElement(input, 0));
    }

     /**
     * Example 2:
     * 	Input:  [0,4,4,0,0,2,4,4], value = 4
     * 	Output: 4
     *
     * 	Explanation:
     * 	the array after remove is [0,0,0,2]
     */
     @Test
    public void test2() {
        int[] input = new int[] {0,4,4,0,0,2,4,4};
        assertEquals(4, removeElement.removeElement(input, 4));
     }
}
