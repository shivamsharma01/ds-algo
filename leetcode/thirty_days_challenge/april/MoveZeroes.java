package leetcode.thirty_days_challenge;

public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int previousnonzeroAt = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[++previousnonzeroAt] = nums[i];
			}
		}
		previousnonzeroAt++;
		for (int i = previousnonzeroAt; i < nums.length; i++) {
			nums[i] = 0;
		}
	}
}
