package prepbytes.topic.fundamentals;

import java.util.Scanner;

public class LeapYearOrNot {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			short year = scan.nextShort();
			if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}
