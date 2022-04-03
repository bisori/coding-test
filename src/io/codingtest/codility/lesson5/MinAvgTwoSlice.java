package io.codingtest.codility.lesson5;

import io.codingtest.TestUtil;

public class MinAvgTwoSlice {

    public static void main(String[] args) {
        MinAvgTwoSlice solution = new MinAvgTwoSlice();
        solution.testWith(new int[]{-3, -5, -8, -4, -10});
    }

    private void testWith(int[] input) {
        TestUtil.printArray(input);
        int output = new MinAvgTwoSlice().solution(input);
        System.out.println(" >> " + output);
    }

    public int solution(int[] A) {
        return 1;
    }
}
