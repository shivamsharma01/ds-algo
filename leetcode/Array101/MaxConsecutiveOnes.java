package leetcode.Array101;

public class MaxConsecutiveOnes {

	public int findMaxConsecutiveOnes(int[] nums) {
		int max = 0, currentMax = 0;
		for (int i : nums) {
			if (i == 1) {
				currentMax++;
				max = Math.max(max, currentMax);
			} else
				currentMax = 0;
		}
		return max;
	}

}