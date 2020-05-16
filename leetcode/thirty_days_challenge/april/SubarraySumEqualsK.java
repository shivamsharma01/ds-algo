package leetcode.thirty_days_challenge.april;

public class SubarraySumEqualsK {
	public static void main(String[] args) {
		System.out.println(subarraySum(new int[] { 1, -2, 1, 8, 6 -3 }, 8));
	}

	public static int subarraySum(int[] nums, int k) {
		int count = 0;
		int[] matrix = new int[nums.length];
		matrix[0] = nums[0];
		if (matrix[0] == k)
			count++;
		for (int i = 1; i < matrix.length; i++) {
			matrix[i] = matrix[i - 1] + nums[i];
			if (nums[i] == k)
				count++;
			if (matrix[i] == k)
				count++;
		}
		for (int i = 1; i < matrix.length - 1; i++) {
			for (int j = i + 1; j < matrix.length; j++) {
				if (matrix[j] - matrix[i - 1] == k)
					count++;
			}
		}
		return count;
	}
}
