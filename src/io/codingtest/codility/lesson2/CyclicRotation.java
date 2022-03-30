package io.codingtest.codility.lesson2;

import static io.codingtest.TestUtil.*;

public class CyclicRotation {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
        int[] output = new CyclicRotation().solution(input, 2);
        printArray(output);
    }

    public int[] solution(int[] A, int K) {
        if (A.length == 0) {
            return A;
        }
        int move = K % A.length;
        if (move == 0) {
            return A;
        }

        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int newIndex = (i + move) < A.length ? i + move : i + move - A.length;
            result[newIndex] = A[i];
        }
        return result;
    }


}
