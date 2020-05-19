package prepbytes.topic.array;

import java.io.IOException;
import java.util.Scanner;

public class OperationsOnMatrix {
	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		int[][] matrixA = new int[m][n];
		int[][] matrixB = new int[m][n];
		int[][] addition = new int[m][n];
		int[][] multiplication = new int[m][n];
		for (int row = 0; row < m; row++) {
			for (int column = 0; column < n; column++) {
				matrixA[row][column] = scan.nextInt();
			}
		}
		for (int row = 0; row < m; row++) {
			for (int column = 0; column < n; column++) {
				matrixB[row][column] = scan.nextInt();
				addition[row][column] = matrixA[row][column] + matrixB[row][column];
				for (int iRow = 0; iRow < m; iRow++) {
					multiplication[iRow][column] += matrixA[iRow][row] * matrixB[row][column];
				}
			}
		}
		for (int row = 0; row < m; row++) {
			for (int column = 0; column < n; column++) {
				System.out.print(column < n - 1 ? addition[row][column] + " " : addition[row][column] + "\n");
			}
		}
		for (int row = 0; row < m; row++) {
			for (int column = 0; column < n; column++) {
				System.out
						.print(column < n - 1 ? multiplication[row][column] + " " : multiplication[row][column] + "\n");
			}
		}
	}
}
