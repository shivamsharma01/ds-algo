package prepbytes.topic.DivideNConquer;

import java.util.Arrays;
import java.util.Scanner;

public class AvoidFight {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		long k = sc.nextInt();
		for (int i = 0; i < arr.length; i++)
			arr[i] = sc.nextInt();
		System.out.println(getOperations(arr, k));
	}

	private static int getOperations(int[] arr, long k) {
		int n = arr.length - 1, operations = 0;
		if (n == 1)
			return 0;
		Arrays.sort(arr);
		while (arr[n]-- - arr[0]++ > k) {
			operations++;
			if (arr[n - 1] > arr[n] || arr[1] < arr[0])
				Arrays.sort(arr);
		}
		return operations;
	}

}
