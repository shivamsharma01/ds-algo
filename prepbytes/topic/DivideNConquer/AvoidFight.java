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
		Arrays.sort(arr);
		System.out.println(getOperations(arr, k));
	}

	private static int getOperations(int[] arr, long k) {
		int n = arr.length - 1, operations = 0;
		while (arr[n] - arr[0] > k) {
			operations++;
			arr[n]--;
			arr[0]++;
			sortStart(arr);
			sortEnd(arr);
		}
		return operations;
	}

	private static void sortStart(int[] arr) {
		int pos = 0, n = arr.length - 1, temp;
		while (pos < n && arr[pos] >= arr[pos + 1])
			pos++;
		if (pos <= n) {
			temp = arr[pos];
			arr[pos] = arr[0];
			arr[0] = temp;
		}
	}

	private static void sortEnd(int[] arr) {
		int pos = arr.length - 1, n = pos, temp;
		while (pos > 0 && arr[pos] <= arr[pos - 1])
			pos--;
		if (pos >= 0) {
			temp = arr[pos];
			arr[pos] = arr[n];
			arr[n] = temp;
		}
	}

}
