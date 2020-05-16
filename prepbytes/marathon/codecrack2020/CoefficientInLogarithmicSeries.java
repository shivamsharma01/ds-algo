package prepbytes.marathon.codecrack2020;

import java.util.Scanner;

public class CoefficientInLogarithmicSeries {
	static int x1;
	static int y1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt(), p;
			if (n == 1)
				System.out.println(1);
			else {
				if (n % 3 == 0)
					p = -2;
				else
					p = 1;
				System.out.println(multiplicativeInverse(p, n, 1000000007));
			}
		}
	}

	private static long multiplicativeInverse(int a, int b, int m) {
		b = (b % m + m) % m;
		extendedEuclidean(b, m);
		int inverseB = ((x1 % m) + m) % m;
		return (((((long) a % m) + m) % m) * (inverseB % m)) % m;
	}

	public static int extendedEuclidean(int a, int b) {
		if (b == 0) {
			x1 = 1;
			y1 = 0;
			return a;
		}
		int result = extendedEuclidean(b, a % b);
		int x = y1, y = x1 - (a / b) * y1;
		y1 = y;
		x1 = x;
		return result;
	}

}
