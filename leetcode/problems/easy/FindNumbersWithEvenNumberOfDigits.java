package leetcode.problems.easy;

// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
public class FindNumbersWithEvenNumberOfDigits {

	public static void main(String[] args) {
		System.out.println(new FindNumbersWithEvenNumberOfDigits().findNumbers(new int[] { 12, 345, 2, 6, 7896 }));
	}

	public int findNumbers(int[] nums) {
		int ans = 0;

		for (int num : nums) {
			if (num == 100000) {
				ans++;
			} else if (num >= 10000) {

			} else if (num >= 1000) {
				ans++;
			} else if (num >= 100) {

			} else if (num >= 10) {
				ans++;
			}
		}
		return ans;
	}

}
