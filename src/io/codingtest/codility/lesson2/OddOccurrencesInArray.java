package io.codingtest.codility.lesson2;

import java.util.Arrays;

public class OddOccurrencesInArray {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8};
        int output = new OddOccurrencesInArray().solution(input);
        System.out.println(output);
    }

    public int solution(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length - 2; i += 2) {
            if (A[i] != A[i + 1]) {
                return A[i];
            }
        }
        return A[A.length - 1];
    }
}
