package prepbytes.marathon.logicbuilding;

import java.util.Scanner;

public class TableChair {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int m = sc.nextInt();
			long r1 = sc.nextLong();
			long r2 = sc.nextLong();
			long r3 = sc.nextLong();
			if (m % 4 == 1) { // we need 3 + 4i tables
				if (r3 <= 3 * r1 && r3 <= (r1 + r2))
					System.out.println(r3);
				else if (3 * r1 <= (r1 + r2))
					System.out.println(3 * r1);
				else
					System.out.println(r1 + r2);
			} else if (m % 4 == 2) { // we need 2 + 4i tables
				if (r2 <= 2 * r1 && r2 <= 2 * r3)
					System.out.println(r2);
				else if (2 * r1 <= 2 * r3)
					System.out.println(2 * r1);
				else
					System.out.println(2 * r3);
			} else if (m % 4 == 3) { // we need 1 + 4i tables
				if (r1 <= r2 + r3 && r1 <= 3 * r3)
					System.out.println(r1);
				else if (r2 + r3 <= 3 * r3)
					System.out.println(r2 + r3);
				else
					System.out.println(3 * r3);
			} else {
				System.out.println(0);
			}
		}
	}
}
