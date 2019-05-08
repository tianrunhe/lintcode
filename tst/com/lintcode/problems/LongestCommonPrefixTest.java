package com.lintcode.problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestCommonPrefixTest {

    private LongestCommonPrefix lcp = new LongestCommonPrefix();

    @Test
    public void test1() {
        assertEquals("A", lcp.longestCommonPrefix(new String[] {"ABCD", "ABEF", "ACEF"}));
    }

    @Test
    public void test2() {
        assertEquals("ABC", lcp.longestCommonPrefix(new String[] {"ABCDEFG", "ABCEFG", "ABCEFA"}));
    }
}
