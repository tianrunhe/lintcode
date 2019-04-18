package com.lintcode.problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConnectingGraph3Test {

	@Test
	public void test1() {
		ConnectingGraph3 cg3 = new ConnectingGraph3(5);
		assertEquals(5, cg3.query());
		cg3.connect(1, 2);
		assertEquals(4, cg3.query());
		cg3.connect(2, 4);
		assertEquals(3, cg3.query());
		cg3.connect(1, 4);
		assertEquals(3, cg3.query());
	}
	
	@Test
	public void test2() {
		ConnectingGraph3 cg3 = new ConnectingGraph3(6);
		assertEquals(6, cg3.query());
		assertEquals(6, cg3.query());
		assertEquals(6, cg3.query());
		assertEquals(6, cg3.query());
		assertEquals(6, cg3.query());
	}
}
