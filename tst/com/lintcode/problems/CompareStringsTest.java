package com.lintcode.problems;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CompareStringsTest {

    private CompareStrings cs = new CompareStrings();

    @Test
    public void test() {
        assertTrue(cs.compareStrings("ABCD", "ACD"));
        assertFalse(cs.compareStrings("ABCD", "AABC"));
    }
}
