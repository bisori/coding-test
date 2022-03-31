package io.codingtest.codility.lesson5;

public class CountDiv {

    public static void main(String[] args) {
        new CountDiv()
          .testWith(6, 11, 2)
          .testWith(11, 345, 17)
          .testWith(0, 0, 11)
          .testWith(1, 1, 11)
          .testWith(10, 10, 5)
          .testWith(10, 10, 7)
          .testWith(10, 10, 20)
          .testWith(100, 123000000,     2)
          .testWith(101, 123000000, 10000)
          .testWith(0, 2000000000, 1)
          .testWith(0, 2000000000, 2000000000)
          .testWith(1, 2000000000, 2000000000);
    }

    private CountDiv testWith(int A, int B, int K) {
        System.out.println("A= " + A + " ,B= " + B + ", K= " + K);
        int output = solution(A, B, K);
        System.out.println(output);
        return this;
    }

    public int solution(int A, int B, int K) {
        int count = (A == 0) ? 1 : 0;

        if (A == B) {
            return A % K == count ? 1 : count;
        }

        if (B - A < K) {
            return K >= A && K <= B ? 1 : count;
        }

        if (B - A == K) {
            return 2;
        }
        return ((B - A) / K) + 1;
    }
}
