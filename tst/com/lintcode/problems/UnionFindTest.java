package com.lintcode.problems;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class UnionFindTest {
	@Test
	public void test() {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= 5; ++i) {
			list.add(i);
		}
		UnionFind<Integer> cg = new UnionFind<Integer>(list);
		cg.query(1, 2);
		cg.connect(1, 2);
		cg.query(1, 3);
		cg.connect(2, 4);
		cg.query(1, 4);
	}
}
