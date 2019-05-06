package com.lintcode.problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StrStrTest {

    private StrStr ss = new StrStr();

    /**
     * Example 1:
     * Input: source = "source" ，target = "target"
     * Output: -1
     * 
     * Example 2:
     * Input:source = "abcdabcdefg" ，target = "bcd"
     * Output: 1
     */
    @Test
    public void test() {
        assertEquals(-1, ss.strStr("source", "target"));
        assertEquals(1, ss.strStr("abcdabcdefg", "bcd"));
    }
}
