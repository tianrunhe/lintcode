package com.lintcode.problems;

import java.util.Optional;
import java.util.stream.IntStream;

public class LongestCommonSubstring {

    public int longestCommonSubstring(String A, String B) {
        return IntStream.rangeClosed(1, B.length())
                  .boxed()
                  .map(i -> B.length() + 1 - i)
                  .map(size -> IntStream.rangeClosed(0, B.length() - size)
                          .boxed()
                          .map(startIndex -> B.substring(startIndex, startIndex + size))
                          .filter(A::contains)
                          .findFirst()
                          .map(String::length)
                  )
                  .filter(Optional::isPresent)
                  .findFirst()
                  .map(Optional::get)
                  .orElse(0);
    }
}
