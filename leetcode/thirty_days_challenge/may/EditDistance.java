package leetcode.thirty_days_challenge.may;

public class EditDistance {
	public static void main(String[] args) {
		String a = "horse", b = "ros";
		System.out.println(editDistance(a, b, a.length(), b.length()));
	}

	private static int editDistance(String a, String b, int m, int n) {
		if (m == 0)
			return n;
		if (n == 0)
			return m;
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0)
					dp[i][j] = j;
				else if (j == 0)
					dp[i][j] = i;
				else if (a.charAt(i - 1) == b.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
			}
		}
		return dp[m][n];
	}

	public int minDistance(String word1, String word2) {
		return editDistance(word1, word2, word1.length(), word2.length());
	}

	private static int min(int x, int y, int z) {
		return x <= y ? x <= z ? x : z : y <= z ? y : z;
	}
}
