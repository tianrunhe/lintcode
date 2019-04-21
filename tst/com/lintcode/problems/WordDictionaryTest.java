package com.lintcode.problems;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WordDictionaryTest {

    private WordDictionary wordDictionary = new WordDictionary();

    @Test
    public void test1() {
        wordDictionary.addWord("a");
        assertTrue(wordDictionary.search("."));
    }
    
    @Test
    public void test2() {
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        assertFalse(wordDictionary.search("pad"));
        assertTrue(wordDictionary.search("bad"));
        assertTrue(wordDictionary.search(".ad"));
        assertTrue(wordDictionary.search("b.."));
    }
}
