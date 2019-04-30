package com.lintcode.problems;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WordSearchTest {

    private WordSearch ws = new WordSearch();

    @Test
    public void test1() {
        char[][] board = new char[][] {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        assertTrue(ws.exist(board, "ABCCED"));
    }

    @Test
    public void test2() {
        char[][] board = new char[][] {
            {'z'}
        };
        assertTrue(ws.exist(board, "z"));
    }
}
