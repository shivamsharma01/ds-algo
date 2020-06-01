package prepbytes.marathon.stackAndQueue;

import java.io.IOException;
import java.util.Scanner;

public class StackChallenge {
	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			int a = scan.nextInt(), b = scan.nextInt(), X = scan.nextInt();
			int[] A = new int[a], B = new int[b];
			A[0] = scan.nextInt();
			for (int i = 1; i < a; i++)
				A[i] = scan.nextInt() + A[i - 1];
			for (int i = 0; i < b; i++)
				B[i] = scan.nextInt();
			int sum = 0, count = 0, maxCount = Integer.MIN_VALUE;
			for (int i = 0; i < a; i++) {
				sum = X - A[i];
				if (sum < 0)
					break;
				count = i + 1;
				for (int j = 0; j < b; j++) {
					sum -= B[j];
					if (sum >= 0)
						count++;
				}
				maxCount = Math.max(count, maxCount);
			}
			count = 0;
			for (int j = 0; j < b; j++) {
				X -= B[j];
				if (X >= 0)
					count++;
			}
			maxCount = Math.max(count, maxCount);
			System.out.println(maxCount);
		}
	}
}
