package leetcode.thirty_days_challenge.may;

public class CountSquareSubmatricesWithAllOnes {

	public static void main(String[] args) {
		System.out.println(new CountSquareSubmatricesWithAllOnes()
				.countSquares(new int[][] { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } }));
		System.out.println(new CountSquareSubmatricesWithAllOnes().countSquares(
				new int[][] { { 1, 0, 1, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 1, 0, 1, 1 }, { 1, 0, 0, 1, 1 } }));
	}

	public int countSquares(int[][] matrix) {
		int[][] store = new int[matrix.length + 1][matrix[0].length + 1];
		int count = 0;
		for (int i = 1; i <= matrix.length; i++) {
			for (int j = 1; j <= matrix[0].length; j++) {
				if (matrix[i - 1][j - 1] != 0)
					count += (store[i][j] = Math.min(store[i - 1][j - 1], Math.min(store[i - 1][j], store[i][j - 1]))
							+ 1);
			}
		}
		return count;
	}

}
