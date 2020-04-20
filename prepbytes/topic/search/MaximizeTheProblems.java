package prepbytes.topic.search;

import java.io.IOException;
import java.util.Scanner;

public class MaximizeTheProblems {
	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(System.in);
		byte n = scan.nextByte();
		short k = (short) (240 - scan.nextShort());
		int count = 0;
		for (byte i = 1; i <= n && i * 5 <= k; k -= i * 5, i++) {
			count++;
		}
		System.out.println(count);
	}
}
