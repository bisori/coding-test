package io.codingtest.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class P118_Pascals_Triangle {

	public static void main(String[] args) {
		var result = generate(5);
		System.out.println(result);
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> dp = new ArrayList<>();

		int i = 0;
		while (i < numRows) {
			if (i == 0) {
				dp.add(List.of(1));
			} else {
				List<Integer> numbers = new ArrayList<>();
				List<Integer> upper = dp.get(i - 1);

				for (int j = 0; j <= i; j++) {
					if (j == 0 || j == i) {
						numbers.add(1);
					} else {
						numbers.add(upper.get(j - 1) + upper.get(j));
					}
				}
				dp.add(numbers);
			}
			i++;
		}

		return dp;
	}
}
