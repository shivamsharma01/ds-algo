package prepbytes.marathon.codecrack2020;

import java.io.IOException;
import java.util.Scanner;

public class LongBadmintonGame {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int N = sc.nextInt();
			int n = sc.nextInt();
			String s = sc.next();
			if (s.charAt(s.length() - 1) == 'C')
				System.out.println("CAROLINA");
			else
				System.out.println("SINDHU");
		}
	}
}
