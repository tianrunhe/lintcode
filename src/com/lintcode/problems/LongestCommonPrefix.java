package com.lintcode.problems;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        final int shortestLength = Arrays.stream(strs)
                .mapToInt(String::length)
                .min()
                .orElse(0);
        return IntStream.rangeClosed(1, shortestLength)
                 .boxed()
                 .map(i -> shortestLength + 1 - i)
                 .map(size -> Arrays.stream(strs)
                                    .map(str -> str.substring(0, size))
                                    .collect(Collectors.toSet())
                     )
                 .filter(candidates -> candidates.size() == 1)
                 .map(set -> set.iterator().next())
                 .findFirst()
                 .orElse("");
    }
}
