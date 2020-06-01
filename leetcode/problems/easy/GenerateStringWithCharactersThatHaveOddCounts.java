package leetcode.problems.easy;

import java.util.Arrays;

// https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/
public class GenerateStringWithCharactersThatHaveOddCounts {

	public static void main(String[] args) {
		GenerateStringWithCharactersThatHaveOddCounts o = new GenerateStringWithCharactersThatHaveOddCounts();
		for (int i = 1; i <= 25; i++)
			System.out.println(o.generateTheString(i));
	}

	public String generateTheString(int n) {
		char[] c = new char[n];
		Arrays.fill(c, 'a');
		if (n % 2 == 0)
			c[c.length - 1] = 'b';
		return new String(c);
	}

}
