package io.codingtest.codility;

import java.util.Arrays;

public class MissingInteger {

    public static void main(String[] args) {
        int[] input = new int[]{1, 3, 6, 4, 1, 2};
        int output = new MissingInteger().solution(input);
        System.out.println(output);
    }

    public int solution(int[] A) {
        int[] array = Arrays.stream(A)
          .filter(a -> a > 0)
          .sorted()
          .toArray();

        if(array.length == 0 || array[0] > 1){
            return 1;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] - array[i] > 1) {
                return array[i] + 1;
            }
        }
        return array[A.length - 1] + 1;
    }
}
