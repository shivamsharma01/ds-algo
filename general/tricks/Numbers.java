package general.tricks;

import java.text.DecimalFormat;

public class Numbers {
	public static void main(String[] args) {
		double d = 4.555d;
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println(df.format(d)); // no roundoff
		System.out.println(String.format("%.2f", d)); // round off
	}

	// 3 -> 4, 4-> 8, 6->8
	private static int getNextPower2(int n) {
		int p = 1;
		while (p <= n)
			p <<= 1;
		return 2 * p;
	}
}
