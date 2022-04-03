package io.codingtest.codility.lesson6;

import java.util.Arrays;

public class MaxProductOfThree {

    public static void main(String[] args) {
        int[] input = new int[]{-3, 1, 2, -2, 5, 6};
        int output = new MaxProductOfThree().solution(input);
        System.out.println(output);
    }

    public int solution(int[] A) {
        Arrays.sort(A);
        return Math.max(A[A.length - 1] * A[A.length - 2] * A[A.length - 3], A[A.length - 1] * A[0] * A[1]);
    }
}