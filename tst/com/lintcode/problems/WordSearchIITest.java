package com.lintcode.problems;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class WordSearchIITest {

    private WordSearchII ws = new WordSearchII();

    /**
     * Input：["doaf","agai","dcan"]，["dog","dad","dgdg","can","again"]
     * Output：["again","can","dad","dog"]
     */
    @Test
    public void test1() {
        char[][] board = new char[][] {
            {'d', 'o', 'a', 'f'},
            {'a', 'g', 'a', 'i'},
            {'d', 'c', 'a', 'n'}
        };
        List<String> words = new ArrayList<String>();
        words.add("dog");
        words.add("dad");
        words.add("dgdg");
        words.add("can");
        words.add("again");
        List<String> expected = new ArrayList<String>();
        expected.add("again");
        expected.add("can");
        expected.add("dad");
        expected.add("dog");
        List<String> output = ws.wordSearchII(board, words);
        Collections.sort(expected);
        Collections.sort(output);
        assertEquals(expected, output);
    }

    /**
     * Input：["a"]，["b"]
     * Output：[]
     */
    @Test
    public void test2() {
        char[][] board = new char[][] {
            {'a'}
        };
        List<String> words = new ArrayList<String>();
        words.add("b");
        List<String> expected = new ArrayList<String>();
        List<String> output = ws.wordSearchII(board, words);
        Collections.sort(expected);
        Collections.sort(output);
        assertEquals(expected, output);
    }

    /**
     * ["b","a","b","b","a"]
     * ["babbab","b","a","ba"]
     */
    @Test
    public void test3() {
        char[][] board = new char[][] {
            {'b'},
            {'a'},
            {'b'},
            {'b'},
            {'a'}
        };
        List<String> words = new ArrayList<String>();
        words.add("babbab");
        words.add("b");
        words.add("a");
        words.add("ba");
        List<String> expected = new ArrayList<String>();
        expected.add("a");
        expected.add("b");
        expected.add("ba");
        List<String> output = ws.wordSearchII(board, words);
        Collections.sort(expected);
        Collections.sort(output);
        assertEquals(expected, output);
    }

    /**
     * ["abce","sfcs","adee"]
     * ["see","se"]
     */
    @Test
    public void test4() {
        char[][] board = new char[][] {
            {'a', 'b', 'c', 'e'},
            {'s', 'f', 'c', 's'},
            {'a', 'd', 'e', 'e'}
        };
        List<String> words = new ArrayList<String>();
        words.add("see");
        words.add("se");
        List<String> expected = new ArrayList<String>();
        expected.add("se");
        expected.add("see");
        List<String> output = ws.wordSearchII(board, words);
        Collections.sort(expected);
        Collections.sort(output);
        assertEquals(expected, output);
    }

    /**
     * ["abce","sfes","adee"]
     * ["abceseeefs","abceseedasfe"]
     */
    @Test
    public void test5() {
        char[][] board = new char[][] {
            {'a', 'b', 'c', 'e'},
            {'s', 'f', 'e', 's'},
            {'a', 'd', 'e', 'e'}
        };
        List<String> words = new ArrayList<String>();
        words.add("abceseeefs");
        words.add("abceseedasfe");
        List<String> expected = new ArrayList<String>();
        expected.add("abceseeefs");
        expected.add("abceseedasfe");
        List<String> output = ws.wordSearchII(board, words);
        Collections.sort(expected);
        Collections.sort(output);
        assertEquals(expected, output);
    }
}
