package prepbytes.topic.array;

import java.io.IOException;
import java.util.Scanner;

public class FindTheLeader {

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		byte t = sc.nextByte();
		while (t-- > 0) {
			int[] arr = new int[sc.nextInt()];
			for (int i = 0; i < arr.length; i++)
				arr[i] = sc.nextInt();
			int max = Integer.MIN_VALUE;
			for (int i = arr.length - 1; i >= 0; i--) {
				if (arr[i] >= max) {
					max = arr[i];
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
		}
	}

}
