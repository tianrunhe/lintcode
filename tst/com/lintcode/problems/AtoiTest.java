package com.lintcode.problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Example
 * Example 1
 * Input: "10"
 * Output: 10
 * 
 * Example 2
 * Input: "1"
 * Output: 1
 * 
 * Example 3
 * Input: "123123123123123"
 * Output: 2147483647
 * Explanation: 123123123123123 > INT_MAX, so we return INT_MAX
 * 
 * Example 4
 * Input: "1.0"
 * Output: 1
 * Explanation: We just need to change the first vaild number
 * 
 */
public class AtoiTest {

    private Atoi atoi = new Atoi();

    @Test
    public void test1() {
        assertEquals(10, atoi.atoi("10"));
    }

    @Test
    public void test2() {
        assertEquals(1, atoi.atoi("1"));
    }

    @Test
    public void test3() {
        assertEquals(Integer.MAX_VALUE, atoi.atoi("123123123123123"));
    }

    @Test
    public void test4() {
        assertEquals(1, atoi.atoi("1.0"));
    }

}
