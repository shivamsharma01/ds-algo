package prepbytes.marathon.codecrack2020;

import java.util.Scanner;

public class GreenArrowPracticeMission {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		byte t = sc.nextByte();
		while (t-- > 0) {
			int n = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt(), p = sc.nextInt();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int min = Math.max(Math.abs(x - i), Math.abs(y - j));
					System.out.print(Math.max(0, p - min) + " ");
				}
				System.out.println();
			}
		}
	}
}
