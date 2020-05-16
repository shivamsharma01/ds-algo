package prepbytes.topic.linkedlist;

import java.io.IOException;
import java.util.Scanner;

public class MiddleElement {

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int[] arr = new int[sc.nextInt()];
			for (int i = 0; i < arr.length; i++)
				arr[i] = sc.nextInt();
			System.out.println(getMiddle(arr));
		}
	}

	private static int getMiddle(int[] arr) {
		return arr[arr.length / 2];
	}

}
