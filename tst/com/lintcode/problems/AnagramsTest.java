package com.lintcode.problems;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class AnagramsTest {

    private Anagrams anagrams = new Anagrams();

    /**
     * Input:["lint", "intl", "inlt", "code"]
     * Output:["lint", "inlt", "intl"]
     */
    @Test
    public void test1() {
        String[] input = new String[] {"lint", "intl", "inlt", "code"};

        Set<String> output = new HashSet<>();
        output.add("lint");
        output.add("inlt");
        output.add("intl");

        assertEquals(output, new HashSet<>(anagrams.anagrams(input)));
    }

    /**
     * Input:["ab", "ba", "cd", "dc", "e"]
     * Output: ["ab", "ba", "cd", "dc"]
     */
    @Test
    public void test2() {
        String[] input = new String[] {"ab", "ba", "cd", "dc", "e"};

        Set<String> output = new HashSet<>();
        output.add("ab");
        output.add("ba");
        output.add("cd");
        output.add("dc");

        assertEquals(output, new HashSet<>(anagrams.anagrams(input)));
    }
}
