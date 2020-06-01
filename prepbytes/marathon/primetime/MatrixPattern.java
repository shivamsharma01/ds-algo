package prepbytes.marathon.primetime;

import java.io.IOException;
import java.util.Scanner;

public class MatrixPattern {
	public static void main(String args[]) throws IOException {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			int arr[][] = new int[N][N];
			// INITIALIZE VAL ARRAY
			N *= N;
			int val[] = new int[N + 1];
			for (int i = 1; i <= N; i++)
				val[i] = i + val[i - 1];
			N = (int) Math.sqrt(N);
			int col = 0, row, i = 0, j = 0, index = 1;
			while (col < N) {
				i = 0;
				j = col++;
				while (j >= 0)
					arr[i++][j--] = val[index++];
			}
			index = N * N;
			col = N - 1;
			while (col >= 0) {
				i = N - 1;
				j = col--;
				while (j < N)
					arr[i--][j++] = val[index--];
			}
			for (i = 0; i < N; i++) {
				for (j = 0; j < N; j++)
					System.out.print(arr[i][j] + " ");
				System.out.println();
			}
		}
	}
}
