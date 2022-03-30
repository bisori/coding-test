package io.codingtest.codility.lesson5;

public class PassingCars {

    public static void main(String[] args) {
        int[] input = new int[]{0, 1, 0, 1, 1};
        int output = new PassingCars().solution(input);
        System.out.println(output);
    }

    public int solution(int[] A) {
        int sum = 0;
        int countOfP = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                countOfP++;
            } else {
                sum += countOfP;
            }
            if (1000000000 < sum) {
                return -1;
            }
        }
        return sum;
    }
}
