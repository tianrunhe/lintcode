package com.lintcode.problems;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TrieTest {
	
	@Test
	public void test1() {
		Trie trie = new Trie();
		trie.insert("lintcode");
		assertFalse(trie.search("lint"));
		assertTrue(trie.startsWith("lint"));
	}
	
	@Test
	public void test2() {
		Trie trie = new Trie();
		trie.insert("lintcode");
		assertFalse(trie.search("code"));
		assertTrue(trie.startsWith("lint"));
		assertFalse(trie.startsWith("linterror"));
		trie.insert("linterror");
		assertTrue(trie.search("lintcode"));
		assertTrue(trie.startsWith("linterror"));
	}
}
