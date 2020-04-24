package prepbytes.topic.recursion;

import java.io.IOException;
import java.util.Scanner;

public class CrackThePassword {

	public static void main(String args[]) throws IOException {

		// write your code here
		Scanner scan = new Scanner(System.in);
		byte testCases = scan.nextByte();
		for (byte test = 0; test < testCases; test++) {
			password(scan.nextByte(), "");
		}
	}

	private static void password(byte length, String startsWith) {
		if (length == 1) {
			for (int i = 1; i < 10; i++) {
				System.out.println(startsWith + i);
			}
			return;
		}
		for (int i = 1; i < 10; i++) {
			password((byte) (length - 1), startsWith + i);
		}
	}

}
