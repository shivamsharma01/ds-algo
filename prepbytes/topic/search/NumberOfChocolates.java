package prepbytes.topic.search;

import java.io.IOException;
import java.util.Scanner;

public class NumberOfChocolates {
	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long[] count = new long[100000];
		for (int i = 0; i < n; i++)
			count[scan.nextInt() - 1]++;
		for (int i = 1; i < count.length; i++)
			count[i] += count[i - 1];
		int q = scan.nextInt();
		while (q-- > 0)
			System.out.println(count[scan.nextInt() - 1]);
	}

}
