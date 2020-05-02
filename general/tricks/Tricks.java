package general.tricks;

public class Tricks {

	public static void main(String[] args) {
		formatStringAndFillSpace();
		checkIfDoubleHasDecimal();
	}

	private static void formatStringAndFillSpace() {
		for (int i = 1; i <= 100; i++) {
			//
			String s = String.format("%16s", Integer.toBinaryString(i)).replace(' ', '0');
			System.out.println(s);
		}
	}

	private static void checkIfDoubleHasDecimal() {
		double a = 5;
		System.out.println(a); // 5.0
		if (a % 1 == 0)
			System.out.println((int) a); // 5

	}
}
