package io.codingtest.codility.lesson4;

import java.util.HashSet;
import java.util.Set;

public class PermCheck {

    public static void main(String[] args) {
        int[] input = new int[]{4, 1, 3, 2};
        int output = new PermCheck().solution(input);
        System.out.println(output);
    }

    public int solution(int[] A) {
        int sumOfIndex = 0;
        int sumOfA = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            sumOfIndex += (i+1);
            sumOfA += A[i];
            set.add(A[i]);
        }
        return (sumOfIndex == sumOfA && A.length == set.size()) ? 1 : 0;
    }
}
