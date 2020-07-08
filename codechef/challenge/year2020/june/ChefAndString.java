package codechef.challenge.year2020.june;

import codechef.common.InputReader;
import codechef.common.OutputWriter;

public class ChefAndString {
	static InputReader in = new InputReader(System.in);
	static OutputWriter out = new OutputWriter(System.out);

	public static void main(String[] args) throws java.lang.Exception {
		try {
			byte t = Byte.parseByte(in.next());
			while (t-- > 0) {
				char[] input = in.next().toCharArray();
				int pairs = 0, n = input.length, index = 1;
				while (index < n) {
					if (input[index] != input[index - 1])
						pairs++;
					else if (index + 1 < n && input[index] != input[index + 1]) {
						index++;
						pairs++;
					}
					index+=2;
				}
				out.printLine(pairs);
				out.flush();
			}
		} catch (Exception e) {
		}
	}
}
