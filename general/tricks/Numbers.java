package general.tricks;

import java.text.DecimalFormat;

public class Numbers {
	public static void main(String[] args) {
		double d = 4.555d;
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println(df.format(d)); // no roundoff
		System.out.println(String.format("%.2f", d)); // round off
	}
}
