package prepbytes.topic.sorting;

import java.io.IOException;
import java.util.Scanner;

public class TheLastGame {
	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			int[] arr = new int[scan.nextInt()];
			for (int i = 0; i < arr.length; i++)
				arr[i] = scan.nextInt();
			selectionSort(arr);
			System.out.println(arr[(arr.length - 1) / 2]);
		}
	}

	private static void selectionSort(int[] arr) {
		for (int i = 0, min, temp; i < arr.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min])
					min = j;
			}
			temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}

}
