package leetcode.problems.medium;

public class UniquePaths {

	public int uniquePaths(int m, int n) {
		return getCombinations(m, n);
	}

	private int getCombinations(int m, int n) {
		long sum = --m + --n;

		int min = Math.min(m, n);
		int max = Math.max(m, n);
		if (min == 0)
			return 1;

		for (int i = (int) (sum - 1); i > max; i--)
			sum *= i;
		for (int i = min - 1; i >= 2; i--)
			min *= i;

		return (int) (sum / min);
	}

}
