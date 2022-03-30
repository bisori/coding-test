package io.codingtest.codility.lesson4;

import java.util.*;

public class FrogRiverOne {

    public static void main(String[] args) {
        int K = 3;
        int[] input = new int[]{1, 3, 1, 3, 2, 1, 3};
        int output = new FrogRiverOne().solution(K, input);
        System.out.println(output);
    }

    public int solution(int X, int[] A) {
        Set<Integer> checked = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if (A[i] <= X) {
                checked.add(A[i]);
            }
            if (checked.size() == X) {
                return i;
            }
        }
        return -1;
    }
}
