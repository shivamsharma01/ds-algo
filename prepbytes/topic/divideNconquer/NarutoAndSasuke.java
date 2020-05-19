package prepbytes.topic.divideNconquer;

import java.util.Scanner;

public class NarutoAndSasuke {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(), B = sc.nextInt(), K = sc.nextInt(), X = sc.nextInt(), Y = sc.nextInt();
		System.out.println(getNarutoGems(A, B, K, X, Y));
	}

	private static int getNarutoGems(int A, int B, int K, int X, int Y) {
		int left = 0, right = K, middle, power;
		while (left < right) {
			middle = left + (right - left) / 2;
			power = GetPower(A, B, K, middle, X, Y);
			if (power == 0)
				return middle;
			else if (power > 0)
				right = middle;
			else
				left = middle + 1;
		}
		return -1;
	}

	private static int GetPower(int a, int b, int k, int middle, int x, int y) {
		return (a + x * middle) - (b + (k - middle) * y);
	}

}
