package prepbytes.topic.divideNconquer;

import java.io.IOException;
import java.util.Scanner;

public class SquareRoot {

	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			int n = scan.nextInt();
			System.out.println(sqrt(n));
		}
	}

	private static long sqrt(int n) {
		long left = 1, right = n, sq, next, middle = 1;
		while (left < right) {
			middle = left + (right - left) / 2;
			sq = middle * middle;
			System.out.println("middle is " + middle + " sq is" + sq);
			if (sq == n)
				return middle;
			else if (sq > n)
				right = middle;
			else {
				next = (middle + 1) * (middle + 1);
				if (next > n)
					return middle;
				else if (next == n)
					return middle + 1;
				else
					left = middle + 1;
			}
		}
		return middle;
	}

}
