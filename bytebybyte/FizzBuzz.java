package bytebybyte;

import java.util.Scanner;

public class FizzBuzz {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		printFizzBuzz(n);
	}

	private static void printFizzBuzz(int n) {
		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0) {
				System.out.println("Fizz");
			}else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
	}

}
