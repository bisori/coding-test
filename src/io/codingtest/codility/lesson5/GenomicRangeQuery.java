package io.codingtest.codility.lesson5;

import io.codingtest.TestUtil;

public class GenomicRangeQuery {

    public static void main(String[] args) {
        GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();
        genomicRangeQuery.testWith("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6});
        genomicRangeQuery.testWith("A", new int[]{0}, new int[]{0});
    }

    public void testWith(String S, int[] P, int[] Q) {
        int[] output = new GenomicRangeQuery().solution(S, P, Q);
        TestUtil.printArray(output);
    }

    public int[] solution(String S, int[] P, int[] Q) {
        int[][] ACGT = new int[4][S.length()];

        if (S.charAt(0) == 'A') {
            ACGT[0][0] = 1;
        } else if (S.charAt(0) == 'C') {
            ACGT[1][0] = 1;
        } else if (S.charAt(0) == 'G') {
            ACGT[2][0] = 1;
        } else if (S.charAt(0) == 'T') {
            ACGT[3][0] = 1;
        }

        for (int i = 1; i < S.length(); i++) {
            switch (S.charAt(i)) {
                case 'A':
                    ACGT[0][i] = ACGT[0][i - 1] + 1;
                    ACGT[1][i] = ACGT[1][i - 1];
                    ACGT[2][i] = ACGT[2][i - 1];
                    ACGT[3][i] = ACGT[3][i - 1];
                    break;
                case 'C':
                    ACGT[0][i] = ACGT[0][i - 1];
                    ACGT[1][i] = ACGT[1][i - 1] + 1;
                    ACGT[2][i] = ACGT[2][i - 1];
                    ACGT[3][i] = ACGT[3][i - 1];
                    break;
                case 'G':
                    ACGT[0][i] = ACGT[0][i - 1];
                    ACGT[1][i] = ACGT[1][i - 1];
                    ACGT[2][i] = ACGT[2][i - 1] + 1;
                    ACGT[3][i] = ACGT[3][i - 1];
                    break;
                case 'T':
                    ACGT[0][i] = ACGT[0][i - 1];
                    ACGT[1][i] = ACGT[1][i - 1];
                    ACGT[2][i] = ACGT[2][i - 1];
                    ACGT[3][i] = ACGT[3][i - 1] + 1;
                default:
                    break;
            }
        }

        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            for (int acgt = 0; acgt < 4; acgt++) {
                int start = P[i] > 0 ? ACGT[acgt][P[i] - 1] : 0;
                int end = ACGT[acgt][Q[i]];
                if (end > start) {
                    result[i] = acgt + 1;
                    break;
                }
            }
        }
        return result;
    }

}
