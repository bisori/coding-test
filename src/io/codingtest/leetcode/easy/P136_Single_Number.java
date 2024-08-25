package io.codingtest.leetcode.easy;

public class P136_Single_Number {

	public static void main(String[] args) {
		P136_Single_Number solution = new P136_Single_Number();
		System.out.println(solution.singleNumber_xor(new int[] {2, 2, 1}));
		System.out.println(solution.singleNumber_xor(new int[] {4, 1, 2, 1, 2}));
		System.out.println(solution.singleNumber_xor(new int[] {1}));
	}

	public int singleNumber_xor(int[] nums) {
		int res=0;
		for (int num : nums) {
			res ^= num;
		}
		return res;
	}

	public int singleNumber(int[] nums) {
		// -30000, -29999, ... , 0 , 29999, 30000
		int[] check = new int[6 * 10000+1];

		for (int i = 0; i < nums.length; i++) {
			int number = nums[i] + 30000;
			check[number]++;
		}

		for (int i = 0; i < check.length; i++) {
			if (check[i] == 1) {
				return i - 30000;
			}
		}
		return -1;
	}
}
