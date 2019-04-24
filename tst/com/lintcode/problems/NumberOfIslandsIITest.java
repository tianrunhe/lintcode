package com.lintcode.problems;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class NumberOfIslandsIITest {
    NumberOfIslandsII ni = new NumberOfIslandsII();

    @Test
    public void test1()
    {
        NumberOfIslandsII.Point[] points = new NumberOfIslandsII.Point[] {
                new NumberOfIslandsII.Point(1,1),
                new NumberOfIslandsII.Point(0,1),
                new NumberOfIslandsII.Point(3,3),
                new NumberOfIslandsII.Point(3,4)
        };
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(1);
        expected.add(2);
        expected.add(2);
        assertEquals(expected, ni.numIslands2(4, 5, points));
    }

    @Test
    public void test2()
    {
        NumberOfIslandsII.Point[] points = new NumberOfIslandsII.Point[] {
                new NumberOfIslandsII.Point(0,0),
                new NumberOfIslandsII.Point(0,1),
                new NumberOfIslandsII.Point(2,2),
                new NumberOfIslandsII.Point(2,1)
        };
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(1);
        expected.add(2);
        expected.add(2);
        assertEquals(expected, ni.numIslands2(3, 3, points));
    }

    @Test
    public void test3()
    {
        List<Integer> expected = new ArrayList<Integer>();
        assertEquals(expected, ni.numIslands2(1, 1, null));
    }

    @Test
    public void test4()
    {
        NumberOfIslandsII.Point[] points = new NumberOfIslandsII.Point[] {
                new NumberOfIslandsII.Point(1,1),
                new NumberOfIslandsII.Point(1,2),
                new NumberOfIslandsII.Point(1,3),
                new NumberOfIslandsII.Point(1,4)
        };
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(1);
        expected.add(1);
        expected.add(1);
        assertEquals(expected, ni.numIslands2(4, 5, points));
    }
}
