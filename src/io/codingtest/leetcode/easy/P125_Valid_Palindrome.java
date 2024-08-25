package io.codingtest.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P125_Valid_Palindrome {

	public static void main(String[] args) {
		P125_Valid_Palindrome solution = new P125_Valid_Palindrome();
		System.out.println(solution.isPalindrome("0P"));
	}

	public boolean isPalindrome(String s) {
		List<Character> allowed = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch >= 'a' && ch <= 'z' || (ch >= '0' && ch <= '9')) {
				allowed.add(ch);
			} else if (ch >= 'A' && ch <= 'Z') {
				allowed.add((char)(ch + ('a' - 'A')));
			}
		}
		String allowedString = allowed.stream().map(Object::toString).collect(Collectors.joining());
		for (int i = 0; i < allowedString.length() / 2; i++) {
			if (allowedString.charAt(i) != allowedString.charAt(allowedString.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}