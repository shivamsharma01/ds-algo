package prepbytes.miscellaneous;

public class ModOfLargeNumber {
	public static void main(String[] args) {
		String num = "32237826348759842398478236478236489232890798";
		int mod = 10;
		System.out.println(calculateMod(num, mod));
	}

	private static int calculateMod(String num, int mod) {
		int result = 0;
		for (int i = 0; i < num.length(); i++) {
			result = result * 10 + num.charAt(i) - '0';
			result = result % mod;
		}
		return result;
	}
}
