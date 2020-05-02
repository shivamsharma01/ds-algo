package prepbytes.marathon.Strings;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FirstCharacter {
	public static void main(String args[]) throws IOException {

		// write your code here
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			String input = scan.next(), s1, s2;
			Set<String> s = new HashSet<String>();

			for (int i = 0; i < input.length(); i++)
				for (int j = 1; i + 2 * j <= input.length(); j++) {
					s1 = input.substring(i, i + j);
					s2 = input.substring(i + j, i + 2 * j);
					if (s1.equals(s2))
						s.add(s1 + s2);
				}

			System.out.println(s.size());
		}
	}
}
