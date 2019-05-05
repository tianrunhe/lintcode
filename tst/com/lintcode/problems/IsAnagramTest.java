package com.lintcode.problems;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Example 1:

Input: s = "ab", t = "ab"
Output: true
Example 2:

Input:  s = "abcd", t = "dcba"
Output: true
Example 3:

Input:  s = "ac", t = "ab"
Output: false

 *
 */
public class IsAnagramTest {

    private IsAnagram ia = new IsAnagram();

    @Test
    public void test() {
        assertTrue(ia.isAnagram("ab", "ab"));
        assertTrue(ia.isAnagram("abcd", "dcba"));
        assertFalse(ia.isAnagram("ac", "ab"));
    }
}
