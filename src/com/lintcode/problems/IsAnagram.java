package com.lintcode.problems;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        s.codePoints().forEach(index -> {
            counter[index - 'a']++;
        });
        return !t.codePoints()
                .filter(index -> {
                    return --counter[index - 'a'] < 0;
                })
                .findFirst()
                .isPresent();
    }
}
