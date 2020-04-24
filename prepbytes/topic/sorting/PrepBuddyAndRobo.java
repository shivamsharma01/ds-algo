package prepbytes.topic.sorting;

import java.util.Scanner;

public class PrepBuddyAndRobo {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		short t = scan.nextShort();
		while (t-- > 0) {
			String N = scan.next();
			System.out.println(isContinous(N) ? "YES" : "NO");
		}
	}

	private static boolean isContinous(String s) {
		String result = "";
		for (int i = 0, n; i < 10; i++) {
			n = s.length() - s.replaceAll("" + i, "").length();
			if (n > 1)
				return false;
			else if (n == 1)
				result += i;
		}
		for (int i = 0; i < result.length() - 1; i++) {
			if ((result.charAt(i + 1) - '0') - (result.charAt(i) - '0') != 1)
				return false;
		}
		return true;
	}

}
