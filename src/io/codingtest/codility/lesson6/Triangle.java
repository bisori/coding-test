package io.codingtest.codility.lesson6;

import java.util.Arrays;

public class Triangle {

    public static void main(String[] args) {
        int[] input = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE };
        int output = new Triangle().solution(input);
        System.out.println(output);
    }

    public int solution(int[] A) {
        Arrays.sort(A);

        for (int i = A.length-1; i >= 2; i--) {
            if ((double) A[i] < (double)A[i - 1] + (double)A[i - 2]) {
                return 1;
            }
        }
        return 0;
    }
}
