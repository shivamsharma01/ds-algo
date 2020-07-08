package prepbytes.marathon.tree;

import java.io.IOException;
import java.util.Scanner;

public class FindMinMax {

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int N = sc.nextInt();
			int min = (N & (N - 1)) + 1;
			int rightmostBit = N ^ (N & (N - 1));
			int max = N | (rightmostBit - 1);
			System.out.println(min + " " + max);
		}
	}

}
