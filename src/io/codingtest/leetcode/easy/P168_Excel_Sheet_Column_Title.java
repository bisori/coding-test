package io.codingtest.leetcode.easy;

public class P168_Excel_Sheet_Column_Title {

	public static void main(String[] args) {
		P168_Excel_Sheet_Column_Title solution = new P168_Excel_Sheet_Column_Title();
		System.out.println(solution.convertToTitle(1));
		System.out.println(solution.convertToTitle(28));
		System.out.println(solution.convertToTitle(701));
	}

	public String convertToTitle(int columnNumber) {
		int numberOfAlphabets = ('Z' - 'A' + 1);

		StringBuilder result = new StringBuilder();
		for (int current = columnNumber; current > 0; current /= numberOfAlphabets) {
			current--;
			result.append((char)('A' + current % numberOfAlphabets));
		}
		return result.reverse().toString();
	}
}
