package prepbytes.topic.divideNconquer;

import java.util.Scanner;

public class MinimumValue {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			String input = scan.next();
			System.out.println(getMinimumValue(input));
		}
	}

	private static int getMinimumValue(String input) {
		int length = input.length(), p = input.length() / 2 + 1;
		char[] cArr = input.toCharArray();
		char c = cArr[0];
		boolean[] store = new boolean[26];
		for (int i = 0; i < length - 1; c = cArr[++i]) {
			if (store[c - 'a'] == true)
				continue;
			store[c - 'a'] = true;
			int curP = i + 1, count = 0;
			for (int j = i + 1; j < length && count < p - 1; j++) {
				if (c != cArr[j]) {
					count++;
					continue;
				}
				if (count > (curP - 1))
					curP = count + 1;
				count = 0;
			}
			if (count > curP - 1)
				curP = count + 1;
			p = Math.min(p, curP);
		}
		return p;
	}

}
