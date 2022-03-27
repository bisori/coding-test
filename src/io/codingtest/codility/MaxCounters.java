package io.codingtest.codility;

import io.codingtest.TestUtil;

public class MaxCounters {

    public static void main(String[] args) {
        int N = 5;
        int[] A = new int[]{3, 4, 4, 6, 1, 4, 4};
        int[] output = new MaxCounters().solution(N, A);
        TestUtil.printArray(output);
    }

    public int[] solution(int N, int[] A) {
        int[] result = new int[N];
        int max = -1;
        int lastMax = max;
        for (int number : A) {
            if (number == N + 1) {
                lastMax = max;
            } else {
                if (result[number - 1] < lastMax) {
                    result[number - 1] = lastMax;
                }
                result[number - 1] += 1;
                max = Math.max(max, result[number - 1]);
            }
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i] < lastMax) {
                result[i] = lastMax;
            }
        }
        return result;
    }
}
