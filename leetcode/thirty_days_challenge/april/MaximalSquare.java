package leetcode.thirty_days_challenge.april;

public class MaximalSquare {
	public static void main(String[] args) {
		char[][] a = null;

		a = new char[][] { { '0', '0', '1', '0' }, { '1', '1', '1', '1' }, { '1', '1', '1', '1' },
				{ '1', '1', '1', '0' }, { '1', '1', '0', '0' }, { '1', '1', '1', '1' }, { '1', '1', '1', '0' } };

		// System.out.println(maximalSquare(a));

		System.out.println(maximalSquare(a));
	}

	public static int maximalSquare(char[][] matrix) {
		int m = matrix.length, n, max = 0, val;
		if (m == 0)
			return 0;
		n = matrix[0].length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			val = matrix[i][0] - '0';
			if (val == 1)
				dp[i][0] = 1;
			if (max < val)
				max = val;
		}
		for (int j = 0; j < n; j++) {
			val = matrix[0][j] - '0';
			if (val == 1)
				dp[0][j] = 1;
			if (max < val)
				max = val;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1, e; j < n; j++) {
				if (matrix[i][j] == '0')
					e = 0;
				else
					e = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
				dp[i][j] = e;
				if (e > max)
					max = e;
			}
		}
		return max * max;
	}

}
