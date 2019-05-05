package com.lintcode.problems;

/**
 * Compare two strings A and B, determine whether A contains all of the characters in B.
 * The characters in string A and B are all Upper Case letters.
 *
 */
public class CompareStrings {

    /**
     * Example
     * For A = "ABCD", B = "ACD", return true.
     * For A = "ABCD", B = "AABC", return false.
     */

    /**
     * @param A: A string
     * @param B: A string
     * @return: if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        int[] chars = new int[26];
        A.chars().forEach(c -> chars[c - 'A']++);
        return !B.chars()
                 .anyMatch(c -> --chars[c - 'A'] < 0);
    }
}
