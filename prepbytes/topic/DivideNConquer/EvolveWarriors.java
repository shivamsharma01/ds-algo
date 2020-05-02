package prepbytes.topic.DivideNConquer;

import java.util.Scanner;

public class EvolveWarriors {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			long n = scan.nextLong(), m = scan.nextLong();
			int x = scan.nextInt(), y = scan.nextInt();
			System.out.println("n=" + n + " m=" + m + " x=" + x + " y=" + y);
			System.out.println("Answer -> " + evolveHeroes(n, m, x, y));
			System.out.println("===================================================");
		}
	}

	private static long evolveHeroes(long n, long m, int x, int y) {
		long evolved = 0, left = 0, right = n, middle = 0;
		while (left < right) {
			middle = left + (right - left) / 2;
			evolved = evolve(n - middle, m, x, y);
			if (evolved == middle)
				return middle;
			else if (evolved < middle) {
				evolved = evolve(n - (middle - 1), m, x, y);
				if (evolved >= middle - 1)
					return middle - 1;
				else if (middle - 1 == 0 && evolved >= middle - 1)
					return middle - 1;
				right = middle - 1;
			} else {
				evolved = evolve(n - (middle + 1), m, x, y);
				if (evolved < middle + 1)
					return middle;
				else if (middle + 1 == n && evolved >= middle + 1)
					return middle + 1;
				left = middle + 1;
			}
		}
		return middle;
	}

	private static long evolve(long killedHeroes, long m, int x, int y) {
		return (killedHeroes * y + m) / x;
	}

}