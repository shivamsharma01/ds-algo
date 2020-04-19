package prepbytes.miscellaneous;

public class ModularExponentiation {
	public static void main(String[] args) {
		System.out.println(modularExponentiation(6, 3, 5));
		System.out.println(modularExponentiation(1000, 45, 90));
	}

	// (a^b)mod(m)
	private static int modularExponentiation(int a, int b, int m) {
		if (a == 0)
			return 0;
		else if (b == 0)
			return 1;
		int result;
		if (b % 2 == 0) {
			result = modularExponentiation(a, b / 2, m);
			result = ((result % m) * (result % m)) % m;
		} else {
			result = a % m;
			result = result * modularExponentiation(a, b - 1, m);
		}
		return (result % m + m) % m;
	}
}
