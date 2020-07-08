package codechef.challenge.year2020.january;

import java.util.Scanner;

public class Doraemon {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			byte t = sc.nextByte();
			while (t-- > 0) {
				doraemonMatrix(sc);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void doraemonMatrix(Scanner sc) {
		int N = sc.nextInt(), M = sc.nextInt();
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				arr[i][j] = sc.nextInt();
		}
		System.out.println(getPairs(arr, N, M));
	}

	private static long getPairs(int[][] arr, int n, int m) {
		long count = n * m;
		if (n <= 2 || m <= 2)
			return count;
		int curRow = n / 2, curCol = 1, step = 1;

		if (n % 2 == 1) {
			while (curCol <= m - 2) {
				int len = 1;
				while (curRow - len >= 0 && curCol - len >= 0 && curCol + len < m) {
					if (arr[curRow - len][curCol] == arr[curRow + len][curCol]
							&& arr[curRow][curCol - len] == arr[curRow][curCol + len])
						count++;
					else
						break;
					len++;
				}
				curCol++;
			}
			step = 2;
		}
		curRow--;
		while (curRow >= 1) {
			curCol = 1;
			while (curCol <= m - 2) {
				int len = 1;
				while (curRow - len >= 0 && curCol - len >= 0 && curCol + len < m) {
					if (arr[curRow - len][curCol] == arr[curRow + len][curCol]
							&& arr[curRow][curCol - len] == arr[curRow][curCol + len])
						count++;
					else
						break;
					len++;
				}
				curCol++;
			}
			int botRow = curRow + step;
			curCol = 1;
			while (curCol <= m - 2) {
				int len = 1;
				while (botRow + len < n && curCol - len >= 0 && curCol + len < m) {
					if (arr[botRow - len][curCol] == arr[botRow + len][curCol]
							&& arr[botRow][curCol - len] == arr[botRow][curCol + len])
						count++;
					else
						break;
					len++;
				}
				curCol++;
			}
			step += 2;
			curRow--;
		}
		return count;
	}

}
