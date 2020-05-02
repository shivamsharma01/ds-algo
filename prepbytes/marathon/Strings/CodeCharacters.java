package prepbytes.marathon.Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeCharacters {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			String s = scan.next();
			int n = s.length(), subLength = 0, index = 0;
			char[] chars = new char[] { 'C', 'O', 'D', 'E' };
			List<Character> more = new ArrayList<>();
			for (char c : chars) {
				int len = n - s.replaceAll("" + c, "").length();
				if (len >= n / 4)
					more.add(c);
			}
			if (more.size() == 4) {
				System.out.println(0);
			} else {
				for (char c : chars) {
					if (!more.contains(c)) {
						subLength += n / 4 - (n - s.replaceAll("" + c, "").length());
					}
				}
				System.out.println(subLength);
			}
		}
	}
}
