package com.lintcode.problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConnectingGraph2Test {
	@Test
	public void Test1() {
		ConnectingGraph2 cg2 = new ConnectingGraph2(5);
		assertEquals(1, cg2.query(1));
		cg2.connect(1, 2);
		assertEquals(2, cg2.query(1));
		cg2.connect(2, 4);
		assertEquals(3, cg2.query(1));
		cg2.connect(1, 4);
		assertEquals(3, cg2.query(1));
	}
	
	@Test
	public void Test2() {
		ConnectingGraph2 cg2 = new ConnectingGraph2(6);
		assertEquals(1, cg2.query(1));
		assertEquals(1, cg2.query(2));
		assertEquals(1, cg2.query(1));
		assertEquals(1, cg2.query(5));
		assertEquals(1, cg2.query(1));
	}
}
