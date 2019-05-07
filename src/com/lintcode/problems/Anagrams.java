package com.lintcode.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Example 1:
 * Input:["lint", "intl", "inlt", "code"]
 * Output:["lint", "inlt", "intl"]
 * 
 * Example 2:
 * Input:["ab", "ba", "cd", "dc", "e"]
 * Output: ["ab", "ba", "cd", "dc"]
 *
 */
public class Anagrams {

    public List<String> anagrams(String[] strs) {
        Map<String, List<String>> mapping =
            Arrays.stream(strs)
                .collect(
                    Collectors.groupingBy(str -> 
                        Stream.of(str.split(""))
                            .sorted()
                            .collect(Collectors.joining())
                        )
                );
        return mapping.values().stream()
                               .filter(list -> list.size() > 1)
                               .flatMap(List::stream)
                               .collect(Collectors.toList());
    }
}
