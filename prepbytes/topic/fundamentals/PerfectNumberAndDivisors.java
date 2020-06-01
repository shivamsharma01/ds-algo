package prepbytes.topic.fundamentals;

import java.util.Scanner;

public class PerfectNumberAndDivisors {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		byte t = sc.nextByte();
		while (t-- > 0) {
			int num = sc.nextInt(), sum = 1;
			for (int i = 2; i <= num / 2; i++) {
				if (num % i == 0)
					sum += i;
			}
			System.out.println(sum == num && num != 1);
		}
	}

}