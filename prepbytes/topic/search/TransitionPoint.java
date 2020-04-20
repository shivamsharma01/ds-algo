package prepbytes.topic.search;

import java.util.Scanner;

public class TransitionPoint {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			byte[] arr = new byte[scan.nextInt()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scan.nextByte();
			}
			System.out.println(getIndexOfFirstZero(arr));
		}
	}

	private static int getIndexOfFirstZero(byte[] arr) {
		int left = 0, middle = 0, right = arr.length - 1;
		while (left <= right) {
			middle = (right + left) / 2;
			if (arr[middle] == 1) {
				if (middle > 0 && arr[middle - 1] > 0) {
					right = middle - 1;
				} else {
					return middle;
				}
			} else if (arr[middle] < 1)
				left = middle + 1;
		}
		return arr[middle] == 1 ? middle : -1;
	}

}
