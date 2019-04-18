package com.lintcode.problems;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidTreeTest {
	private ValidTree vt = new ValidTree();
	
	@Test
	public void test1() {
		assertTrue(vt.validTree(5, new int[][] {
			{0,1}, {0,2}, {0,3}, {1,4}
		}));
	}
	
	@Test
	public void test2() {
		assertFalse(vt.validTree(5, new int[][] {
			{0,1}, {1,2}, {2,3}, {1,3}, {1,4}
		}));
	}
	
	@Test
	public void test3() {
		assertFalse(vt.validTree(2, new int[][] {{}}));
	}
	
	@Test
	public void test4() {
		assertFalse(vt.validTree(3, new int[][] {{0, 1}}));
	}
}
