package leetcode.Array101;

public class DuplicateZeroes {
	public static void main(String[] args) {
		new DuplicateZeroes().duplicateZeros(new int[] { 1, 0, 2, 3, 0, 4, 5, 0 });
		new DuplicateZeroes().duplicateZeros(new int[] { 0, 0, 0, 1, 2, 3, 4 });
		new DuplicateZeroes().duplicateZeros(new int[] { 0, 0, 0, 0, 0, 0, 0 });
		new DuplicateZeroes().duplicateZeros(new int[] { 0, 1, 7, 6, 0, 2, 0, 7 });
		new DuplicateZeroes().duplicateZeros(new int[] { 8, 4, 5, 0, 0, 0, 0, 7 });
		new DuplicateZeroes().duplicateZeros(new int[] { 9, 9, 9, 4, 8, 0, 0, 3, 7, 2, 0, 0, 0, 0, 9, 1, 0, 0, 1, 1, 0,
				5, 6, 3, 1, 6, 0, 0, 2, 3, 4, 7, 0, 3, 9, 3, 6, 5, 8, 9, 1, 1, 3, 2, 0, 0, 7, 3, 3, 0, 5, 7, 0, 8, 1, 9,
				6, 3, 0, 8, 8, 8, 8, 0, 0, 5, 0, 0, 0, 3, 7, 7, 7, 7, 5, 1, 0, 0, 8, 0, 0 });
		new DuplicateZeroes().duplicateZeros(new int[] { 1, 5, 2, 0, 6, 8, 0, 6, 0 });
	}

	public void duplicateZeros(int[] arr) {
		int zeroCount = 0, i = 0;
		for (; i < arr.length; i++) {
			if (zeroCount + i == arr.length - 1) {
				arr[i + zeroCount] = arr[i];
				i--;
				break;
			}
			if (arr[i] == 0)
				zeroCount++;
			if (zeroCount + i == arr.length - 1) {
				arr[i + zeroCount] = arr[i];
				if (arr[i] == 0) {
					arr[i + zeroCount - 1] = 0;
					zeroCount--;
				}
				i--;
				break;
			}
		}
	}

}
