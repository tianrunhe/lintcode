package com.lintcode.problems;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductOfArrayExcludeItselfTest {

    private ProductOfArrayExcludeItself testee = new ProductOfArrayExcludeItself();

    /**
     * Example 1
     *
     * Input: A = [1, 2, 3]
     * Output: [6, 3, 2]
     * Explanation：B[0] = A[1] * A[2] = 6; B[1] = A[0] * A[2] = 3; B[2] = A[0] * A[1] = 2
     */
    @Test
    public void test1() {
        List<Long> expected = ImmutableList.of(6l, 3l, 2l);
        assertEquals(expected, testee.productExcludeItself(ImmutableList.of(1, 2, 3)));
    }

    /**
     * Example 2
     *
     * Input: A = [2, 4, 6]
     * Output: [24, 12, 8]
     */
    @Test
    public void test2() {
        List<Long> expected = ImmutableList.of(24l, 12l, 8l);
        assertEquals(expected, testee.productExcludeItself(ImmutableList.of(2, 4, 6)));
    }
}
