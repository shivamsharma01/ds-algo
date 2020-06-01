package prepbytes.marathon.primetime;

import java.io.IOException;
import java.util.Scanner;

public class SpecialDistance {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		char[] a = sc.nextLine().toCharArray(), b = sc.nextLine().toCharArray();
		int sum = 0;
		for (int i = 0; i <= b.length - a.length; i++) {
			for (int j = i; j < i + a.length; j++) {
				if (a[j - i] != b[j])
					sum += 2;
			}
		}
		System.out.println(sum);
	}
}
