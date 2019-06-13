package com.lintcode.problems;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ThreeSumTest {

    private ThreeSum threeSum = new ThreeSum();

    /**
     * Example 1:
     *
     * Input:[2,7,11,15]
     * Output:[]
     */
    @Test
    public void test1() {
        assertEquals(Lists.newArrayList(), threeSum.threeSum(new int[] {2, 7, 11, 15}));
    }

    /**
     * Example 2:
     *
     * Input:[-1,0,1,2,-1,-4]
     * Output:[[-1, 0, 1],[-1, -1, 2]]
     */
    @Test
    public void test2() {
        Set<List<Integer>> expected = Sets.newHashSet(
                Lists.newArrayList(-1, 0, 1),
                Lists.newArrayList(-1, -1, 2)
        );
        assertEquals(expected, Sets.newHashSet(threeSum.threeSum(new int[] {-1, 0, 1, 2, -1, -4})));
    }
}
