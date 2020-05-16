package leetcode.thirty_days_challenge.april;

public class LongestCommonSubsequence {
	public int longestCommonSubsequence(String text1, String text2) {
		int[][] matrix = new int[text1.length() + 1][text2.length() + 1];
		char a;
		for (int i = 1; i <= text1.length(); i++) {
			a = text1.charAt(i - 1);
			for (int j = 1; j <= text2.length(); j++) {
				if (text2.charAt(j - 1) == a)
					matrix[i][j] = matrix[i - 1][j - 1] + 1;
				else
					matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
			}
		}
		return matrix[text1.length()][text2.length()];
	}
}
