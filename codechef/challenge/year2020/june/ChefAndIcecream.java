package codechef.challenge.year2020.june;

import codechef.common.InputReader;
import codechef.common.OutputWriter;

public class ChefAndIcecream {
	static InputReader in = new InputReader(System.in);
	static OutputWriter out = new OutputWriter(System.out);

	public static void main(String[] args) throws java.lang.Exception {
		try {
			byte t = Byte.parseByte(in.next());
			while (t-- > 0) {
				short n = Short.parseShort(in.next());
				out.printLine(isPossible(n) ? "YES" : "NO");
				out.flush();
			}
		} catch (Exception e) {
		}
	}

	private static boolean isPossible(short n) {
		short index = 0, balanceZero = 0, balanceTen = 0, val;
		boolean output = true;
		while (index++ < n) {
			val = Short.parseShort(in.next());
			switch (val) {
			case 5:
				balanceZero++;
				break;
			case 10:
				balanceZero--;
				balanceTen++;
				break;
			case 15:
				if(balanceTen > 0)
					balanceTen--;
				else
					balanceZero-=2;
				break;
			}
			if (balanceZero < 0) {
				output = false;
				while (index++ < n)
					in.next();
			}
		}
		return output;
	}

}
