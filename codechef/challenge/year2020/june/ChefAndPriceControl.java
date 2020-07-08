package codechef.challenge.year2020.june;

import codechef.common.InputReader;
import codechef.common.OutputWriter;

public class ChefAndPriceControl {
	static InputReader in = new InputReader(System.in);
	static OutputWriter out = new OutputWriter(System.out);

	public static void main(String[] args) throws java.lang.Exception {
		try {
			byte t = Byte.parseByte(in.next());
			while (t-- > 0) {
				short n = Short.parseShort(in.next()), k = Short.parseShort(in.next());
				int lost = 0;
				short cur;
				for (short i = 0; i < n; i++) {
					cur = Short.parseShort(in.next());
					if (cur > k)
						lost += cur - k;
				}
				out.printLine(lost);
				out.flush();
			}
		} catch (Exception e) {
		}
	}
}
