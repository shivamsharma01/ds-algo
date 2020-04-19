package prepbytes.miscellaneous;

import java.io.IOException;
import java.util.Scanner;

public class ExtendedEuclideanAlgo {
	int x1;
	int y1;

	public static void main(String args[]) throws IOException {
		System.out.println(new ExtendedEuclideanAlgo().extendedEuclidean(3, 7));
	}

	public int extendedEuclidean(int a, int b) {
		if (b == 0) {
			x1 = 1;
			y1 = 0;
			return a;
		}
		int result = extendedEuclidean(b, a % b);
		System.out.println("x value is " + x1 + " " + y1);
		int x = y1, y = x1 - ((int) a / b) * y1;
		y1 = y;
		x1 = x;
		System.out.println("x value is " + x1 + " " + y1);
		return result;
	}

}
