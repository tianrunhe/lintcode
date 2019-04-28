package com.lintcode.problems;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class SurroundedRegionsTest {

    private SurroundedRegions sr = new SurroundedRegions();

    /**
     * Input:
  X X X X
  X O O X
  X X O X
  X O X X
Output:
  X X X X
  X X X X
  X X X X
  X O X X
     */
    @Test
    public void test1() {
        char[][] input = new char[][] {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        char[][] expected = new char[][] {
            {'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        sr.surroundedRegions(input);
        assertTrue(Arrays.deepEquals(expected, input));
    }

/**
 * Input:
  X X X X
  X O O X
  X O O X
  X O X X
Output:
  X X X X
  X O O X
  X O O X
  X O X X
 */
    @Test
    public void test2() {
        char[][] input = new char[][] {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        char[][] expected = new char[][] {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        sr.surroundedRegions(input);
        assertTrue(Arrays.deepEquals(expected, input));
    }
}
