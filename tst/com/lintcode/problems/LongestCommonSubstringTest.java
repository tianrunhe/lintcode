package com.lintcode.problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestCommonSubstringTest {

    private final LongestCommonSubstring lcs = new LongestCommonSubstring();

    @Test
    public void test1() {
        assertEquals(2, lcs.longestCommonSubstring("ABCD", "CBCE"));
    }

    @Test
    public void test2() {
        assertEquals(1, lcs.longestCommonSubstring("ABCD", "EACB"));
    }

}
