package com.lintcode.problems;

import java.util.Arrays;

public class WordSearch {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                boolean found = exist(board, i, j, word, 0, visited);
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean exist(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (word.charAt(index) != board[i][j] || visited[i][j]) {
            return false;
        }
        boolean recursion = false;
        visited[i][j] = true;
        // up
        if (i - 1 >= 0) {
            recursion = true;
            boolean[][] visitedCopy = new boolean[board.length][board[0].length];
            for(int k = 0; k < board.length; ++k) {
                visitedCopy[k] = Arrays.copyOf(visited[k], visited[k].length);
            }
            if(exist(board, i - 1, j, word, index + 1, visitedCopy)) {
                return true;
            }
        }
        // down
        if (i + 1 < board.length) {
            recursion = true;
            boolean[][] visitedCopy = new boolean[board.length][board[0].length];
            for(int k = 0; k < board.length; ++k) {
                visitedCopy[k] = Arrays.copyOf(visited[k], visited[k].length);
            }
            if(exist(board, i + 1, j, word, index + 1, visitedCopy)) {
                return true;
            }
        }
        // left
        if (j - 1 >= 0) {
            recursion = true;
            boolean[][] visitedCopy = new boolean[board.length][board[0].length];
            for(int k = 0; k < board.length; ++k) {
                visitedCopy[k] = Arrays.copyOf(visited[k], visited[k].length);
            }
            if(exist(board, i, j - 1, word, index + 1, visitedCopy)) {
                return true;
            }
        }
        // right
        if (j + 1 < board[0].length) {
            recursion = true;
            boolean[][] visitedCopy = new boolean[board.length][board[0].length];
            for(int k = 0; k < board.length; ++k) {
                visitedCopy[k] = Arrays.copyOf(visited[k], visited[k].length);
            }
            if(exist(board, i, j + 1, word, index + 1, visitedCopy)) {
                return true;
            }
        }
        return !recursion && index + 1 == word.length();
    }
}
