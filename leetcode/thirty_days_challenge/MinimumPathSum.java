package leetcode.thirty_days_challenge;

import java.util.Arrays;

public class MinimumPathSum {
	public static void main(String[] args) {
		MinimumPathSum obj = new MinimumPathSum();
		System.out.println(obj.minPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }));
		// System.out.println(obj.minPathSum(new int[][] { { 0, 0 }, { 0, 0 } }));
	}

	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int[][] minSum = new int[grid.length][grid[0].length];
		for (int i = 0; i < minSum.length; i++) {
			Arrays.fill(minSum[i], Integer.MAX_VALUE);
		}
		fillMinPath(grid, minSum, 0, 0, 0);
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("");
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(minSum[i][j] + " ");
			}
			System.out.println();
		}
		return minSum[minSum.length - 1][minSum[minSum.length - 1].length - 1];
	}

	private void fillMinPath(int[][] grid, int[][] minSum, int row, int column, int sum) {
		if (row < 0 || row == minSum.length || column < 0 || column == minSum[row].length) {
			return;
		}
		int minValue = minSum[row][column];
		int gridValue = grid[row][column];
		if (sum + gridValue >= minValue) {
			return;
		}
		sum += gridValue;
		minSum[row][column] = sum;
		fillMinPath(grid, minSum, row + 1, column, sum);
		fillMinPath(grid, minSum, row, column + 1, sum);
	}
}
