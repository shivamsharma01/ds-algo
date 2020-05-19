package leetcode.problems.easy;

// https://leetcode.com/problems/flipping-an-image/
public class FlippingAnImage {

	public static void main(String[] args) {
		FlippingAnImage o = new FlippingAnImage();
		int[][] A = null;
		A = new int[][] { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } };
		o.print(A);
		o.flipAndInvertImage(A);
		o.print(A);

	}

	private void print(int[][] A) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public int[][] flipAndInvertImage(int[][] A) {
		for (int i = 0, len, temp; i < A.length; i++) {
			len = A[i].length;
			for (int j1 = 0, j2; j1 <= Math.ceil(len / (double) 2) - 1; j1++) {
				j2 = len - j1 - 1;
				temp = A[i][j1];
				if (temp == 1)
					temp = 0;
				else
					temp = 1;
				if (A[i][j2] == 1)
					A[i][j1] = 0;
				else
					A[i][j1] = 1;
				A[i][j2] = temp;
			}
		}
		return A;
	}
}
