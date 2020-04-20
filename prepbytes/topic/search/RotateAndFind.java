package prepbytes.topic.search;

import java.util.Scanner;

public class RotateAndFind {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			int[] arr = new int[scan.nextInt()];
			for (int i = 0; i < arr.length; i++)
				arr[i] = scan.nextInt();
			System.out.println(rotateArraySearch(arr, scan.nextInt()));
		}
	}

	private static int rotateArraySearch(int[] arr, int target) {
		System.out.println("searching " + target);
		int left = 0;
		int right = arr.length - 1;
		int middle;
		while (left <= right) {
			middle = (right + left) / 2;
			System.out.print(" | left=" + left + " middle=" + middle + " right=" + right);
			if (arr[middle] == target)
				return middle;
			else if (arr[middle] <= arr[right]) {
				if (target > arr[middle] && target <= arr[right]) {
					left = middle + 1;
				} else {
					right = middle - 1;
				}
			} else {
				if (target < arr[middle] && target >= arr[left]) {
					right = middle - 1;
				} else {
					left = middle + 1;
				}
			}
		}
		return -1;
	}

}
