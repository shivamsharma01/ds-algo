package leetcode.problems.easy;

// https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
public class DecryptStringFromAlphabetToIntegerMapping {

	public static void main(String[] args) {
		System.out.println(new DecryptStringFromAlphabetToIntegerMapping().freqAlphabets("10#11#12"));
	}

	public String freqAlphabets(String s) {
		StringBuilder sb = new StringBuilder("");
		int index = s.length() - 1;
		while (index > -1) {
			while (index > -1 && s.charAt(index) != '#')
				sb.insert(0, (char) ('a' + s.charAt(index--) - '1'));
			if (index > 0)
				sb.insert(0, (char) ('a' + Integer.parseInt(s.substring(index - 2, index)) - 1));
			index -= 3;
		}
		return sb.toString();
	}

}
