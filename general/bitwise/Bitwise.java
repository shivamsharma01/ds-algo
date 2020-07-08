package general.bitwise;

public class Bitwise {
	public static void main(String[] args) {
		// How to set a bit in the number ‘num’
		int num = 4;
		// 4 = 100 . we set leftmost 0 to 1 => 1(0)0 to 1(1)0 = 6
		num |= (1 << 1);
		System.out.println(num);
		// -------------------------------------------------

		// How to unset/clear a bit at n’th position in the number ‘num’
		num = 12;
		// 12 = 1100 . we unset 1st setbit from right => 1(1)00 to 1(0)00 = 8
		num &= (~(1 << 2));
		System.out.println(num);
		// -------------------------------------------------

		// Toggling a bit at nth position
		num = 12;
		// 12 = 1100 . we toggle 2nd bit from right = 11(0)0 to 11(1)0 = 14
		num ^= (1 << 1);
		System.out.println(num);
		// -------------------------------------------------

		// Checking if bit at nth position is set or unset
		num = 12;
		// 12 = 1100 . we check if 3nd bit from right is set = 1(1)00 = true
		System.out.println((num & (1 << 2)) != 0);
		// -------------------------------------------------

		// Inverting every bit of a number/1’s complement
		num = 12;
		// 12 = 1100 . inverted = 10011 (-16+3=-13)
		System.out.println(~num);
		// -------------------------------------------------

		// Two’s complement of the number (negative of the number)
		num = 12;
		// 12 = 1100 . inverted = -12
		System.out.println(-num);
		// or
		System.out.println(~num + 1);
		// -------------------------------------------------

		// Stripping off the lowest set bit
		num = 6;
		// 6 = 110. after stripping lowest 1(1)0 = 1(0)0 = 4
		// let x = 6(110) then x-1 = 5(101)
		System.out.println("Stripping off the lowest set bit, num =" + (num) + " -> " + (num & (num - 1)));
		// -------------------------------------------------

		// Getting lowest set bit of a number:
		num = 12;
		// 12 = 1(1)00
		System.out.println(Integer.valueOf((num & (~num + 1))));
		// or
		System.out.println(Integer.valueOf((num & (-num))));

	}
}
