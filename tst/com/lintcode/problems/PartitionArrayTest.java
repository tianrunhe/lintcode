package com.lintcode.problems;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PartitionArrayTest {

    private PartitionArray partitionArray = new PartitionArray();

    /**
     * Example 1:
     *
     * Input:
     * [],9
     * Output:
     * 0
     */
    @Test
    public void test1() {
        assertEquals(0, partitionArray.partitionArray(new int[]{}, 9));
    }

    /**
     * Example 2:
     *
     * Input:
     * [3,2,2,1],2
     * Output:1
     * Explanation:
     * the real array is[1,2,2,3].So return 1
     */
    @Test
    public void test2() {
        assertEquals(1, partitionArray.partitionArray(new int[] {3,2,2,1}, 2));
    }
}
