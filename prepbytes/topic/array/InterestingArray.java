package prepbytes.topic.array;

import java.util.Scanner;

public class InterestingArray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte testCases = scan.nextByte();
		while (testCases-- > 0) {
			int[] arr = new int[scan.nextInt()];
			boolean[] b = new boolean[10000000 + 1];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scan.nextInt();
				b[arr[i]] = true;
			}
			int k = scan.nextInt();
			System.out.println(getIndex(arr, b, k));
		}
	}

	private static String getIndex(int[] arr, boolean[] b, int k) {
		for (int i = arr.length - 1, left = 0; i > 0; i--) {
			left = k - arr[i];
			if (left < 0 || left > arr[i])
				continue;
			else if (b[left] == true)
				for (int j = 0; j < i; j++) {
					if (arr[j] == left)
						return j + " " + i;
				}
		}
		return "no answer";
	}

}