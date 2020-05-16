package leetcode.thirty_days_challenge.april;

public class NumberOfIslands {
	public static void main(String[] args) {
		NumberOfIslands obj = new NumberOfIslands();
		char[][] matrix = null;
//		matrix = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
//			{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
//		matrix = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
//			{ '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } };
		matrix = new char[][] { { '1', '1', '1' }, { '0', '1', '0' }, { '1', '1', '1', } };

		System.out.println(obj.numIslands(matrix));
		for (

				int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(Character.toString(matrix[i][j]) + '\t');
			}
			System.out.println();
		}
	}

	public int numIslands(char[][] grid) {
		int count = 0;
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					checkAndupdateNeighbours(grid, i, j, visited);
					count++;
				}
			}
		}
		return count;
	}

	private void checkAndupdateNeighbours(char[][] grid, int i, int j, boolean[][] visited) {
		if (grid[i][j] == '0' || visited[i][j]) {
			return;
		}
		visited[i][j] = true;
		if (i - 1 >= 0) {
			checkAndupdateNeighbours(grid, i - 1, j, visited);
		}
		if (j - 1 >= 0) {
			checkAndupdateNeighbours(grid, i, j - 1, visited);
		}
		if (j + 1 < grid[i].length) {
			checkAndupdateNeighbours(grid, i, j + 1, visited);
		}
		if (i + 1 < grid.length) {
			checkAndupdateNeighbours(grid, i + 1, j, visited);
		}
	}

}
