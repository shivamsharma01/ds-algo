package prepbytes.topic.string;

import java.util.Scanner;

public class NobelString {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		byte testCases = scan.nextByte();
		for (byte test = 0; test < testCases; test++) {
			String output = "YES";
			String input = scan.next();
			boolean isConstant = false;
			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				if (isVowel(c)) {
					isConstant = false;
				} else if (isConstant && !isVowel(c)) {
					output = "NO";
					break;
				} else if (!isVowel(c) && !isN(c)) {
					isConstant = true;
				}
			}
			if (isConstant) {
				output = "NO";
			}
			System.out.println(output);
		}
	}

	private static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

	private static boolean isN(char c) {
		return c == 'n';
	}

}
