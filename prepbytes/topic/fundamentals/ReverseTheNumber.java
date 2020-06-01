package prepbytes.topic.fundamentals;

import java.util.Scanner;

public class ReverseTheNumber {
	public static void main(String args[]) {
		int num = new Scanner(System.in).nextInt(), rev = 0;
		while (num != 0) {
			rev = rev * 10 + num % 10;
			num /= 10;
		}
		System.out.println(rev);
	}
}
