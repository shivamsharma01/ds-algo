package leetcode.problems.easy;

// https://leetcode.com/problems/buddy-strings/
public class BuddyStrings {

	public static void main(String[] args) {
		System.out.println(new BuddyStrings().buddyStrings("ab", "ba"));
		System.out.println(new BuddyStrings().buddyStrings("ab", "ab"));
		System.out.println(new BuddyStrings().buddyStrings("bb", "bb"));
		System.out.println(new BuddyStrings().buddyStrings("aa", "aa"));
		System.out.println(new BuddyStrings().buddyStrings("aa", "bb"));
		System.out.println(new BuddyStrings().buddyStrings("aa", "ab"));
		System.out.println(new BuddyStrings().buddyStrings("a", "b"));
		System.out.println(new BuddyStrings().buddyStrings("aaaaaaabc", "aaaaaaacb"));
		System.out.println(new BuddyStrings().buddyStrings("", "aa"));
	}

	public boolean buddyStrings(String A, String B) {
		if (A.length() != B.length() || A.length() < 2)
			return false;
		char[] temp = A.toCharArray();
		int[] arr = new int[26];
		int[] it = new int[2];
		boolean repeatingChar = false;
		int count = 2, index = 0, j;
		while (count != 0 && index < A.length()) {
			if (!repeatingChar) {
				j = A.charAt(index) - 'a';
				arr[j]++;
				if (arr[j] > 1) {
					repeatingChar = true;
				}
			}
			if (A.charAt(index) != B.charAt(index++)) {
				if (count == 2)
					it[0] = index - 1;
				else
					it[1] = index - 1;
				count--;
			}
		}
		char c = temp[it[0]];
		if (count == 0) {
			temp[it[0]] = temp[it[1]];
			temp[it[1]] = c;
			return new String(temp).equals(B);
		} else if (count == 1) {
			return false;
		} else {
			return repeatingChar;
		}
	}

}
