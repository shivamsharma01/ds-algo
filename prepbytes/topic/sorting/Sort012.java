package prepbytes.topic.sorting;

import java.io.IOException;
import java.util.Scanner;

public class Sort012 {

	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			int[] arr = new int[scan.nextInt()];
			for (int i = 0; i < arr.length; i++)
				arr[i] = scan.nextInt();
			int i = 0, j = 0, temp;
			while (j != arr.length) {
				if (arr[j] == 0) {
					temp = arr[i];
					arr[i] = 0;
					arr[j] = temp;
					i++;
				}
				j++;
			}
			j--;
			i = j;
			while (j >= 0 && arr[j] != 0) {
				if (arr[j] == 2) {
					temp = arr[i];
					arr[i] = 2;
					arr[j] = temp;
					i--;
				}
				j--;
			}
			for (i = 0; i < arr.length; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
		}
	}

}