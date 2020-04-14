package leetcode.problems;

import java.util.Arrays;

public class KEqualSubsets {
	public static boolean canPartitionKSubsets(int[] nums, int k) {
		long subsetSum = Arrays.stream(nums).sum() / k;
		return isSumPossible(nums, subsetSum, subsetSum, k, 0);
	}

	private static boolean isSumPossible(int[] arr, long sum, long remaining, int k, int index) {
		if (k == 0)
			return true;
		if (remaining < 0 || index == arr.length)
			return false;
		if (arr[index] == -1)
			return isSumPossible(arr, sum, remaining, k, index + 1);
		int val = arr[index];
		arr[index] = -1;
		if (remaining - val == 0 && isSumPossible(arr, sum, sum, k - 1, 0))
			return true;
		remaining -= val;
		if (isSumPossible(arr, sum, remaining, k, index + 1))
			return true;
		arr[index] = val;
		remaining += arr[index];
		return isSumPossible(arr, sum, remaining, k, index + 1);
	}

}
