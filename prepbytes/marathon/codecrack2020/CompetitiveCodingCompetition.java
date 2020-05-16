package prepbytes.marathon.codecrack2020;

import java.io.IOException;
import java.util.Scanner;

public class CompetitiveCodingCompetition {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		byte t = sc.nextByte();
		while (t-- > 0) {
			int[] arr = new int[sc.nextInt()];
			int x = sc.nextInt();
			for (int i = 0; i < arr.length; i++)
				arr[i] = sc.nextInt();
			int larger = 0, attempted = 0, index = 0;
			while (larger != 2 && index < arr.length) {
				if (arr[index++] <= x)
					attempted++;
				else
					larger++;
			}
			System.out.println(attempted);
		}
	}
}
