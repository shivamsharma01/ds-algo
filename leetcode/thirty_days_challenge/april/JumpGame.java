package leetcode.thirty_days_challenge.april;

public class JumpGame {
	public boolean canJump(int[] nums) {
		if (nums.length == 1)
			return true;
		for (int i = 0, forwardCounter = 0; i < nums.length - 1; i++) {
			if (nums[i] == 0 && forwardCounter == 0)
				return false;
			else if (nums[i] == 0) {
				forwardCounter--;
			} else {
				forwardCounter = Math.max(nums[i] - 1, forwardCounter - 1);
			}
		}
		return true;
	}
}
