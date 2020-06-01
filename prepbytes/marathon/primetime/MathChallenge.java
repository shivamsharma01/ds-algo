package prepbytes.marathon.primetime;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MathChallenge {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		for (int i = 1, cur; i < n; i++) {
			cur = arr[i] - arr[i - 1];
			if (min > cur)
				min = cur;
		}
		System.out.println(min);
	}
}
