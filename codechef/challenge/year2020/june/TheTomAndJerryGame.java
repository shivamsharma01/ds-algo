package codechef.challenge.year2020.june;

import codechef.common.InputReader;
import codechef.common.OutputWriter;

public class TheTomAndJerryGame {
	static InputReader in = new InputReader(System.in);
	static OutputWriter out = new OutputWriter(System.out);

	public static void main(String[] args) throws java.lang.Exception {
		try {
			int t = Integer.parseInt(in.next());
			while (t-- > 0) {
				getWins(Long.parseLong(in.next()));
				out.flush();
			}
		} catch (Exception e) {
		}
	}

	private static void getWins(long n) {
		long wins = 0;
		if (n % 2 == 1)
			wins = n / 2;
		else {
			long smallestNumberThatWins = 2;
			long temp = n;
			while (temp % 2 == 0) {
				smallestNumberThatWins <<= 1;
				temp /= 2;
			}
			wins = n / smallestNumberThatWins - (n % smallestNumberThatWins == 0 ? 1 : 0);
		}
		out.printLine(wins);
	}
}
