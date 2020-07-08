package codechef.challenge.year2020.june;

import codechef.common.InputReader;
import codechef.common.OutputWriter;

public class EvenMatrix {
	static InputReader in = new InputReader(System.in);
	static OutputWriter out = new OutputWriter(System.out);

	public static void main(String[] args) throws java.lang.Exception {
		try {
			byte t = Byte.parseByte(in.next());
			while (t-- > 0) {
				short n = Short.parseShort(in.next());
				evenMatrix(n);
				out.flush();
			}
		} catch (Exception e) {
		}
	}

	private static void evenMatrix(short n) {
		int counter = 1;
		if (n % 2 == 1) {
			for (short i = 0; i < n; i++) {
				for (short j = 0; j < n; j++) {
					out.print(counter++ + " ");
				}
				out.printLine();
			}
		} else {
			for (short i = 0; i < n; i++) {
				if (i % 2 == 0) {
					for (short j = 0; j < n; j++) {
						out.print(counter++ + " ");
					}
				} else {
					counter++;
					for (short j = 0; j < n; j += 2) {
						out.print(counter-- + " ");
						out.print(counter + " ");
						counter += 3;
					}
					counter--;
				}
				out.printLine();
			}
		}
	}
}
