package prepbytes.topic.search;

import java.io.IOException;
import java.util.Scanner;

public class MajorityVotes {
	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			int[] arr = new int[scan.nextInt()];
			int elem = -1, count = 1;
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scan.nextInt();
				if (elem == arr[i])
					count++;
				else {
					count--;
					if (count == 0) {
						count = 1;
						elem = arr[i];
					}
				}
			}
			count = 0;
			for (int i = 0; i < arr.length; i++) {
				if (elem == arr[i])
					count++;
			}
			if (count * 2 > arr.length)
				System.out.println(elem);
			else
				System.out.println(-1);
		}
	}

}
