package leetcode.problems.easy;

import java.util.Arrays;

// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number
public class HowManyNumbersAreSmallerThanTheCurrentNumber {
	public static void main(String[] args) {
		HowManyNumbersAreSmallerThanTheCurrentNumber o = new HowManyNumbersAreSmallerThanTheCurrentNumber();
		int[] a = o.smallerNumbersThanCurrent(new int[] { 8, 1, 2, 2, 3 });
		for (int i : a)
			System.out.print(i + " ");
	}

	public int[] smallerNumbersThanCurrent(int[] nums) {
		int max = Arrays.stream(nums).max().getAsInt();
		int[] count = new int[max + 1];
		for (int i : nums) {
			count[i]++;
		}
		for (int i = 1; i <= max; i++) {
			count[i] += count[i - 1];
		}
		return Arrays.stream(nums).map(e -> e == 0 ? 0 : count[e - 1]).toArray();
	}
}
