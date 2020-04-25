package prepbytes.topic.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class TheFamousPythagoreanTriplet {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			long[] n = new long[scan.nextInt()];
			for (int i = 0; i < n.length; i++) {
				n[i] = scan.nextInt();
			}
			System.out.println(findTriplet(n, n.length));
		}
	}

	static String findTriplet(long arr[], int n) {
		for (int i = 0; i < n; i++)
			arr[i] = arr[i] * arr[i];
		Arrays.sort(arr);
		for (int i = n - 1; i >= 2; i--) {
			int b = 0;
			int c = i - 1;
			while (b < c) {
				if (arr[b] + arr[c] == arr[i]) {
					return "Yes";
				}
				if (arr[b] + arr[c] < arr[i])
					b++;
				else
					c--;
			}
		}
		return "No";
	}

}
