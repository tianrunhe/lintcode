package com.lintcode.problems;

/**
 * For a given source string and a target string, 
 * you should output the first index(from 0) of target string in source string.
 * If target does not exist in source, just return -1.
 *
 */
public class StrStr {

    /**
     * @param source: 
     * @param target: 
     * @return: return the index
     */
    public int strStr(String source, String target) {
        for (int i = 0; ; ++i) {
            for (int j = 0; ; ++j) {
                if (j == target.length()) return i;
                if (i + j == source.length()) return -1;
                if (source.charAt(i + j) != target.charAt(j)) break;
            }
        }
    }
}
