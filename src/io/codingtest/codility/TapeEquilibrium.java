package io.codingtest.codility;

/**
 * https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
 */
public class TapeEquilibrium {

    public static void main(String[] args){
        int[] input = new int[]{-1000,1000};
        int output = new TapeEquilibrium().solution(input);
        System.out.println(output);
    }

    public int solution(int[] A) {
        int leftPart = 0;
        int rightPart = 0;
        for (int i = 0 ; i < A.length ; i++) {
            rightPart += A[i];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0 ; i < A.length-1 ; i++) {
            leftPart = leftPart + A[i];
            rightPart = rightPart - A[i];
            min = Math.min(min, Math.abs(leftPart - rightPart));
        }

        return min;
    }
}
