package codechef.challenge.year2020.january;

import java.util.Scanner;

public class ChefAndDynamo {

	public static void main(String[] args) throws java.lang.Exception {
		try {
			Scanner sc = new Scanner(System.in);
			short t = sc.nextShort();
			while (t-- > 0) {
				int N;
				long perfectNum = 1;
				N = sc.nextInt();
				while (N-- > 0)
					perfectNum *= 10;
				System.out.println(perfectNum);
				System.out.println(sc.nextLong() + 2 * perfectNum);
				System.out.println(perfectNum - sc.nextLong());
				System.out.println(perfectNum - sc.nextLong());
				if (sc.nextInt() == -1)
					break;
			}
		} catch (Exception e) {
		}
	}
}
