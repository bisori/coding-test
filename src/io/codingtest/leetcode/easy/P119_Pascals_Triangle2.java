package io.codingtest.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class P119_Pascals_Triangle2 {

	public static void main(String[] args) {
		var result = getRow(3);
		System.out.println(result);
	}

	public static List<Integer> getRow(int rowIndex) {
		List<List<Integer>> dp = new ArrayList<>();

		dp.add(List.of(1));
		for (int i = 1; i <= rowIndex; i++) {
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

		return dp.get(rowIndex);
	}
}
