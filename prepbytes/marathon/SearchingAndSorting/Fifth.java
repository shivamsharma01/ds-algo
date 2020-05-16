package prepbytes.marathon.SearchingAndSorting;

import java.util.Scanner;

public class Fifth {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			int N = scan.nextInt();
			int[] P = new int[N];
			int[] Q = new int[N];
			int[] V = new int[N];
			for (int i = 0; i < N; i++)
				P[i] = scan.nextInt();
			for (int i = 0; i < N; i++)
				Q[i] = scan.nextInt();
			for (int i = 0; i < N; i++)
				V[i] = scan.nextInt();
			int removed = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (P[i] < P[j] && Q[i] < Q[j] && V[i] < V[j]) {
						removed++;
						break;
					}
				}
			}
			System.out.println(removed);
		}
	}
}
