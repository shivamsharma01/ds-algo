package prepbytes.topic.DivideNConquer;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumDifference {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			int[] arr = new int[scan.nextInt()];
			for (int i = 0; i < arr.length; i++)
				arr[i] = scan.nextInt();
			int k = scan.nextInt();
			Arrays.sort(arr);
			System.out.println(minimumDifference(arr, k));
		}
	}

	private static int minimumDifference(int[] arr, int sum) {
		int dif = Integer.MAX_VALUE;
		for (int i = 0, curSum; i < arr.length - 2; i++) {
			int left = i + 1, right = arr.length - 1;
			while (left < right) {
				curSum = arr[i] + arr[left] + arr[right];
				if (curSum == sum)
					return 0;
				else if (curSum > sum)
					right--;
				else
					left++;
				dif = Math.min(dif, Math.abs(sum - curSum));
			}
		}
		return dif;
	}

}