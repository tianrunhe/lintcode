package com.lintcode.problems;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        final int longestLength = Arrays.stream(strs)
                .mapToInt(String::length)
                .max()
                .orElse(0);
        return IntStream.rangeClosed(0, longestLength)
                 .boxed()
                 .map(i -> longestLength + 1 - i)
                 .map(size -> Arrays.stream(strs)
                                    .filter(str -> str.length() >= size)
                                    .map(str -> str.substring(0, size))
                                    .collect(Collectors.toList())
                     )
                 .filter(candidates -> candidates.size() == strs.length)
                 .filter(candidates -> candidates.stream().distinct().count() == 1)
                 .map(list -> list.get(0))
                 .findFirst()
                 .orElse("");
    }
}
