package com.lintcode.problems;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lintcode.problems.TrieService.TrieNode;

public class TrieServiceTest {

    private TrieService ts = new TrieService();

    @Test
    public void test1() {
        ts.insert("abc", 2);
        ts.insert("ac", 4);
        ts.insert("ab", 9);

        TrieNode root = ts.getRoot();
        List<Integer> expected = new ArrayList<>();
        expected.add(9);
        expected.add(4);
        expected.add(2);
        assertEquals(expected, root.children.get('a').top10);
    }
}
