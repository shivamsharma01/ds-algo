package prepbytes.marathon.codecrack2020;

import java.io.IOException;
import java.util.Scanner;

public class Medicines {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n % 2 == 0)
			System.out.println("Sohum");
		else
			System.out.println("Aly");
	}
}
