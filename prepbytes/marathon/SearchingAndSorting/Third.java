package prepbytes.marathon.SearchingAndSorting;

import java.util.Scanner;

public class Third {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] counter = new int[100000 + 1];
		for (int i = 0; i < n; i++)
			counter[scan.nextInt()]++;
		long[] up = new long[100000 + 1];
		for (int i = 1; i < up.length; i++)
			up[i] = up[i - 1] + i * counter[i];
		int Q = scan.nextInt();
		while (Q-- > 0) {
			int X = scan.nextInt();
			int Y = scan.nextInt();
			long sum = 0;
			X = Math.min(X, 100000);
			Y = Math.min(Y, 100000);
			sum = up[X - 1] + (up[100000] - up[Y]);
			System.out.println(sum);
		}
	}

}
