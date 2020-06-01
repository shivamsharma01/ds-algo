package prepbytes.topic.fundamentals;

import java.util.Scanner;

public class VPattern {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		sc.next();
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (j <= i)
					System.out.print(j);
				else
					System.out.print("  ");
			}
			for (int j = 5; j >= 1; j--) {
				if (j <= i)
					System.out.print(j);
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

}