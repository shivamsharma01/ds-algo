package leetcode.problems.easy;

// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
public class CountNegativeNumbersInASortedMatrix {

	public static void main(String[] args) {
		System.out.println(new CountNegativeNumbersInASortedMatrix().countNegatives(
				new int[][] { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } }));
	}

	public int countNegatives(int[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = grid[i].length - 1; j >= 0 && grid[i][j] < 0; j--) {
				count++;
			}
		}
		return count;
	}
}
