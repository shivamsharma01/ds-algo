package prepbytes.topic.array;

import java.io.IOException;
import java.util.Scanner;

public class LowerAndUpperTriangularMatrices {
	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		int[][] arr = new int[m][n];
		StringBuilder upperTriangular = new StringBuilder("");
		StringBuilder lowerTriangular = new StringBuilder("");
		for (int row = 0; row < m; row++) {
			for (int column = 0; column < n; column++) {
				arr[row][column] = scan.nextInt();
				if (row > column) {
					upperTriangular.append(0 + " ");
					lowerTriangular.append(arr[row][column] + " ");
				} else if (column > row) {
					upperTriangular.append(arr[row][column] + " ");
					lowerTriangular.append(0 + " ");
				} else {
					upperTriangular.append(arr[row][column] + " ");
					lowerTriangular.append(arr[row][column] + " ");
				}
			}
			upperTriangular.deleteCharAt(upperTriangular.lastIndexOf(" "));
			lowerTriangular.deleteCharAt(lowerTriangular.lastIndexOf(" "));
			upperTriangular.append("\n");
			lowerTriangular.append("\n");
		}
		System.out.print(lowerTriangular);
		System.out.println(upperTriangular);
	}
}
