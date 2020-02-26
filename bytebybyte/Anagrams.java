package bytebybyte;

import java.util.Scanner;

public class Anagrams {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s1 = scan.next();
		String s2 = scan.next();
		if (null == s1 || s2 == null || s1.length() != s2.length()) {
			System.out.println("Not Anagrams");
		} else {
			boolean isAnagram = checkIfAnagram(s1, s2);
			String conclusion = s1 + " & " + s2;
			System.out.println(isAnagram ? (conclusion + " are anagrams") : conclusion + " are not anagrams");
		}
	}

	// s1 adds and s2 subtracts
	private static boolean checkIfAnagram(String s1, String s2) {
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		int[] arr = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			++arr[s1.charAt(i) - 'a'];
			--arr[s2.charAt(i) - 'a'];
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
