package leetcode.thirty_days_challenge;

import java.util.List;

public class LeftMostColumnWithAtLeastAOne {
	public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		List<Integer> dimensions = binaryMatrix.dimensions();
		int row = dimensions.get(0) - 1, column = dimensions.get(1) - 1, index = -1;
		while (row >= 0 && column >= 0) {
			if (binaryMatrix.get(row, column) == 0)
				row--;
			else {
				index = column;
				column--;
			}
		}
		return index;
	}
}

// This is the BinaryMatrix's API interface.
// You should not implement it, or speculate about its implementation
interface BinaryMatrix {
	public int get(int x, int y);

	public List<Integer> dimensions();
};